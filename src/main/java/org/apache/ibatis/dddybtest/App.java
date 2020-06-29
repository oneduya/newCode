package org.apache.ibatis.dddybtest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @ClassName: App
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/6/23 8:51
 * @Version: V0.1
 */
public class App {
	public static void main(String[] args) throws Exception
	{
		//不好用了
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		/*2、获取sqlSession实例，能直接执行已经映射的sql语句*/
		SqlSession openSession = sqlSessionFactory.openSession();

		try {
            /* sql语句的唯一标识
               执行sql要用的参数 */
			Employee employee = openSession.selectOne("org.apache.ibatis.dddybtest.EmployeeMapper.selectEmp", 2);
			System.out.println(employee);
		} finally {
			openSession.close(); // 关闭openSession
		}
	}
}
