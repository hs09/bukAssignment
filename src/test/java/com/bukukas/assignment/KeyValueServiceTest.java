package com.bukukas.assignment;

import com.bukukas.assignment.service.KeyValueService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class KeyValueServiceTest {

    KeyValueService service;

    @BeforeEach
    public void setup() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        service = new KeyValueService(map);
    }

    @Test
    public void getValueOK() {
        String value1 = service.getKeyValue("key1").getValue();
        Assertions.assertEquals(value1, "value1");
    }

    @Test
    public void getValueNotExist() {
        String value1 = service.getKeyValue("key").getValue();
        Assertions.assertEquals(value1, "The key doesn't exist");
    }

    // For sake of time, added only few tests. More tests can be added in similar way.

}
