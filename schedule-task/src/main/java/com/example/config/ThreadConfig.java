package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author huJesse
 * @Date 2021/12/6 14:20
 * @Description
 * @Configuration用于定义配置类，被注解的类内部包含有一个或多个被@Bean注解的方法， 这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，并用于构建bean定义，初始化Spring容器。
 * @EnableAsync开始对异步任务的支持
 */
@Configuration
@EnableAsync
public class ThreadConfig {
    private static final int corePoolSize = 10;            // 核心线程数（默认线程数）
    private static final int maxPoolSize = 100;                // 最大线程数
    private static final int keepAliveTime = 10;            // 允许线程空闲时间（单位：默认为秒）
    private static final int queueCapacity = 200;            // 缓冲队列数
    private static final String threadNamePrefix = "Async-Service-"; // 线程池名前缀

    @Bean(name = "MyPool")
    public Executor createExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveTime);
        executor.setThreadNamePrefix(threadNamePrefix);
        // 线程池对拒绝任务的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        /**
         * 其中我们主要注意的就是拒绝策略方法：setRejectedExecutionHandler（），拒绝策略常用有有这四种
         *
         * ThreadPoolExecutor.AbortPolicy 丢弃任务并抛出RejectedExecutionException异常(默认)。
         * ThreadPoolExecutor.DiscardPolic 丢弃任务，但是不抛出异常。
         * ThreadPoolExecutor.DiscardOldestPolicy 丢弃队列最前面的任务，然后重新尝试执行任务
         * ThreadPoolExecutor.CallerRunsPolic 由调用线程处理该任务
         */
        // 初始化
        executor.initialize();
        return executor;
    }
}
