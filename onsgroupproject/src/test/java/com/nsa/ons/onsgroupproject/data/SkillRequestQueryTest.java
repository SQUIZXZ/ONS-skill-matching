package com.nsa.ons.onsgroupproject.data;


import com.nsa.ons.onsgroupproject.domain.SkillRequest;
import com.nsa.ons.onsgroupproject.service.SkillRequestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan
@Transactional
public class SkillRequestQueryTest {

    @Autowired
    private SkillRequestRepository skillRequestRepository;

    @Test
    public void testThatFindByFurlWorks() throws Exception {

        Optional<SkillRequest> skillRequest = skillRequestRepository.findByFurl("python-help");
        assertEquals("Need help with python", skillRequest.get().getInfo());

    }

}
