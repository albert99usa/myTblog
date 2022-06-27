package com.tangzq.controller;

//import com.tangzq.model.User;
//import com.tangzq.service.CategoryService;
//import com.tangzq.service.TopicService;
import com.tangzq.model.Category;
import com.tangzq.model.Reply;
import com.tangzq.model.Topic;
import com.tangzq.repository.CategoryRepository;
import com.tangzq.repository.ReplyRepository;
import com.tangzq.service.ReplyService;
import com.tangzq.service.UserService;
import com.tangzq.model.User_me;
import com.tangzq.repository.UserRepository;
//import com.tangzq.testUtils.curdTest;
import com.tangzq.utils.CommonProps;
import com.tangzq.utils.ValidateCode;
//import com.tangzq.vo.IndexVo;
import com.tangzq.vo.LoginUserVo;
//import com.tangzq.vo.RegisterUserVo;
//import com.tangzq.vo.SearchVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;




/**
 * 首頁控制器
 * @author tangzhiqiang
 */

@Controller
@Slf4j
@RequestMapping(value = "/")
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    public static final String VCODE_SESSION_KEY="validateCode";

//    @Value("${appname}")
    //   private String configAppName;

    @Autowired
    private UserService userService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private static SessionFactory sessionFactory;

    //
//
//    @Autowired
//    private TopicService topicService;
//
//    @Autowired
//    private CategoryService categoryService;
    @Autowired
    ReplyService replyService;


    /**
     * 跳轉到首頁
     * @param vo 首頁參數封裝
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/")
    public String home() {
//    public String home(IndexVo vo, ModelMap modelMap) {
//        modelMap.addAttribute("pager",topicService.findByPage(vo));
//        modelMap.addAttribute("catList",categoryService.findAll());
//        modelMap.addAttribute("indexVo",vo);
//        log.info(vo.toString());
//        User_me user1=  userRepository.findByUserName("admin");
//        User_me user1=  userRepository.findByUserName("admin");
        User_me user1=  userService.findByUsername("admin");
        //     List<Category> categoryList=  categoryRepository.findByName("admin");
        //     List<Reply> replies =  replyRepository.findAllByTopicid("1");
        //     Page<Topic> topicRepositories =  topicRepository.findByAuthorId("1");
//    curdTest.testInsert(sessionFactory);

//       List<Reply> =replyService.findReplyByTopicId()
        int  a=1;
        log.info("controller //  start");
//        return "article/show";
        return "index";
    }

    @RequestMapping(value="/search",method = RequestMethod.GET)
    public String search(){
//    public String search(SearchVo searchVo, ModelMap modelMap){
//        modelMap.addAttribute("searchVo",searchVo);
//        modelMap.addAttribute("pager",topicService.search(searchVo));
        return "search";
    }

    /**
     * 註冊頁面
     * @return
     */

//    @RequestMapping(value = "/register",method = RequestMethod.GET)
//    public String register(ModelMap model) {
//        model.addAttribute("registerForm",new RegisterUserVo());
//        return "register";
//    }
//
//
//    /**
//     * 用戶登錄
//     * @return
//     */
//    @RequestMapping(value="/register",method = RequestMethod.POST)
//    public String doegister(@Valid @ModelAttribute("registerForm") RegisterUserVo registerUser, BindingResult result,
//                            HttpSession session,
//                            ModelMap model,
//                            RedirectAttributes redirectAttributes){
//
//        if(result.hasErrors()){
//            return "register";
//        }
//
//        String vcodeInSession = (String) session.getAttribute(VCODE_SESSION_KEY);
//        String submitCode = registerUser.getValidateCode();
//        if (!StringUtils.equals(vcodeInSession,submitCode)) {
//            result.rejectValue("validateCode",null,"驗證碼錯誤!");
//        }
//        if(null!=userService.findByUsername(registerUser.getUsername())){
//            result.rejectValue("username",null,"該用戶名已經存在");
//        }
//        if(null!=userService.findUserByEmail(registerUser.getEmail())){
//            result.rejectValue("email",null,"該郵箱已經被註冊");
//        }
//        if(result.hasErrors()){
//            return "register";
//        }
//
//        User savedUser=userService.createUser(registerUser);
//        if(null!=savedUser&&savedUser.getId()!=null){
//            redirectAttributes.addFlashAttribute("messageSuc","註冊成功！");
//            return "redirect:/login";
//        }else{
//            model.addAttribute("messageErr","註冊失敗");
//            model.addAttribute("vo",registerUser);
//            return "register";
//        }
//    }
//
//
    /**
     * 登陸頁面
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(ModelMap model) {
        model.addAttribute("loginForm",new LoginUserVo());
        return "login";
    }
    /**
     * 用戶登錄
     * @return
     */
//    @RequestMapping(value="/login",method = RequestMethod.GET)

//    public String doLogin(HttpSession session){
/*
    public String doLogin(@Valid @ModelAttribute("loginForm") LoginUserVo user, BindingResult result,
                          HttpSession session,
                          ModelMap model,
                          RedirectAttributes redirectAttributes){
         */
//    @Autowired
//     HttpSession session;
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String doLogin(@Valid @ModelAttribute("loginForm") LoginUserVo user,
                          HttpSession session,
                          BindingResult result,
                          ModelMap model,
                          RedirectAttributes redirectAttributes){

        if(result.hasErrors()){
            return "login";
        }
        //  return "login";

        String vcodeInSession = (String) session.getAttribute(VCODE_SESSION_KEY);
        String submitCode = user.getValidateCode();

        if (!StringUtils.equals(vcodeInSession,submitCode)) {
            result.rejectValue("validateCode",null,"驗證碼錯誤!");
            return "login";
        }
        if(!userService.isUserValid(user.getUsername(),user.getPassword())){
            model.addAttribute("messageErr","用戶名或者密碼錯誤");
            return "login";
        }

        session.setAttribute(CommonProps.LOGIN_USER_SESSION_KEY,userService.findUser(user.getUsername(),user.getPassword()));
        return "redirect:/";
    }



    /**
     * 生成驗證碼
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/validateCode")
    public void validateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-cache");
        String verifyCode = ValidateCode.generateTextCode(ValidateCode.TYPE_ALL_MIXED, 4, null);
        request.getSession().setAttribute(VCODE_SESSION_KEY, verifyCode);
        response.setContentType("image/jpeg");
        BufferedImage bim = ValidateCode.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);
        ImageIO.write(bim, "JPEG", response.getOutputStream());
    }


    /**
     * 退出系統
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

    /**
     * 關於頁面
     * @return
     */
    @RequestMapping(value = "/about")
    public String about() {
        // return "about";
        return "/inc/pagination";
    }


}

