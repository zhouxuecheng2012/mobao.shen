package com.mo.bao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hadoop on 2016/10/22.
 */
@Controller
@RequestMapping("/menu")
public class WcChatPageController {

    @GetMapping(value = "/list")
    public String list(HttpServletRequest request, HttpServletResponse response) {

        

        return "list";
    }

    @GetMapping(value = "/list1")
    public String list1(HttpServletRequest request, HttpServletResponse response) {



        return "list1";
    }

    @GetMapping(value = "/list2")
    public String list2(HttpServletRequest request, HttpServletResponse response) {



        return "list2";
    }



}
