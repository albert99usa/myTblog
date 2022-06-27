package com.tangzq.interceptor;

//import com.tangzq.model.User;
//import com.tangzq.utils.CommonProps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tangzhiqiang
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    /**
     * 攔截所有請求，並驗證是否登陸
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

/*
        User user =  (User) request.getSession().getAttribute(CommonProps.LOGIN_USER_SESSION_KEY);
        if(user == null){
            log.info("用戶沒有登陸：將跳轉到login頁面！");
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        */
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }


    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}

