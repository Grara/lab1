package com.lab1;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {

    Map<String, Object> getMember(Map<String, Object> param);
}