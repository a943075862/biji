package com.qf.utils;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/02
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * mybatis工具类
 *      获取sqlsession对象
 *      提交commit
 *      回滚rollback
 */
public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;
    private static final ThreadLocal<SqlSession> THREAD_LOCAL = new ThreadLocal();

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession openSqlsession()  {
        SqlSession sqlSession=THREAD_LOCAL.get();
        if (sqlSession == null) {
            sqlSession=sqlSessionFactory.openSession();
            THREAD_LOCAL.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭连接
     */
    public static void closeSession(){
        SqlSession sqlSession=openSqlsession();
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 回滚,
     */
      public static void rollbackSession(){
        SqlSession sqlSession=openSqlsession();
        sqlSession.rollback();
        sqlSession.close();
    }

    /**
     * 获取mapper对象
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends Object>T getMapper(Class<T> clazz){
        SqlSession sqlSession = openSqlsession();
        return sqlSession.getMapper(clazz);
    }
}
