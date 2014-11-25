package com.github.dvefimov.spring_angular_tutorial.rest.tutorial4;

import com.github.dvefimov.spring_angular_tutorial.core.tutorial4.BlogEntry;
import com.github.dvefimov.spring_angular_tutorial.core.tutorial4.services.BlogEntryService;
import com.github.dvefimov.spring_angular_tutorial.rest.tutorial4.resources.BlogEntryResource;
import com.github.dvefimov.spring_angular_tutorial.rest.tutorial4.resources.asm.BlogEntryResourceAsm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: техно сити
 * Date: 24.11.14
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class BlogEntryController {
    private BlogEntryService service;

    public BlogEntryController(BlogEntryService service) {
        this.service = service;
    }

    @RequestMapping(value = "/rest/blog-entries/{id}", method = RequestMethod.GET)
    public ResponseEntity<BlogEntryResource> getBlogEntry(@PathVariable Long id){
        BlogEntry entry = service.find(id);
        if(entry != null){
            BlogEntryResource resource = new BlogEntryResourceAsm().toResource(entry);
            return new ResponseEntity<BlogEntryResource>(resource, HttpStatus.OK);
        }else{
            return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
        }
    }
}
