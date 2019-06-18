package com.zz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangzheng on 2019/6/18.
 */
@SpringBootApplication
@RestController
public class ConfigClientApplication {
    public static void main(String[] adsf){
        SpringApplication.run(ConfigClientApplication.class,adsf);
    }

    @Value("${foo}")
    String foo;

    @RequestMapping(value = "/foo")
    public String foo(){
        return foo;
    }
}
