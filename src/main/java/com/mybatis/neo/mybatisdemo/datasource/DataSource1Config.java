package com.mybatis.neo.mybatisdemo.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 创建多数据源的过程就是：首先创建 DataSource，
 * 注入到 SqlSessionFactory 中，再创建事务，
 * 将 SqlSessionFactory 注入到创建的 SqlSessionTemplate 中，
 * 最后将 SqlSessionTemplate 注入到对应的 Mapper 包路径下。
 * 其中需要指定分库的 Mapper 包路径。
 */
@Configuration
@MapperScan(basePackages = "com.mybatis.neo.mybatisdemo.mapper.one", sqlSessionTemplateRef = "oneSqlSessionTemplate")
public class DataSource1Config {
    /**
     * 加载配置数据源
     *
     * @return
     * @Primary 是指具有默认值
     */
    @Bean(name = "oneDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.one")
    @Primary
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 根据数据源创建  sqlsessionFactory
     *
     * @Qualifier("oneDataSource") 传参
     * 指明需要加载的 Mapper xml 文件。
     */

    @Bean(name = "oneSqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("oneDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/one/*.xml"));
        //Resource[] mapperLocations
        return bean.getObject();
    }

    /**
     * 添加事务
     * transactionManager需要datasource
     */
    @Bean(name = "oneTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("oneDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 需要  sqlSessionFactory 来创建
     * sqlSessionTemplate 模板
     */
    @Bean(name = "oneSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("oneSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * sqlSessionTemplate 用来操作mapper接口中的crud
     * 所以，把sqlSessionTemplate 传入mapper的包路径下
     * 在  @MapperScan
     */
}
