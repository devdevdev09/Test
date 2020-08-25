package com.example.demo.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.example.demo.ApidocumetationTest;

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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
<<<<<<< HEAD
@WebMvcTest(SampleController.class)
public class SampleControllerTest {
=======
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(SampleControllerTest.class)
public class SampleControllerTest extends ApidocumetationTest {
>>>>>>> 1d51eef0c419923908ae90922bc4e77750add03d

    @Autowired
    TestRestTemplate testRestTemplate;

<<<<<<< HEAD
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void sample1() throws Exception {
        // Test1.
        // String result = testRestTemplate.getForObject("/sample1", String.class);

        // Test2.
        // ResponseEntity<String> response = testRestTemplate.getForEntity("/sample1" + "?test=test", String.class);

        // assertEquals(response.getBody(), "test");
        // assertEquals(response.getStatusCode(), HttpStatus.OK);
        // assertNotEquals(response.getBody(), "test222");

        // Test3.
        MultiValueMap<String, String> info = new LinkedMultiValueMap();

        info.add("test", "heo");

        this.mockMvc.perform(get("/sample1")
            .params(info)
            .andExpect(status().isOk())
            .andExpect(content().string("heo"))
            .andDo(print());
    }
=======
    // @Rule
    // public final JUnitRestDocumentation restDocumenttation = new JUnitRestDocumentation();

    // @Autowired
    // private WebApplicationContext context;

    // private MockMvc mockMvc;

    // @Test
    // public void sample1() {
    //     // String result = testRestTemplate.getForObject("/sample1", String.class);
    //     ResponseEntity<String> response = testRestTemplate.getForEntity("/sample1" + "?test=test", String.class);

    //     assertEquals(response.getBody(), "test");
    //     assertEquals(response.getStatusCode(), HttpStatus.OK);
    //     assertNotEquals(response.getBody(), "test222");
    // }

    // @Before
    // public void setuUp() {
    //     this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
    //                 .apply(documentationConfiguration(this.restDocumenttation)).build();
    // }

	@Test
	public void sample1(){
		// this.mockMvc.perform(get("/dddd"))
		// 	.andExpect(status().isOk())
		// 	.andDo(document("sampl",
		// 			links(
		// 					linkWithRel("test").description("The ALPS profile for the service")),
		// 			responseFields(
        // 					subsectionWithPath("_links").description("<<resources_index_access_links,Links>> to other resources"))));
        
        ResponseEntity<String> response = testRestTemplate.getForEntity("/sample1", String.class);

        assertEquals(response.getBody(), "test");
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotEquals(response.getBody(), "test222");

	}
>>>>>>> 1d51eef0c419923908ae90922bc4e77750add03d
}