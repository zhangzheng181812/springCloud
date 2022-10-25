package com.zz.config;

import lombok.Data;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Arrays;
import java.util.List;


@Component
public class MyFilterGatewayFilterFactory extends AbstractGatewayFilterFactory<MyFilterGatewayFilterFactory.MyTest> {
    public MyFilterGatewayFilterFactory(){
        super(MyTest.class);
    }
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("name","key");
    }

    @Override
    public GatewayFilter apply(MyTest config) {
        return (exchange, chain) -> {
            if (!config.isEnabled()) {
                System.out.println("close");
                return chain.filter(exchange);
            }
            System.out.println("open");
            System.out.println(config.getKey());
            return chain.filter(exchange);
        };
    }

    @Data
    public static class MyTest {
        // 控制是否开启认证
        private boolean enabled;

        private String key;

        public MyTest() {}

        public boolean isEnabled() {
            return enabled;
        }

    }
}
