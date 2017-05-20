package com.dmsd.itoo.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 徐露
 *
 * @Date 2016/8/120:33
 */
@RequestMapping("/Index")
@Controller
public class indexController {

    /*
    首页向导
     */
    @RequestMapping(value={"{name}"},method= RequestMethod.GET)
    public String showCourse(@PathVariable("name")String name){
        return "Index";
    }





}
