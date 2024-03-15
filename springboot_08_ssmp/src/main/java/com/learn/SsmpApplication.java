package com.learn;

import com.learn.config.ServerConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class SsmpApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SsmpApplication.class, args);
        ServerConfig bean = context.getBean(ServerConfig.class);
        if (log.isInfoEnabled()) {
            log.info("ServerConfig={}", bean);
        }
    }

}
