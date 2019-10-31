package com.example.demoserver.config;

import com.example.demoserver.dto.AppResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyAuthExceptionEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(MyAuthExceptionEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException)
            throws ServletException {
        AppResult appResult = new AppResult();
        if(authException instanceof InsufficientAuthenticationException){
            appResult.fail("登录凭据已失效");
            appResult.setCode("503");
        }else  if( authException.getCause() != null && authException.getCause().getClass().getSimpleName().equals("InvalidTokenException")){
            appResult.fail("登录凭据已失效");
            appResult.setCode("503");
        }
        else {
            appResult.fail("操作失败,请稍后重试");
        }
        logger.info("操作失败",authException);

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);

        try {
            ObjectMapper mapper = new ObjectMapper();

            mapper.writeValue(response.getOutputStream(), appResult);
        } catch (Exception e) {
            throw new ServletException();
        }
    }
}