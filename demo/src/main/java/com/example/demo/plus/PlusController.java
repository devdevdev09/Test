package com.example.demo.plus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/naver")
@RestController
public class PlusController {
    
    @GetMapping("/return/reqReturnReceipt.json")
    public String returnReceipt(String status){
        return "Success";
    }
}