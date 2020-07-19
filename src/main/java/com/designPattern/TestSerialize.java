package com.designPattern;

import com.leetcode.Test;
import org.apache.ibatis.dddybtest.User;

import java.io.*;

/**
 * @ClassName: TestSerialize
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/7/16 7:42
 * @Version: V0.1
 */
public class TestSerialize {
	public void serialize() throws IOException {
		User user = new User();//创建需要序列化的对象
		user.setId("1111");
		user.setAge(25);
		user.setName("dddyb");
		//创建对象输出流，以文件输出流为参数
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E://user"));
		//写入
		oos.writeObject(user);
		//关闭流
		oos.close();
		System.out.println("serialized successfully!");
	}

	public void deserialize() throws IOException, ClassNotFoundException {
		//创建文件对象
		File file = new File("E://user");
		//创建对象输入流，以文件输入流为参数
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		User newUser = (User) ois.readObject();
		ois.close();
		System.out.println("deserialize successfully!");
		System.out.println(newUser.toString());
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
	}
}
