package com.group12.salary.config;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//工具类，mapper静态代理
public class MapperTools {


    /**
     * 使用的是静态方法
     * @return
     * @throws IOException
     */
    public static SqlSession getSqlSession() throws IOException{
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //开启会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSession;
    }

}