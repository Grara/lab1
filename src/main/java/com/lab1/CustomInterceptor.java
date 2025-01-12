package com.lab1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse response, Object handler) throws Exception {
        log.debug("Request URI ===> " + req.getRequestURI());
        HttpSession session = req.getSession();
        Map<String, Object> sessionMap = (Map)session.getAttribute("userSession");
        if(sessionMap == null){
            response.sendRedirect("/login");
            return false;
        }
        List<Map<String, Object>> permittedUrl = (List)sessionMap.get("permittedUrl");

        for(Map<String, Object> item : permittedUrl){
            String url = (String)item.get("URL");
            if(url.equals(req.getRequestURI())){
                return true;
            }
        }

        log.debug("허가되지않은 URL입니다");
        response.sendRedirect("/");

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

}
