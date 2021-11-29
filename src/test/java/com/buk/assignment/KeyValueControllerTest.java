package com.buk.assignment;

import com.buk.assignment.service.KeyValue;
import com.buk.assignment.service.KeyValueService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class KeyValueControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    KeyValueService keyValueService;

    @Test
    public void getKeyOK() throws Exception {
        Mockito.when(keyValueService.getKeyValue("key1")).thenReturn(new KeyValue("key1", ""));
        mockMvc.perform(get("/map/get/key1")).andExpect(status().isOk()).andExpect(content().
                string(containsString("key1")));
    }

    @Test
    public void getKeyNotExist() throws Exception {
        Mockito.when(keyValueService.getKeyValue("key1")).thenReturn(new KeyValue("key1", "The key doesn't exist"));
        mockMvc.perform(get("/map/get/key1")).andExpect(status().isOk()).andExpect(content().
                string(containsString("The key doesn't exist")));
    }

    @Test
    public void searchPrefixOK() throws Exception {
        Mockito.when(keyValueService.searchPrefix("key1")).thenReturn(List.of("key1"));
        mockMvc.perform(get("/map/search?prefix=key1")).andExpect(status().isOk()).andExpect(content().
                string(containsString("key1")));
    }

    @Test
    public void searchSuffixOK() throws Exception {
        Mockito.when(keyValueService.searchSuffix("key1")).thenReturn(List.of("key1"));
        mockMvc.perform(get("/map/search?suffix=key1")).andExpect(status().isOk()).andExpect(content().
                string(containsString("key1")));
    }
}
