package com.example.demo.plus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/naver")
@RestController
public class PlusController {
    
    @GetMapping("/return/reqReturnReceipt.json")
    public Map<String, Object> returnReceipt(String copOrdNo,
                                            String copOrdGoodSeqs){
        
        System.out.println("copOrdNo : " + copOrdNo);
        System.out.println("copOrdGoodSeqs : " + copOrdGoodSeqs);

        List<String> ordGoodSeqList =  Arrays.asList(copOrdGoodSeqs.split(","));

        Map<String, Object> result = new HashMap<String, Object>();

        Map<String, String> resultData = new HashMap<String, String>();

        for(String ordGoodSeq : ordGoodSeqList){
            resultData.put(ordGoodSeq, "Error");
        }

        result.put("message", null);
        result.put("result", resultData);
        result.put("code", 200);
        result.put("status", null);
        result.put("requestId", "efecde50-6050-46f3-bcce-ad414f7c465e768473411");
        result.put("etc", null);
        
        return result;
    }
}