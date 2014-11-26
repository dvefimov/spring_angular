package com.github.dvefimov.spring_angular_tutorial.tutorial3;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created with IntelliJ IDEA.
 * User: техно сити
 * Date: 23.11.14
 * Time: 19:01
 * To change this template use File | Settings | File Templates.
 */
public class BlogEntryControllerTut3Test {
    @InjectMocks
    private BlogEntryController_tut3 controller;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/testMyPath")).andDo(print());
    }

    @Test
    public void test1() throws Exception {
        mockMvc.perform(get("/testMyPath1")).andDo(print());
    }

    @Test
    public void test2() throws Exception {
        mockMvc.perform(post("/testMyPath1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"test blog title\"}")
                        )
                .andExpect(jsonPath("$.title", is("test blog title")))
                .andDo(print());
    }
}
