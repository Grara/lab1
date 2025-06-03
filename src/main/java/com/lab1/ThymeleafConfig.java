package com.lab1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ThymeleafConfig {


    @Bean("charOnly")
    public Function<String, String> charOnly() {
        return (txt) -> {
            return txt + "123123";
        };
    }

    @Bean("customFn")
    public TriFn<String, String, String> customFn(){
        return (txt, midEl) -> {
            return txt + midEl + txt;
        };
    }

    @FunctionalInterface
    interface TriFn<T, U, R>{
        R apply(T t, U u);
    }
}
