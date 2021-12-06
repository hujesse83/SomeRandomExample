package com.example.schedulingtasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author huJesse
 * @Date 2021/12/6 10:26
 */
@Slf4j
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    static {
        log.info("ScheduledTasks begins");
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")
    public void reportCurrentTime2() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportCurrentTime3() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportCvurrentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportCudrrentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportfCurrentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportCurraentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportCurrenvtTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportCurrentTidme() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportCurrent2Time() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportCurrent3Time() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportCurr2entTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportC2urrentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void repo2rtCurrentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void rep21ortCurrentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void rep2ortCurrentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportCur5rentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportC4urrentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportCur0rentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportCu9rrentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportCur8rentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportCu7rrentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportC6urrentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void reportCur7rentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 5000)
    @Async("MyPool")

    public void repor6tCurrentTime() {
        log.info(Thread.currentThread().getName());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

}
