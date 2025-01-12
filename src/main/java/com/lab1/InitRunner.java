package com.lab1;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class InitRunner implements ApplicationRunner {

    private final MenuJPA menuJPA;
    private final SystemMapper systemMapper;


    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
