package com.sanwei.framework.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.sanwei.framework.mybatis.core.handler.DefaultDBFieldHandler;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * SanweiMybatisAutoConfiguration
 *
 * @author caiyang
 * @date 2026/4/15
 */
@AutoConfiguration
@MapperScan(value = "${sanwei.info.base-package}", annotationClass = Mapper.class)
public class SanweiMybatisAutoConfiguration {

    /**
     * 分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }

    @Bean
    public DefaultDBFieldHandler defaultDBFieldHandler() {
        return new DefaultDBFieldHandler();
    }
}
