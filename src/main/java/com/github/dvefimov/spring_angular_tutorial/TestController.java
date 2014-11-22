package com.github.dvefimov.spring_angular_tutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: техно сити
 * Date: 22.11.14
 * Time: 2:43
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "view";
    }
}
