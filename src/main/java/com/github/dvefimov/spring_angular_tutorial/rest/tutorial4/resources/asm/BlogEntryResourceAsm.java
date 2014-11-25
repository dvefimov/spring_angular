package com.github.dvefimov.spring_angular_tutorial.rest.tutorial4.resources.asm;

import com.github.dvefimov.spring_angular_tutorial.core.tutorial4.BlogEntry;
import com.github.dvefimov.spring_angular_tutorial.rest.tutorial4.BlogEntryController;
import com.github.dvefimov.spring_angular_tutorial.rest.tutorial4.resources.BlogEntryResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created with IntelliJ IDEA.
 * User: техно сити
 * Date: 24.11.14
 * Time: 23:37
 * To change this template use File | Settings | File Templates.
 */
public class BlogEntryResourceAsm extends ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {

    public BlogEntryResourceAsm() {
        super(BlogEntryController.class, BlogEntryResource.class);
    }

    @Override
    public BlogEntryResource toResource(BlogEntry blogEntry) {
        BlogEntryResource resource = new BlogEntryResource();
        resource.setTitle(blogEntry.getTitle());
        Link link = linkTo(methodOn(BlogEntryController.class).getBlogEntry(blogEntry.getId())).withSelfRel();
        resource.add(link.withSelfRel());
        return resource;
    }
}
