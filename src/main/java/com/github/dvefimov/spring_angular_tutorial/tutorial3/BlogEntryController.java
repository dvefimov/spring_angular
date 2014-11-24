package com.github.dvefimov.spring_angular_tutorial.tutorial3;

import com.github.dvefimov.spring_angular_tutorial.tutorial3.data.Entity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: техно сити
 * Date: 23.11.14
 * Time: 19:00
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class BlogEntryController {

//step 1 - check test
    @RequestMapping(value = "testMyPath")
    public ResponseEntity<Object> testGetMethod(){

        Entity entity = new Entity();
        entity.setTitle("Entity Title");
        return new ResponseEntity<Object>(entity, HttpStatus.OK);
    }

//go forward - give json
    @RequestMapping(value = "testMyPath1")
    public @ResponseBody Entity testGetMethod1(){

        Entity entity = new Entity();
        entity.setTitle("Entity Title");
        return entity;
    }

//go forward - give json. check json work properly
    @RequestMapping(value = "testMyPath1", method = RequestMethod.POST)
    public @ResponseBody Entity testGetMethod1(@RequestBody Entity entity){
        return entity;
    }
}
