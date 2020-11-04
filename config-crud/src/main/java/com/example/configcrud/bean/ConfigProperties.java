package com.example.configcrud.bean;

import lombok.Data;

@Data
public class ConfigProperties {

    private int id;

    private String key1;

    private String value1;

    private String label;

    private String application;

    private String profile;
}