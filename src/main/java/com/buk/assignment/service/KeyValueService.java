package com.buk.assignment.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class KeyValueService {

    Map<String, String> memoryMap;

    public KeyValue getKeyValue(String key) {
        String value = memoryMap.getOrDefault(key, "The key doesn't exist");
        return new KeyValue(key, value);
    }

    public KeyValue setValue(KeyValue keyValue) {
        memoryMap.put(keyValue.getKey(), keyValue.getValue());
        return keyValue;
    }

    public List<String> searchPrefix(String prefix) {
        return memoryMap.keySet().stream().filter(key -> key.startsWith(prefix)).collect(Collectors.toList());
    }

    public List<String> searchSuffix(String suffix) {
        return memoryMap.keySet().stream().filter(key -> key.endsWith(suffix)).collect(Collectors.toList());
    }
}
