package com.example.demo;

import com.example.demo.sample.SampleControllerTest;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {
    SampleControllerTest.class
})
@AutoConfigureRestDocs
public abstract class ApidocumetationTest {

    @Autowired
    protected MockMvc mockMvc;
}