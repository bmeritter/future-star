package com.thoughtworks.star.api;

import com.thoughtworks.star.FutureStarApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = FutureStarApplication.class)
@AutoConfigureMockMvc
@Transactional
public class BaseControllerTest {

    @Autowired
    protected MockMvc mockMvc;

}
