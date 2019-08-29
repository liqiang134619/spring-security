package com.example.springsecutirydemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @author Liq
 * @date 2019/8/28
 */
@Service
public class HelloService {


    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String helloService() {


        logger.info("【==> helloService】");
        logger.debug("【==> helloService】");
        logger.trace("【==> helloService】");
        logger.error("【==> helloService】");
        return "hello";
    }

}
