package com.joysuch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author qingzhou
 * 8/31/18
 */
@SpringBootApplication
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//@EnableAutoConfiguration(exclude={DruidDataSourceAutoConfigure.class})
public class ChemicalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChemicalApplication.class, args);
    }
}
