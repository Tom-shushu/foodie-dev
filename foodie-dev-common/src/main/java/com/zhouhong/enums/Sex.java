package com.zhouhong.enums;

/**
 * @ClassName: Sex
 * @Description:性别 枚举
 * @Author: 周红
 * @NickName: Tom-shuhu
 * @Date: Created in 2020/12/15
 **/

public enum Sex {
    woman(0, "女"),
    man(1, "男"),
    secret(2, "保密");

    public final Integer type;
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
