package com.shopping.home.AOP.Visitor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Aspect
public class Visit {

    @Pointcut("execution(* com.shopping.home.Controller..*.*(..))")
    private void route(){}

    @Before("route()")
    public void check(){

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getResponse();

        Cookie[] cookies = request.getCookies();

        Cookie visit = new Cookie("visit", "true");
        visit.setMaxAge(-1);

        if(cookies==null){
            TotalVisit.add();
            response.addCookie(visit);
            return;
        }

        for(Cookie c:request.getCookies()){
            if(c.getName().equals("visit")){
                return;
            }
        }

        TotalVisit.add();
        response.addCookie(visit);
    }

}
