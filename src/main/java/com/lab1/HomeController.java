package com.lab1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private SystemMapper systemMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private FileService fileService;

    @GetMapping("/")
    public String home(Model model) throws Exception{
        fileService.readCsv("testcsv.csv");
        return "pages/index-page";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "pages/login";
    }

    @ResponseBody
    @PostMapping("/login/process")
    public String loginProcess(@RequestBody Map<String, Object>param, HttpServletRequest req) throws Exception {
        Map<String, Object> member = memberMapper.getMember(param);
        if(member == null) {
            throw new Exception("멤버가 없슈");
        }

        Map<String, Object> sessionMap = new HashMap<>();
        sessionMap.put("menu", systemMapper.getAllMenu((String)member.get("AUTH_NAME")));
        sessionMap.put("permittedUrl", systemMapper.getPermittedUrl((String)member.get("AUTH_NAME")));
        HttpSession session = req.getSession();
        session.setAttribute("userSession", sessionMap);

        return "success";
    }

    @GetMapping("/upload")
    public String uploadPage(){
        return "pages/fileupload";
    }

    @ResponseBody
    @RequestMapping(value="/upload/process")
    public String uploadProcess(@RequestPart("uploadImg") MultipartFile uploadImg,
                                @RequestParam("con1") String con1,
                                @RequestParam("con2") String con2,
                                HttpServletRequest req) throws Exception {

        return "success";
    }
}
