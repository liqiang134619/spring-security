package com.example.springsecutirydemo.Controller;

import com.example.springsecutirydemo.service.HelloService;
import javax.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liq
 * @date 2019/8/27
 */
@RestController
public class BaseController {


    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);


    @Autowired
    HelloService helloService;


    @GetMapping("/hello")
    @PreAuthorize("hasRole('ADMIN')")
//    @RolesAllowed("ROLE_ADMIN")
    public String hello(@AuthenticationPrincipal UserDetails userDetails) {

        logger.info("【==> user:{}】",userDetails);
        logger.info("【==> users:{}】",userDetails.getAuthorities());
        String s = helloService.helloService();
        return "hello spring," + s;
    }


    @GetMapping("/hello1")
    @PreAuthorize("hasRole('USER')")
//    @RolesAllowed("ROLE_ADMIN")
    public String hello1(@AuthenticationPrincipal UserDetails userDetails) {

        logger.info("【==> user:{}】",userDetails);
        logger.info("【==> users:{}】",userDetails.getAuthorities());
        String s = helloService.helloService();
        return "hello spring," + s;
    }

}
