package com.example.demo.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Elijah
 * @create 2020-05-28 17:49
 */
@AllArgsConstructor
@Getter
public enum Gender {
    male(0, "男"),
    female(1, "女");

    @EnumValue
    @JsonValue
    private int value;
    private String name;
}
