package net.hg.server;

import net.hg.server.config.FacebookConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@Import(FacebookConfiguration.class)
public class ApplicationMain {
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationMain.class, args);
    }
}