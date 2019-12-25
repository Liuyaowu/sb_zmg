package com.mobei.bootlaunch.model.yaml;

import lombok.Data;

import java.util.List;

@Data
public class Child {
    private String name;
    private String age;
    private List<Friend> friends;
}
