package org.example.rediscache

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class RedisCacheApplication {

    static void main(String[] args) {
        SpringApplication.run(RedisCacheApplication, args)
    }

}
