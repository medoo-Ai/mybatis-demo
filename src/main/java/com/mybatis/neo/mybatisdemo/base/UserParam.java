package com.mybatis.neo.mybatisdemo.base;

import lombok.Getter;
import lombok.Setter;

/**
 * @auther SyntacticSugar
 * @data 2018/11/28 0028下午 3:12
 */

public
@Getter
@Setter
class UserParam extends PageParam {
    private String userName;
    private String userSex;
}
