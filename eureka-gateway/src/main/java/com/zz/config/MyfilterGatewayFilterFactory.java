package com.zz.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class MyfilterGatewayFilterFactory extends AbstractGatewayFilterFactory<MyfilterGatewayFilterFactory.MyTest> {
    public MyfilterGatewayFilterFactory(){
        super(MyTest.class);
    }
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("name");
    }

    @Override
    public GatewayFilter apply(MyTest config) {
        return (exchange, chain) -> {
            if (!config.isEnabled()) {
                return chain.filter(exchange);
            }
            return chain.filter(exchange);
        };
    }
    public static class MyTest {
        // 控制是否开启认证
        private boolean enabled;

        public MyTest() {}

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}
