package com.lab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemService {

    @Autowired
    private SystemMapper systemMapper;

    @Cacheable(value="menu")
    public List<Menu> getAllMenu(){
        return systemMapper.getAllMenu("ADMIN");
    }
}
