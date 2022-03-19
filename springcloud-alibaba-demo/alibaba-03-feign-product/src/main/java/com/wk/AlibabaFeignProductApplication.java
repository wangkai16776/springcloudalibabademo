package com.wk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created with IntelliJ IDEA.
 * User: wangkai
 * Date: 2022/2/23
 * Time: 1:17
 * Description: No Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaFeignProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaFeignProductApplication.class,args);
    }

}
