package com.example.schedulingtasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @Author huJesse
 * @Date 2021/12/6 10:26
 */
@Slf4j
@Component
public class ScheduledTasks {


    static {
        log.info("ScheduledTasks with async begins");
    }

    @Scheduled(fixedDelay = 1000)
    @Async("MyPool")  // 指定线程池的名称
    public void reportCurrentTime2() {
        log.info(Thread.currentThread().getName());
    }
    @Scheduled(fixedDelay = 1000)
    @Async  // 不指定线程池的名称
    public void reportCurrentTime() {
        log.info(Thread.currentThread().getName());
    }
}
