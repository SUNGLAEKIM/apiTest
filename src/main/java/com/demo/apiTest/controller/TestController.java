package com.demo.apiTest.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/test")
//localhost:8080/api/test
public class TestController {

    //REST API의 메소드: GET, POST, PUT, DELETE
    //CRUD: CREATE, READ, UPDATE, DELETE
    // DB, JAVA, 기능에 대한 이야기?

    //GET --> 받아온다
    //POST --> 전달한다? 부친다?, GET 처럼도 사용이 가능함

    //PUT --> INSERT //API를 제공하는 입장에서는 사용자한테 잘 허용하지 않는 메소드
    //DELETE --> DELETE //API를 제공하는 입장에서는 사용자한테 잘 허용하지 않는 메소드


    //어노테이션 선언방법이 2가지 있다.
    //@RequestMapping(value = "/getdata", method = RequestMethod.GET)
    //@GetMapping("/getdata")

    @RequestMapping("nogetpost")
    public String testApi() {
        return "<strong>RequestMapping입니다, get/post 가능</strong>";
    }

    @RequestMapping(value = "getpost", method = RequestMethod.GET)
    public Map<String, String> testApi2(@RequestParam("id") Long id) {
        Map<String, String> data = new HashMap<String, String>();
        data.put("또리", "토토");

        return data;
    }

    @RequestMapping(value = "getpost", method = RequestMethod.POST)
    public Map<String, String> testApi2(@RequestParam("name") String name) {
        Map<String, String> data = new HashMap<String, String>();
        data.put("또리", "토토");

        return data;
    }

}
