package com.xavier.center.api;

import com.xavier.center.CenterApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import sun.nio.cs.UTF_32;

import java.net.URLEncoder;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class SequenceControllerTest extends CenterApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void seq() throws Exception {
        RequestBuilder request = post("/gen")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_FORM_URLENCODED)
                .content("expr=" + URLEncoder.encode("yyyyMMdd()+format(seq,4)", "UTF-8") + "&key=key_test")
                .characterEncoding("UTF-8");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }
}