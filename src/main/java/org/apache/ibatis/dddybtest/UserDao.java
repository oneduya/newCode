package org.apache.ibatis.dddybtest;

import java.util.List;

/**
 * @ClassName: UserDao
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/6/26 19:15
 * @Version: V0.1
 */
public interface UserDao {
	/**
	 * 根据id查询用户信息
	 *
	 * @param id
	 * @return
	 */
	public User queryUserById(String id);

	/**
	 * 查询所有用户信息
	 *
	 * @return
	 */
	public List<User> queryUserAll();

	/**
	 * 新增用户
	 *
	 * @param user
	 */
	public void insertUser(User user);

	/**
	 * 更新用户信息
	 *
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * 根据id删除用户信息
	 *
	 * @param id
	 */
	public void deleteUser(String id);
}
