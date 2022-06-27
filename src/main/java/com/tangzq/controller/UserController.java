package com.tangzq.controller;


import com.tangzq.model.User_me;
import com.tangzq.service.UserService;
import com.tangzq.utils.CommonProps;
import com.tangzq.utils.GravatarUtils;
import com.tangzq.utils.UploadUtil;
import com.tangzq.vo.UserPwdVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

/**
 * 用戶控制器
 * @author tangzhiqiang
 */
@Controller
@RequestMapping("/user")
public class UserController {


    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${upload.files.folder}")
    private String uploadFilesFolder;

    @Autowired
    private UserService userService;

    /**
     * 用戶主頁
     * @param username
     * @param model
     * @return
     */
    @RequestMapping(value = "/info/{username}",method = RequestMethod.GET)
    public String profilePage(@PathVariable("username") String username, ModelMap model) {
        User_me user=userService.findByUsername(username);
        model.addAttribute("userInfoForm",user==null?new User_me():user);
        return "user/user_info";
    }


    /**
     * 更新使用者資料
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/info/{username}",method = RequestMethod.POST)
    public String doUpdateInfo(@ModelAttribute("userInfoForm")User_me user, ModelMap model, RedirectAttributes redirectAttributes) {
        User_me updatedUser=userService.updateUserInfo(user);
        if(null!=updatedUser&&updatedUser.getUsername()!=null){
            redirectAttributes.addFlashAttribute("messageSuc","使用者資訊修改成功");
            return "redirect:/user/info/"+updatedUser.getUsername();
        }else{
            model.addAttribute("messageErr","使用者資訊修改失敗");
            return "user/user_info";
        }
    }


    /**
     * 跳轉到修改密碼頁面
     * @param model
     * @return
     */
    @RequestMapping(value = "/changePwd",method = RequestMethod.GET)
    public  String changePwd(ModelMap model){
        model.addAttribute("changePwdForm",new UserPwdVo());
        return "user/user_pwd";
    }


    @RequestMapping(value = "/changePwd",method = RequestMethod.POST)
    public String doChangePwd(@Valid @ModelAttribute("changePwdForm")UserPwdVo vo, BindingResult result,
                              ModelMap model,
                              RedirectAttributes redirectAttributes){

        if(result.hasErrors()){
            return "user/user_pwd";
        }
        if(!vo.getNewPwd().equals(vo.getRepeatNewPwd())){
            result.rejectValue("repeatNewPwd",null,"兩次輸入密碼不一致");
            return "user/user_pwd";
        }
        if(userService.isUserValid(vo.getUsername(),vo.getOldPwd())){
            User_me updatedUser=userService.updatePwd(vo.getUid(),vo.getNewPwd());

//           if(null!=updatedUser&& updatedUser.getId()!=null){
            if(null!=updatedUser&&Long.toString( updatedUser.getId()) !=null){
                redirectAttributes.addFlashAttribute("messageSuc","密碼修改成功");
                return "redirect:/user/changePwd";
            }else{
                model.addAttribute("messageErr","密碼修改失敗");
                return "user/user_pwd";
            }
        }else{
            model.addAttribute("messageErr","原始密碼錯誤");
            return "user/user_pwd";
        }
    }


    /**
     * 修改頭像頁面
     * @return
     */
    @RequestMapping(value = "/changeAvatar",method = RequestMethod.GET)
    public  String changeAvatar(){
        return "user/user_avatar";
    }

    @RequestMapping(value="/changeAvatar",method = RequestMethod.POST)
    public String doChangeAvatar(@RequestParam("file")MultipartFile file,
                                 @RequestParam("uid")String uid,
                                 HttpSession session,
                                 ModelMap model,
                                 RedirectAttributes redirectAttributes){

        if(null==file||file.isEmpty()){
            model.addAttribute("messageErr","頭像檔不能為空！");
            return "user/user_avatar";
        }

        try {
            String newFilename = UploadUtil.getNewFilename(file.getOriginalFilename());
            String absolutePath = UploadUtil.uploadImage(uploadFilesFolder,newFilename, file.getInputStream());
            logger.info("頭像保存成功，全路徑為："+absolutePath);
            User_me user=userService.updateAvatar(Integer.parseInt(uid),newFilename,Boolean.TRUE);
            //  if(null!=user&&user.getId()!=null){
            if(null!=user&&Long.toString( user.getId()) !=null){
                session.setAttribute(CommonProps.LOGIN_USER_SESSION_KEY,user);
                redirectAttributes.addFlashAttribute("messageSuc","頭像修改成功");
                return "redirect:/user/changeAvatar";
            }else{
                model.addAttribute("messageErr","頭像修改失敗");
                return "user/user_avatar";
            }
        } catch (IOException e) {
            logger.error("change avatar error",e);
            model.addAttribute("messageErr","修改頭像時出錯了");
            return "user/user_avatar";
        }
    }

    /**
     * 使用Avatar頭像
     * @param username
     * @param session
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value="/{username}/getAvatar/{email}")
    public String doGetAvatar(@PathVariable("username")String username,
                              @PathVariable("email")String email,
                              HttpSession session,
                              ModelMap model,
                              RedirectAttributes redirectAttributes){

        User_me user=userService.findByUsername(username);
        if(null==user){
            model.addAttribute("messageErr","無法獲取使用者資訊");
            return "user/user_avatar";
        }
//        User_me updatedUser= userService.updateAvatar(user.getId(), GravatarUtils.makeGravatar(email),Boolean.FALSE);
        User_me updatedUser= userService.updateAvatar( user.getId(), GravatarUtils.makeGravatar(email),Boolean.FALSE);
        // if(null!=updatedUser&&updatedUser.getId()!=null){
        if(null!=updatedUser&&Long.toString(updatedUser.getId())!=null){
            session.setAttribute(CommonProps.LOGIN_USER_SESSION_KEY,updatedUser);
            redirectAttributes.addFlashAttribute("messageSuc","獲取Avatar頭像成功");
            return "redirect:/user/changeAvatar";
        }else{
            model.addAttribute("messageErr","獲取Avatar頭像失敗");
            return "user/user_avatar";
        }

    }


}

