package com.nsa.ons.onsgroupproject.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsa.ons.onsgroupproject.config.security.MyUserDetailsService;
import com.nsa.ons.onsgroupproject.domain.Skill;
import com.nsa.ons.onsgroupproject.service.*;


import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SkillRequestController.class)
public class SkillCreationTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SkillRequestCreator skillRequestCreator;

    @MockBean
    private SkillRequestFinder skillRequestFinder;

    @MockBean
    private SkillFinder skillFinder;

    @MockBean
    private SkillCreator skillCreator;

    @MockBean
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private WebApplicationContext context;

    @Test
    @WithMockUser(value = "Mock")
    public void newSkillIsCreated() throws Exception{
        String json = "{\"skill\":\"spring boot\",\"description\":\"spring boot description\",\"parent\":\"java\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        given(this.skillFinder.findSkillByName("java")).willReturn(Optional.of(new Skill(null,"java","java description",null,null)));
        mvc.perform(MockMvcRequestBuilders
                .post("/saveNewSkill")
                .content(asJsonString(jsonNode))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

//  https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
