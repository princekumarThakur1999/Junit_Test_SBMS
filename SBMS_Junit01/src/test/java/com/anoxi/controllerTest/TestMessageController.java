package com.anoxi.controllerTest;

import com.anoxi.controller.MessageController;
import com.anoxi.service.MessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(controllers = MessageController.class)
public class TestMessageController {

    @MockitoBean
    private MessageService msgService;

    @Autowired
    private MockMvc mockMvc;   // to send http req for rest controller methods

    @Test
    public void testWelcomeMsg01() throws Exception {

        //defining mock obj method behaviour for unit testing
        Mockito.when(msgService.welcomeMsg()).thenReturn("Dummy Test");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/welcome");

        MvcResult result = mockMvc.perform(request).andReturn();

        MockHttpServletResponse response = result.getResponse();

        int actualStatus = response.getStatus();

        Assertions.assertEquals(200, actualStatus);

    }

    @Test
    public void testWelcomeMsg02() throws Exception{

        Mockito.when(msgService.welcomeMsg()).thenReturn(null);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/welcome");

        MvcResult result = mockMvc.perform(request).andReturn();

        MockHttpServletResponse response = result.getResponse();

        int actualStatus = response.getStatus();

        Assertions.assertEquals(200, actualStatus);
    }

    @Test
    public void testWelcomeMsg03() throws Exception{

        Mockito.when(msgService.welcomeMsg()).thenThrow(RuntimeException.class);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/welcome");

        try {
            mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isInternalServerError())
                    .andExpect(MockMvcResultMatchers.content().string("Exception Occured"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
