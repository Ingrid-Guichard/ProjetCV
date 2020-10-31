package io.takima.demo;

import io.takima.demo.storage.StorageProperties;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@EnableJpaRepositories
@EnableAutoConfiguration
@SpringBootConfiguration
@EnableConfigurationProperties(StorageProperties.class)
public class Application {
    public static void main(String[] args) {

        new SpringApplicationBuilder(Application.class)
                .run();
    }
}
