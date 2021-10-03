package com.qf.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/01
 */
public class SessionUtils {
    private static SqlSessionFactory sqlSessionFactory=null;
    private static InputStream inputStream=null;
    private static SqlSession sqlSession =null;
    private static final String XML= "mybatis-config.xml";
    private static ThreadLocal<SqlSession> threadLocal= new ThreadLocal<SqlSession>();
    static {
        try {
            //数据流
           inputStream = Resources.getResourceAsStream(XML);
            //创建session对象
            if (inputStream!=null){
                sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
                sqlSession=sqlSessionFactory.openSession();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得session对象
     * @return
     */
    public static SqlSession getSession(){
        return sqlSession;
    }

    public static Object getDao(Class clazz){
        return SessionUtils.getSession().getMapper(clazz);
    }

    /**
     * 提交和关闭
     */
    public static void commitAndClose(){
        try {
             if (sqlSession!=null){
            sqlSession.commit();
            sqlSession.close();
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
