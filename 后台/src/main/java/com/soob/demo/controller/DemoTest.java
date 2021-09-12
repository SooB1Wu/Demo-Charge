package com.soob.demo.controller;


//import com.example.demo.service.TestService;
import com.soob.demo.utils.DtReq;
import com.soob.demo.utils.DtRes;
import com.soob.demo.utils.ObjSend;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DemoTest {
    @RequestMapping("/soob")
    @ResponseBody
    public ObjSend useEu(@RequestBody String req) {
        long startTime;
        long endTime;
        DtReq datareq=new Format().formatReq(req);
        startTime=System.currentTimeMillis();
        DtRes datares=new Cal().splitZ(datareq);
        ObjSend send=new Format().formatSend(new Cal().insertA_force(datareq,datares));
        endTime=System.currentTimeMillis();
        System.out.println("runtime:"+(endTime - startTime)+"ms");
        return send;
    }
}
