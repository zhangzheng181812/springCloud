package com.zz.config;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangzheng on 2019/5/16.
 */
@FeignClient(value = "eureka-client")
public interface RurekaFeignClient {

    @RequestMapping("sayHI")
    String hi();
}
