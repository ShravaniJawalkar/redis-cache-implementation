package org.example.rediscache.controller;

import org.example.rediscache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cache")
public class CacheController {
    @Autowired
    private CacheService cacheService;

    @GetMapping("/{key}")
    public String getDetailsById(@PathVariable("key") String key) {
        return cacheService.getDetailsByKey(key);
    }
    @PutMapping
    public String updateDetails(@RequestParam("key") String key, @RequestParam("value") String value) {
        return cacheService.updateDetailsByKey(key, value);
    }

    @DeleteMapping("/{key}")
    public String deleteDetails(@PathVariable("key") String key) {
        return cacheService.deleteDetailsByKey(key);
    }
}
