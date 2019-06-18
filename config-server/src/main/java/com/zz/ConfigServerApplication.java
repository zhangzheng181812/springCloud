package com.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by zhangzheng on 2019/6/18.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] adsf){
        SpringApplication.run(ConfigServerApplication.class,adsf);
    }
}
