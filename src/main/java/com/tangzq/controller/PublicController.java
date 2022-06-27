package com.tangzq.controller;

//import com.tangzq.service.TopicService;
import com.tangzq.service.UserService;
import com.tangzq.vo.PageVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用戶控制器
 * @author tangzhiqiang
 */
@Controller
@RequestMapping("/pub")
public class PublicController {

    private final Logger logger = LoggerFactory.getLogger(PublicController.class);

    static final String TAB_COLLECT="collect";

    @Autowired
    private UserService userService;

//    @Autowired
//    private TopicService topicService;

    /**
     * 用戶詳情頁
     * @param userId
     * @return
     */
    @RequestMapping(value="/user/{userId}")
    public String userDetail(@PathVariable("userId")int userId,
                             @RequestParam(value = "tab",required = false)String tab,
                             PageVo pageVo, ModelMap model){
        if(StringUtils.isEmpty(Integer.toString(userId))||userService.getUser(userId)==null){
            return "error/404";
        }
        model.addAttribute("user",userService.getUser(userId) );
        model.addAttribute("tab",tab);
        /*
        if(TAB_COLLECT.equals(tab)){
            model.addAttribute("pager",
                   topicService.findCollectedTopicsByUidAndPage(userId,pageVo.getPageNO(),pageVo.getPageSize()));
        }else{
            model.addAttribute("pager",
                   topicService.findByUserIdAndPage(userId,pageVo.getPageNO(),pageVo.getPageSize()));
        }
        */
        return "user/user_detail";
    }

}

