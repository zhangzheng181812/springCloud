package com.zz.config;

import org.springframework.stereotype.Component;

/**
 * Created by zhangzheng on 2019/5/21.
 */
@Component
public class Hihystrix implements RurekaFeignClient {

    @Override
    public String hi() {
        return "hi error....";
    }
}
