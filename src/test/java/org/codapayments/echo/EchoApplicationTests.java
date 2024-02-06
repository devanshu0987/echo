package org.codapayments.echo;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EchoController.class)
class EchoApplicationTests {

    @Autowired
    private EchoController controller;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    void testHappyPath() throws Exception {
        String payloadString = "{\"game\":\"Mobile Legends\", \"gamerID\":\"GYUTDTE\", \"points\":20}";
        JSONObject payload = new JSONObject(payloadString);
        this.mockMvc
                .perform(post("/echo").contentType(MediaType.APPLICATION_JSON).content(payload.toString()))
                .andExpect(status().isOk()).andExpect(content().string(payload.toString()));
    }

}
