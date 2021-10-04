package com.qks.makerSpace.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    @NonNull
    private String employeeId;

    private String enterpriseId;
    private String teamName;

    private Integer employees;
    private Integer doctor;
    private Integer master;
    private Integer graduate;
    private Integer bachelor;
    private Integer college;
    private Integer tecSecondary;
    private Integer tecActivists;
    private Integer radNumber;
    private Integer returnees;
    private Integer talents;
    private Integer trainee;

}
