package com.lab1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class TestService {

    @Autowired
    private SystemMapper systemMapper;

//    @Autowired
//    private DataSourceTransactionManager tm;

    @Transactional
    public void testQQ(){

//        DataSourceTransactionManager aa = tm;
//        TransactionStatus status = tm.getTransaction(null);

        List<Object> list1 = List.of(1, 1, 1, 1, 1, 1, 1);
        List<Object> list2 = List.of(2, 2, 2, "", 2, 2, 2);
        List<Object> list3 = List.of(3, 3, 3, 3, 3, 3, 3);

        Integer cnt = systemMapper.testQ(list1);
        Integer cnt2 = systemMapper.testQ(list2);
        Integer cnt3 = systemMapper.testQ(list3);

    }
}
