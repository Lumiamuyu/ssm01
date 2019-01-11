package Lumiamuyu.web;

import Lumiamuyu.pojo.CookiesUtil;
import Lumiamuyu.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class TestMethod implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        CookiesUtil.getCookie(cookies);
        Map<String,Cookie> maps = CookiesUtil.getCookie(cookies);
        Cookie cookie = maps.get("username");
/*        System.out.println(cookie.getName()+" "+cookie.getValue());*/
/*        String username = cookie.getValue();*/

        return true;
        /*if (user.getUsername().equals(username)){
            return true;
        }else {
            return false;
        }*/

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        /*System.out.println(modelAndView.getViewName());*/
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
