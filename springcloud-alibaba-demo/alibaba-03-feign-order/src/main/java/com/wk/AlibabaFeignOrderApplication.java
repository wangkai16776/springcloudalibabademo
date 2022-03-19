package com.wk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created with IntelliJ IDEA.
 * User: wangkai
 * Date: 2022/2/23
 * Time: 1:21
 * Description: No Description
 */
@EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AlibabaFeignOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaFeignOrderApplication.class,args);
    }
}
