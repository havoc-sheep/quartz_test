package com.envisioniot.quartz.entity;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author YangHaojie
 * @date 2020/8/31
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class ColorJob implements Job {
    private static Logger logger = LoggerFactory.getLogger(ColorJob.class);

    public static final String FAVORITE_COLOR = "favorite color";
    public static final String EXECUTION_COUNT = "count";

    // 由于Quartz会在每次执行时重新实例化一个类，因此成员非静态成员变量不能用于维护状态！
    private int _counter = 1;

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        logger.info(getClass().getName());

        JobKey jobKey = context.getJobDetail().getKey();

        JobDataMap data = context.getJobDetail().getJobDataMap();
        String favoriteColor = data.getString(FAVORITE_COLOR);
        int count = data.getInt(EXECUTION_COUNT);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println("任务Key: " + jobKey + " ,执行时间:  "
                + sdf.format(new Date()) + "\n" + "  传递参数(favorite color): "
                + favoriteColor + "\n" + "  传递参数(count):  " + count + "\n"
                + "  ColorJob非静态变量值: " + _counter + "\n");

        count++;
        data.put(EXECUTION_COUNT, count);
        data.put(FAVORITE_COLOR, "黄色");
        _counter++;
    }

}
