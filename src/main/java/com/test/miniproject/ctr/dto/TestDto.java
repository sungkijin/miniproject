package com.test.miniproject.ctr.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Data;

@Data
public class TestDto {
    private final String email;
    private final String password;
    private final String regdate;

    @JsonCreator
    public TestDto(String email, String password, String regdate) {
        this.email = email;
        this.password = password;
        this.regdate = regdate;
    }
}
