package com.buk.assignment.controller;

import com.buk.assignment.service.KeyValue;
import com.buk.assignment.service.KeyValueService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/map")
@AllArgsConstructor
public class KeyValueController {

    KeyValueService keyValueService;

    @GetMapping("/get/{key}")
    public KeyValue getValue(@PathVariable String key) {
        return keyValueService.getKeyValue(key);
    }

    @PostMapping(value = "/set")
    public KeyValue setValue(@RequestBody KeyValue keyValue) {
        return keyValueService.setValue(keyValue);
    }

    @GetMapping(value = "/search", params = "prefix")
    public List<String> searchPrefix(@RequestParam String prefix) {
        return keyValueService.searchPrefix(prefix);
    }

    @GetMapping(value = "/search", params = "suffix")
    public List<String> searchSuffix(@RequestParam String suffix) {
        return keyValueService.searchSuffix(suffix);
    }

}
