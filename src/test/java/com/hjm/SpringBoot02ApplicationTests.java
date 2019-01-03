package com.hjm;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
@WebAppConfiguration
public class SpringBoot02ApplicationTests {

    private MockMvc mvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @Test
    public void contextLoads() throws Exception {
          // Example
//        String responseString = mvc.perform(
//                get("/user/2") // RequestMethod
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED) // DataFormat
//                .param("code","1001"))    // Parameter
//                .andExpect(status()
//                .isOk())
//                .andDo(MockMvcResultHandlers.print())     // print() ---> Console
//                .andReturn().getResponse().getContentAsString();
//

//        mvc.perform(
//                get("/user/")   // getUsers()
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
//                .andExpect(status()
//                        .isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn().getResponse().getContentAsString();

//        mvc.perform(
//                get("/user/6")   // getUserById(Integer id)
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
//                .andExpect(status()
//                        .isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn().getResponse().getContentAsString();

        mvc.perform(
                post("/user/")   // getUserById(Integer id)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username" , "张仪")
                        .param("password" , "123"))
                .andExpect(status()
                        .isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
    }

}

