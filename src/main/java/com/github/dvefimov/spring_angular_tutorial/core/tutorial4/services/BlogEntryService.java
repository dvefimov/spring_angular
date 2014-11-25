package com.github.dvefimov.spring_angular_tutorial.core.tutorial4.services;

import com.github.dvefimov.spring_angular_tutorial.core.tutorial4.BlogEntry;

/**
 * Created with IntelliJ IDEA.
 * User: техно сити
 * Date: 24.11.14
 * Time: 19:15
 * To change this template use File | Settings | File Templates.
 */
public interface BlogEntryService {
    public BlogEntry find(Long id);
}
