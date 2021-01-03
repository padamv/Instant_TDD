package uk.co.ashleyfrieze.springrest.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import uk.co.ashleyfrieze.springrest.configuration.Config;
import uk.co.ashleyfrieze.springrest.service.AddressDeleter;
import uk.co.ashleyfrieze.springrest.service.AddressRetriever;
import uk.co.ashleyfrieze.springrest.service.AddressStorer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AddressBookTest.TestConfig.class)
@WebAppConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AddressBookTest {
    @Configuration
    @ComponentScan(basePackageClasses = Config.class)
    public static class TestConfig {
        private Map<String, String> addresses = new HashMap<>();
        
        @Bean
        public AddressRetriever retriever() {
            return addresses::get;
        }

        @Bean
        public AddressStorer storer() {
            return addresses::put;
        }

        @Bean
        public AddressDeleter deleter() {
            return addresses::remove;
        }
    }
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Autowired
    private AddressStorer storer;
    
    private MockMvc mockMvc;
        
    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
    public void unknownIsNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/address/Tom Cruise"))
                .andExpect(status().isNotFound());
    }
    
    @Test 
    public void withKnownPersonAddressIsFound() throws Exception {
    	storer.storeAddress("Harold", "1 King Place");
    	mockMvc.perform(MockMvcRequestBuilders.get("/address/Harold"))
        .andExpect(status().isOk());
    }
    
    @Test 
    public void withKnownPersonAddressIsCorrect() throws Exception {
    	storer.storeAddress("Harold", "1 King Place");
    	mockMvc.perform(MockMvcRequestBuilders.get("/address/Harold"))
        .andExpect(content().string("1 King Place"));
    }
        
}
