package com.github.dvefimov.spring_angular_tutorial.rest.tutorial4.resources;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created with IntelliJ IDEA.
 * User: техно сити
 * Date: 24.11.14
 * Time: 19:09
 * To change this template use File | Settings | File Templates.
 */
public class BlogEntryResource extends ResourceSupport {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
