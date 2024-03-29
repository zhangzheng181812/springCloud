package com.zz.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangzheng on 2019/5/16.
 */
@FeignClient(value = "eureka-client" , fallback = Hihystrix.class)
public interface RurekaFeignClient {

    @RequestMapping("/sayHI")
    String hi();
}
