/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/01
 */

import com.qf.dao.PeopleDao;
import com.qf.pojo.People;
import com.qf.utils.SessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * 人测试类
 */
public class TestPeople {
    /**
     * 增加人数据测试方法
     * @throws IOException
     */
    @Test
    public void TestInsertPeopleGenId02() throws IOException {
        /*//创建session对象
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PeopleDao peopleDao = sqlSession.getMapper(PeopleDao.class);*/
        PeopleDao peopleDao = (PeopleDao) SessionUtils.getDao(PeopleDao.class);
        //创建people对象,并赋值
        People people = new People();
        people.setUsername("lisi");
        people.setAge(17);
        people.setGender("male");
        people.setAddr("中国");
        people.setInfo("李四");
        //执行增加数据并返回id
        int i = peopleDao.insertPeopleGenId02(people);
        System.out.println(i);
        System.out.println(people.getId());
        //提交和关闭session
        SessionUtils.commitAndClose();
        /*sqlSession.commit();
        sqlSession.close();*/
    }
}
