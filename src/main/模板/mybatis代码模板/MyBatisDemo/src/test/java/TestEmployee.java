import com.qf.dao.EmployeeDao;
import com.qf.pojo.Employee;
import com.qf.utils.SessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/01
 */
public class TestEmployee {
    /**
     * 添加用户测试
     * @throws IOException
     */
    @Test
    public void TestInsertEmployee() throws IOException {
       /* //创建session对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        //获取sql对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行会话
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);*/
        EmployeeDao employeeDao = (EmployeeDao) SessionUtils.getDao(EmployeeDao.class);
        //创建employee对象，赋值
        Employee employee = new Employee();
        employee.setUsername("wangba");
        employee.setPassword("bawang");
        employee.setInfo("NO5");
        int i = employeeDao.insertEmployee(employee);
        System.out.println("i = " + i);
        //提交请求，关闭请求
        SessionUtils.commitAndClose();
        /*sqlSession.commit();
        sqlSession.close();*/
    }

    /**
     * 删除用户
     * @throws IOException
     */
    @Test
    public void TestDeleteEmployee() throws IOException {
        /*//创建session对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        //获取sql对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = SessionUtils.getSession();
        //执行会话
          EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);*/
        EmployeeDao employeeDao = (EmployeeDao) SessionUtils.getDao(EmployeeDao.class);
        /* Class session = SessionUtils.getSession(EmployeeDao);*/

        int i = employeeDao.deleteEmployee(10);
        System.out.println("i = " + i);
        //提交请求，关闭请求
        SessionUtils.commitAndClose();
       /* sqlSession.commit();
        sqlSession.close();*/
    }

    /**
     * 修改用户信息
     * @throws IOException
     */
    @Test
    public void TestUpdateEmployee() throws IOException {
        /*//创建session对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        //获取sql对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行会话
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);*/
        EmployeeDao employeeDao= (EmployeeDao) SessionUtils.getDao(EmployeeDao.class);

        //创建employee对象
        Employee employee = new Employee();
        employee.setId(4);
        employee.setUsername("wangba1");
        employee.setPassword("bawang1");
        employee.setInfo("NO5");
        //调用修改方法
        int i = employeeDao.updateEmployee(employee);

        System.out.println("i = " + i);
        //提交请求，关闭请求
        SessionUtils.commitAndClose();
        /*sqlSession.commit();
        sqlSession.close();*/
    }
    @Test
    public void TestShowEmployeeById() throws IOException {
        /*//创建session对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        //获取sql对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行会话
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);*/
        EmployeeDao employeeDao= (EmployeeDao) SessionUtils.getDao(EmployeeDao.class);
        Employee employee = employeeDao.showEmployeeById(1);
        System.out.println("employee = " + employee);
        //提交请求，关闭请求
        SessionUtils.commitAndClose();
        /*sqlSession.commit();
        sqlSession.close();*/
    }
    @Test
    public void TestShowAllEmployee() throws IOException {
        /*//创建session对象
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        //获取sql对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行会话
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);*/
        EmployeeDao employeeDao = (EmployeeDao) SessionUtils.getDao(EmployeeDao.class);
        List<Employee> employees = employeeDao.showAllEmployee();
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
        //提交请求，关闭请求
        SessionUtils.commitAndClose();
        /*sqlSession.commit();
        sqlSession.close();*/
    }
    @Test
    public void TestshowEmployeeByUsername() throws IOException {
        //创建session对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        //获取sql对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行会话
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        List<Employee> employees = employeeDao.showEmployeeByUsername("zhang");
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
        //提交请求，关闭请求
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void TestInsertEmployeeGenId01() throws IOException {
        //创建session对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        //获取sql对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行会话
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        //创建employee对象,赋值
        Employee employee = new Employee();
        employee.setUsername("wangba");
        employee.setPassword("bawang");
        employee.setInfo("NO6");
        System.out.println("employee = " + employee);
        //执行添加员工，输出员工id
        int i = employeeDao.insertEmployeeGenId01(employee);
        System.out.println("i = " + i);
        System.out.println(employee.getId());
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void TestInsertEmployeeGenId02() throws IOException {
        //创建session对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        //获取sql对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行会话
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        //创建employee对象,赋值
        Employee employee = new Employee();
        employee.setUsername("wangqi");
        employee.setPassword("qiwang");
        employee.setInfo("NO7");
        System.out.println("employee = " + employee);
        //执行添加功能
        int i = employeeDao.insertEmployeeGenId02(employee);
        System.out.println("i = " + i);
        System.out.println(employee.getId());
        sqlSession.commit();
        sqlSession.close();
    }

}
