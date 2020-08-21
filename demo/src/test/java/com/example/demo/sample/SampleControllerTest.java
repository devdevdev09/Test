package com.example.demo.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.demo.ApidocumetationTest;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(SampleControllerTest.class)
public class SampleControllerTest extends ApidocumetationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void sample1() {
        // String result = testRestTemplate.getForObject("/sample1", String.class);
        ResponseEntity<String> response = testRestTemplate.getForEntity("/sample1" + "?test=test", String.class);

        assertEquals(response.getBody(), "test");
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotEquals(response.getBody(), "test222");
    }
}