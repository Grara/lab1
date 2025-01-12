package com.lab1;

import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileService {

    @Value("${fileDir}")
    private String FILE_DIR; //기본 파일 경로

    @Autowired
    private SystemMapper systemMapper;

    public void readCsv(String fileName) throws Exception{
        CSVReader csvReader = new CSVReader(new FileReader(FILE_DIR + fileName));
        List<Map<String, Object>> insertData = new ArrayList<>();
        String[] headers = {};
        String[] line;
        int idx = 0;
        while ((line = csvReader.readNext()) != null) {
            if(idx == 0){
                headers = line;
                idx++;
                continue;
            }
            Map<String, Object> map = new HashMap<>();

            for(int i = 0; i < line.length; i++){
                map.put(headers[i], line[i]);
            }
            insertData.add(map);
        }

        systemMapper.csvTest(insertData);
    }
}
