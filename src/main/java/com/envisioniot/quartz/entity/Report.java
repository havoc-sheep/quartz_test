package com.envisioniot.quartz.entity;

import lombok.Data;

import java.util.List;

/**
 * @author YangHaojie
 * @date 2020/9/1
 */
@Data
public class Report {
    private String reportId;

    private String emailAddress;

    private String name;

    private String crontab;

    private String url;

    private List<String> params;

    public Report(String reportId, String emailAddress, String name, String crontab, String url, List<String> params) {
        this.reportId = reportId;
        this.emailAddress = emailAddress;
        this.name = name;
        this.crontab = crontab;
        this.url = url;
        this.params = params;
    }

}
