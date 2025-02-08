package com.test.miniproject.ctr.dto;

import java.beans.ConstructorProperties;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Data;

@Data
public class SaveUserDto {
    private final String name;
    private final String password;

    @ConstructorProperties({"name", "password"})
    @JsonCreator
    public SaveUserDto(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
