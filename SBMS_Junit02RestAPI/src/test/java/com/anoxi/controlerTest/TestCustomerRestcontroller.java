package com.anoxi.controlerTest;

import com.anoxi.dto.Customer;
import com.anoxi.restcontroller.CustomerRestController;
import com.anoxi.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CustomerRestController.class)
public class TestCustomerRestcontroller {

    @MockitoBean
    private CustomerService customerService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSavedCustomer01() throws Exception {

        Customer customer = new Customer(101, "Prince Kumar", "pyushthakur1999@gmail.com");

        //defined mock obj method behaviour
        Mockito.when(customerService.saveCustomer(Mockito.any(Customer.class))).thenReturn(true);

        //convert customer obj data into json format
        ObjectMapper mapper = new ObjectMapper();
        String customJson = mapper.writeValueAsString(customer);

        //prepare post request with json data in request body
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/save");

        mockMvc.perform(requestBuilder.contentType(MediaType.APPLICATION_JSON).content(customJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Customer Saved"));
    }

    @Test
    public void testSavedCustomer02() throws Exception {

        Customer customer = new Customer(101, "Prince Kumar", "pyushthakur1999@gmail.com");

        //defined mock obj method behaviour
        Mockito.when(customerService.saveCustomer(Mockito.any(Customer.class))).thenReturn(false);

        //convert customer obj data into json format
        ObjectMapper mapper = new ObjectMapper();
        String customJson = mapper.writeValueAsString(customer);

        //prepare post request with json data in request body
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/save");

        mockMvc.perform(requestBuilder.contentType(MediaType.APPLICATION_JSON).content(customJson))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().string("Customer not saved"));
    }
}
