// package com.example.demo.sample;

// import static org.junit.Assert.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotEquals;

// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.util.LinkedMultiValueMap;
// import org.springframework.util.MultiValueMap;

// @RunWith(SpringRunner.class)
// @WebMvcTest(SampleController.class)
// public class SampleControllerTest {

//     @Autowired
//     TestRestTemplate testRestTemplate;

//     @Autowired
//     private MockMvc mockMvc;

//     @Test
//     public void sample1() throws Exception {
//         // Test1.
//         // String result = testRestTemplate.getForObject("/sample1", String.class);

//         // Test2.
//         // ResponseEntity<String> response = testRestTemplate.getForEntity("/sample1" + "?test=test", String.class);

//         // assertEquals(response.getBody(), "test");
//         // assertEquals(response.getStatusCode(), HttpStatus.OK);
//         // assertNotEquals(response.getBody(), "test222");

//         // Test3.
//         MultiValueMap<String, String> info = new LinkedMultiValueMap();

//         info.add("test", "heo");

//         this.mockMvc.perform(get("/sample1")
//             .params(info)
//             .andExpect(status().isOk())
//             .andExpect(content().string("heo"))
//             .andDo(print());
//     }
// }