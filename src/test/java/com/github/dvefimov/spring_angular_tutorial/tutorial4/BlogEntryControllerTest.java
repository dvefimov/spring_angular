package com.github.dvefimov.spring_angular_tutorial.tutorial4;

import com.github.dvefimov.spring_angular_tutorial.core.model.BlogEntry_tut4;
import com.github.dvefimov.spring_angular_tutorial.core.services.BlogEntryService_tut4;
import com.github.dvefimov.spring_angular_tutorial.rest.tutorial4.BlogEntryController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: техно сити
 * Date: 24.11.14
 * Time: 19:33
 * To change this template use File | Settings | File Templates.
 */
public class BlogEntryControllerTest {
    @InjectMocks
    private BlogEntryController controller;

    @Mock
    private BlogEntryService_tut4 service;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getExistingBlogEntry() throws Exception {
        BlogEntry_tut4 entry = new BlogEntry_tut4();
        entry.setId(1L);
        entry.setTitle("Test Blog Entry title");

        when(service.findBlogEntry(1L)).thenReturn(entry);

        mockMvc.perform(get("/rest/blog-entries/1")).
                andExpect(jsonPath("$.title", is(entry.getTitle()))).
                andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/blog-entries/1")))).
                andExpect(status().isOk()).
                andDo(print());
    }

    @Test
    public void getNotExistingBlogEntry() throws Exception {
        when(service.findBlogEntry(1L)).thenReturn(null);
        mockMvc.perform(get("/rest/blog-entries/1")).
                andExpect(status().isNotFound()).
                andDo(print());
    }
}
