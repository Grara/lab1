package com.lab1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;


@Configuration
public class ThymeleafConfig {


    @Bean("charOnly")
    public Function<String, String> charOnly() {
        return i -> {
            return i.replaceAll("[0-9]", "");
        };
    }


}
