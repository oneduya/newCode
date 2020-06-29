package org.apache.ibatis.dddybtest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {

	public UserDao userDao;
	public SqlSession sqlSession;

	@Before
	public void setUp() throws Exception {
		// mybatis-config.xml
		String resource = "mybatis-config2.xml";
		// 读取配置文件
		InputStream is = Resources.getResourceAsStream(resource);
		// 构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 获取sqlSession
		sqlSession = sqlSessionFactory.openSession();
//		this.userDao = new UserDaoImpl(sqlSession);
		this.userDao = sqlSession.getMapper(UserDao.class);
	}

	@Test
	public void queryUserById() {
		System.out.println(this.userDao.queryUserById("1"));
	}

	@Test
	public void queryUserAll() {
		List<User> userList = this.userDao.queryUserAll();
		for (User user : userList) {
			System.out.println(user);
		}
	}

	@Test
	public void insertUser() {
		User user = new User();
		user.setId("4");
		user.setAge(16);
		user.setBirthday(new Date("1990/09/02"));
		user.setName("大鹏");
		user.setPassword("123456");
		user.setSex(1);
		user.setUserName("evan");
		this.userDao.insertUser(user);
		this.sqlSession.commit();
	}

	@Test
	public void updateUser() {
		User user = new User();
		user.setBirthday(new Date());
		user.setName("静鹏");
		user.setPassword("654321");
		user.setSex(1);
		user.setUserName("evanjin");
		user.setId("1");
		this.userDao.updateUser(user);
		this.sqlSession.commit();
	}

	@Test
	public void deleteUser() {
		this.userDao.deleteUser("4");
		this.sqlSession.commit();
	}
}