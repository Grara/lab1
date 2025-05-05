package com.lab1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class SystemController {

    @Autowired
    private SystemMapper systemMapper;

    @Autowired
    private TestService ss;

    @GetMapping("/system/menu")
    public String menuPage(Model model){
        //ss.testQQ();

        return "pages/menuManage";
    }

    @ResponseBody
    @GetMapping("/system/menu/search")
    public List<Map<String,Object>> getMenuListByLevel(@RequestParam Map<String, Object> param){
        return systemMapper.getMenuListByParent(param);
    }

    @ResponseBody
    @GetMapping("/system/menu/auth")
    public List<Map<String,Object>> getAuthOfMenu(@RequestParam Map<String, Object> param){
        List<Map<String,Object>> result = systemMapper.getAuthOfMenu(param);
        return result;
    }

    @ResponseBody
    @PostMapping("/system/menu/save")
    public String saveMenu(@RequestBody Map<String, Object> param) {
        systemMapper.saveMenu(param);
        systemMapper.saveMenuAuthLevel(param);
        return "success";
    }

    @ResponseBody
    @PostMapping("/system/menu/auth/save")
    public String toggleMenuAuth(@RequestBody Map<String, Object> param) {
        systemMapper.toggleMenuAuth(param);
        return "success";
    }

    @GetMapping("/system/program")
    public String programPage(){
        return "pages/programManage";
    }

    @ResponseBody
    @GetMapping("/system/program/search")
    public List<Map<String,Object>> searchProgram(@RequestParam Map<String, Object> param){
        return systemMapper.searchProgram(param);
    }

    @ResponseBody
    @GetMapping("/system/action/search")
    public List<Map<String,Object>> searchAction(@RequestParam Map<String, Object> param){
        return systemMapper.searchAction(param);
    }

    @ResponseBody
    @GetMapping("/system/action/auth")
    public List<Map<String,Object>> getActionAuth(@RequestParam Map<String, Object> param){
        return systemMapper.getActionAuth(param);
    }

    @ResponseBody
    @PostMapping("/system/program/save")
    public String saveProgram(@RequestBody Map<String, Object> param) {
        systemMapper.saveProgram(param);
        return "success";
    }

    @ResponseBody
    @PostMapping("/system/action/save")
    public String saveAction(@RequestBody Map<String, Object> param) {
        systemMapper.saveAction(param);
        Integer regSeq = (Integer)param.get("REG_SEQ");
        if(!StringUtils.hasText((String)param.get("ACTION_ID"))) {
            param.put("ACTION_ID", "ACT" + regSeq.toString());
        }
        systemMapper.saveActionAuthLevel(param);
        return "success";
    }

    @ResponseBody
    @PostMapping("/system/action/auth/save")
    public String toggleActionAuth(@RequestBody Map<String, Object> param) {
        systemMapper.toggleActionAuth(param);
        return "success";
    }
}
