package com.wk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created with IntelliJ IDEA.
 * User: wangkai
 * Date: 2022/3/18
 * Time: 2:00
 * Description: No Description
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApiApplication.class,args);
    }
}
