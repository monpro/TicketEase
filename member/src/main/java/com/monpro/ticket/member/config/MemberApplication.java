package com.monpro.ticket.member.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;


@SpringBootApplication
@ComponentScan("com.monpro")
@MapperScan("com.monpro.ticket.member.mapper")
public class MemberApplication {

    private static final Logger log = LoggerFactory.getLogger(MemberApplication.class);
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MemberApplication.class);
        Environment environment = application.run(args).getEnvironment();
        log.info("running on localhost:{}", environment.getProperty("server.port"));
    }
}
