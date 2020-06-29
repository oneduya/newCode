package org.apache.ibatis.dddybtest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: MybatisTEst
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/6/26 16:11
 * @Version: V0.1
 */
public class MybatisTest {
	public static void main(String[] args) throws IOException {
		// 指定全局配置文件
		String resource = "mybatis-config2.xml";
		InputStream inputStream;
		// 构建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory;
		SqlSession sqlSession;
		// 读取配置文件
		inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 获取sqlSession
		sqlSession = sqlSessionFactory.openSession();
		// 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
		// 第二个参数：指定传入sql的参数：这里是用户id
		User user = sqlSession.selectOne("MyMapper.selectUser", 1);
		System.out.println(user);
		sqlSession.close();
	}
}
