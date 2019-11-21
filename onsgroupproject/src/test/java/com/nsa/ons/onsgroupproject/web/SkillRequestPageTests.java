package com.nsa.ons.onsgroupproject.web;

import com.nsa.ons.onsgroupproject.domain.SkillRequest;
import com.nsa.ons.onsgroupproject.service.SkillRequestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(com.nsa.ons.onsgroupproject.web.SkillRequestController.class)
public class SkillRequestPageTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SkillRequestRepository skillRequestRepository;

    @Test
    public void requestPageFindsCorrectData() throws Exception{
        SkillRequest mockSkillRequest = new SkillRequest(
                1L,
                "John",
                "Smiths",
                "department A",
                "python",
                "making a web backend",
                "theFurl"
        );

        given(this.skillRequestRepository.findByFurl("theFurl")).willReturn(Optional.of(mockSkillRequest));

        mvc.perform(
                get("/skillRequest/theFurl")
        ).andDo(
                print()
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string(containsString("John Smiths"))
        ).andExpect(
                content().string(containsString("department A"))
        ).andExpect(
                content().string(containsString("python"))
        ).andExpect(
                content().string(containsString("making a web backend"))
        );
    }
}
