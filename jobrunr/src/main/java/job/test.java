package job;

import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.spring.annotations.Recurring;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author jesse.hu
 * @date 2022/2/16 11:37
 */
@Component
public class test {
    // seconds mins hours DayofMonth Month DayofWeek
    // 还需要注意的是, jobrunr的cron表达式没有 '?'  并且只有6位数
    //At 10:15:10 AM, on day 20 of the month in September
    @Recurring(id = "jobA", cron = "10 15 10 20 9 *")
    @Job(name = "jobA")
    public void doRecurringJob() {
        System.out.println("Doing some work without arguments");
    }


}
