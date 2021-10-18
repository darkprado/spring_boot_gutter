package com.example.spring_boot_gutter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication(exclude={ActiveMQAutoConfiguration.class,
        DataSourceAutoConfiguration.class})
public class SpringBootGutterApplication {

    public static final Logger log = LoggerFactory.getLogger(SpringBootGutterApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootGutterApplication.class);
        app.run(args);
    }

    @Value("${spring.info:info}")
    private String info;

    @Bean
    CommandLineRunner myRunner() {
        return args -> log.info(info);
    }

}
