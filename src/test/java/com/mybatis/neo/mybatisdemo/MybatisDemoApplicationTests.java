package com.mybatis.neo.mybatisdemo;

import com.mybatis.neo.mybatisdemo.base.UserParam;
import com.mybatis.neo.mybatisdemo.enums.UserSexEnum;
import com.mybatis.neo.mybatisdemo.mapper.one.User1Mapper;
import com.mybatis.neo.mybatisdemo.model.User;
import com.mybatis.neo.mybatisdemo.result.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisDemoApplicationTests {
    @Resource
    private User1Mapper user1Mapper;

    /*
    crud  分别进行测试
     */
    @Test
    public void testUser() {
        user1Mapper.insert(new User("a2", "a123456", UserSexEnum.WOMAN));
//        List<User> userList = user1Mapper.getAll();
        User user = user1Mapper.getOne(1L);
//        user.setNickName("打豆豆");
//        user1Mapper.update(user);
//        user1Mapper.delete(1L);
        System.out.println(user);
    }

    /**
     * 分页测试
     */
    @Test
    public void contextLoads() {
        UserParam userParam=new UserParam();
        userParam.setUserSex("WOMAN");
        userParam.setCurrentPage(0);
        userParam.setPageSize(2);
        //查询 count 、list  封装成page 返回至前端
        // page中total 是long类型
        long count = user1Mapper.getCount(userParam);
        List<User> userList = user1Mapper.getList(userParam);
        //封装page 对象
        Page page = new Page(userParam,count,userList);
        System.out.println("page = " + page);
    }


}
