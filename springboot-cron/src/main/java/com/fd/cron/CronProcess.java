package com.fd.cron;

import com.fd.cron.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronProcess {

    @Autowired
    @Qualifier(value = "facturaServiceImpl")
    private FacturaService facturaService;

    /**
     * //docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html
     * //www.quartz-scheduler.org/documentation/quartz-2.x/tutorials/tutorial-lesson-06
     * 0 0 0 * * ? = [second minute hour day month year] = Runs all years of all months of all days at 12:00 am
     * <p>
     * Examples:
     * 1. "0 0 12 ? * WED” - which means “every Wednesday at 12:00:00 pm".
     * 2.The '?' character is allowed for the day-of-month and day-of-week fields. It is used to specify “no specific value”.
     * 3.“0 0/5 * * * ?” // every 5 minutes.
     * 4.“10 0/5 * * * ?” // every 5 minutes, at 10 seconds after the minute (i.e. 10:00:10 am, 10:05:10 am, etc.).
     * 5.“0 30 10-13 ? * WED,FRI” //at 10:30, 11:30, 12:30, and 13:30, on every Wednesday and Friday.
     * 6. “0 0/30 8-9 5,20 * ?” //every half hour between the hours of 8 am and 10 am on the 5th and 20th of every month.
     */
    //@Scheduled(cron="0 0 0 * * ?")
    @Scheduled(cron = "0 0/1 * * * ?") //Programado cada minuto.
    public void process() {
        facturaService.sendBalance();
    }

}
