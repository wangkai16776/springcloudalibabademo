package com.wk.config;

import com.wk.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: wangkai
 * Date: 2022/3/18
 * Time: 23:07
 * Description: No Description
 */
@Configuration
public class FilterConfig {

    @Bean
    AccessFilter getAccessFilter() {
        return new AccessFilter();
    }
}
