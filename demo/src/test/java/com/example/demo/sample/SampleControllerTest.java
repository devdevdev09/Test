package com.example.demo.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.demo.ApidocumetationTest;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ch.qos.logback.core.status.Status;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;


import javax.servlet.RequestDispatcher;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(SampleControllerTest.class)
public class SampleControllerTest extends ApidocumetationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Rule
    public final JUnitRestDocumentation restDocumenttation = new JUnitRestDocumentation();

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Test
    public void sample1() {
        // String result = testRestTemplate.getForObject("/sample1", String.class);
        ResponseEntity<String> response = testRestTemplate.getForEntity("/sample1" + "?test=test", String.class);

        assertEquals(response.getBody(), "test");
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotEquals(response.getBody(), "test222");
    }

    @Before
    public void setuUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                    .apply(documentationConfiguration(this.restDocumenttation)).build();
    }

	@Test
	public void indexExample() throws Exception {
		this.mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andDo(document("index-example",
					links(
							linkWithRel("notes").description("The <<resources_notes,Notes resource>>"),
							linkWithRel("tags").description("The <<resources_tags,Tags resource>>"),
							linkWithRel("profile").description("The ALPS profile for the service")),
					responseFields(
							subsectionWithPath("_links").description("<<resources_index_access_links,Links>> to other resources"))));

	}
}