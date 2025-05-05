package com.lab1;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Mapper
public interface SystemMapper {

    List<Menu> getAllMenu(String authName);

    List<Map<String, Object>> getMenuListByParent(Map<String, Object> param);

    List<Map<String, Object>> getAuthOfMenu(Map<String, Object> param);

    void saveMenu(Map<String, Object> param);

    void saveMenuAuthLevel(Map<String, Object> param);

    void toggleMenuAuth(Map<String, Object> param);

    List<Map<String, Object>> searchProgram(Map<String, Object> param);

    List<Map<String, Object>> searchAction(Map<String, Object> param);

    List<Map<String, Object>> getActionAuth(Map<String, Object> param);

    void saveProgram(Map<String, Object> param);

    void saveAction(Map<String, Object> param);

    void saveActionAuthLevel(Map<String, Object> param);

    void toggleActionAuth(Map<String, Object> param);

    Integer testQ(List<Object> list);

    List<Map<String, Object>> getPermittedUrl(String authName);

    void csvTest(List<Map<String, Object>> insertData);
}