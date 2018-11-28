package com.mybatis.neo.mybatisdemo;

import com.mybatis.neo.mybatisdemo.enums.UserSexEnum;
import com.mybatis.neo.mybatisdemo.mapper.one.User1Mapper;
import com.mybatis.neo.mybatisdemo.mapper.two.User2Mapper;
import com.mybatis.neo.mybatisdemo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @auther SyntacticSugar
 * @data 2018/11/28 0028下午 5:45
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiDataSourceTest {

    @Autowired
    private User1Mapper user1Mapper;
    @Autowired
    private User2Mapper user2Mapper;

    @Test
    public void test() {
        user1Mapper.insert(new User("aa111", "a123456", UserSexEnum.MAN));
        user1Mapper.insert(new User("bb111", "b123456", UserSexEnum.WOMAN));
        user2Mapper.insert(new User("cc222", "b123456", UserSexEnum.MAN));
    }
}
