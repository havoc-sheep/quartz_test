package com.envisioniot.quartz.service;

import java.util.concurrent.TimeUnit;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author YangHaojie
 * @date 2020/9/1
 */
public class BootstrapStart {

    private static Logger logger = LoggerFactory.getLogger(BootstrapStart.class);

    public static void main(String[] args) {

        try {
            // 获取Scheduler实例
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            // 启动调度器
            scheduler.start();

            /* 为观察程序运行，此设置主程序睡眠3分钟才继续往下运行（因下一个步骤是“关闭Scheduler”） */
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 关闭Scheduler
            scheduler.shutdown();

        } catch (SchedulerException se) {
            logger.error(se.getMessage(), se);
        }
    }
}
