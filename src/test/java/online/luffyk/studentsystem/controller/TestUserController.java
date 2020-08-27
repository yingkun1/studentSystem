package online.luffyk.studentsystem.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@SpringBootTest
public class TestUserController {
    @Resource
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testGetUser(){
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getUser")).andReturn();
            String content = mvcResult.getResponse().getContentAsString();
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
