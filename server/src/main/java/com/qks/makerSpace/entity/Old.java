package com.qks.makerSpace.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Old {
    private String oldId;
    private String creditCode;
    private String organizationCode;
    private String name;
    private String password;
    private String represent;
    private String representPhone;
    private String registerAddress;
    private String representEmail;
    private String agent;
    private String agentPhone;
    private String agentEmail;
    private byte[] license;
    private String registerCapital;
    private String realAddress;
    private String realCapital;
    private String lastIncome;
    private String lastTax;
    private String employees;
    private String originNumber;
    private Timestamp setDate;
    private String nature;
    private byte[] certificate;
    private String involved;
    private String mainBusiness;
    private String way;
    private String business;
    private String oldDemand_id;
    private String oldShareholderId;
    private String oldMaipersonId;
    private String oldProjectId;
    private String oldIntellectualId;
    private String fundingId;
    private String cooperation;
    private String suggestion;
    private String note;
    private String state;
    private String submitTime;
    private String room;
    private String oldInapplyId;
    private String oldOutapplyId;
}
