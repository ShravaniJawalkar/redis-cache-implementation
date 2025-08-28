package org.example.rediscache.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
@Slf4j
@Service
public class CacheService {

    Map<String, String> database = Map.of(
        "1", "Data 1",
        "2", "Data 2",
        "3", "Data 3",
        "4", "Data 4",
        "5", "Data 5"
    );
    @Cacheable(value = "detailsCache", key = "#key")
    public String getDetailsByKey(String key) {
        try {
            Thread.sleep(2000); // Simulate delay
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        System.out.println("Fetching from database for key: " + key);
        // Simulate a database call
        return database.getOrDefault(key, "No Data Found");
    }
    @CachePut(value = "detailsCache", key = "#key")
    public String updateDetailsByKey(String key, String value) {
        System.out.println("Updating database for key: " + key);
        // Simulate a database update
        // In a real application, you would update the database here
        return value;
    }
    @CacheEvict(key = "#key", value = "detailsCache")
    public String deleteDetailsByKey(String key) {
        System.out.println("Deleting from cache for key: " + key);
        // Simulate a database delete
        // In a real application, you would delete from the database here
        return key;
    }
}
