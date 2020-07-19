package org.apache.ibatis.dddybtest;

import sun.misc.Contended;

import java.beans.Transient;
import java.io.*;
import java.util.Date;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/6/26 16:17
 * @Version: V0.1
 */
public class User implements Externalizable {
	private static final long serialVersionUID = 930043933147295183L;

	private String id;
	private String userName;
	private String password;
	private String name;
	private Integer age;
	private Integer sex;
	private transient Date birthday;
	private String created;
	private String updated;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", sex=" + sex +
				", birthday=" + birthday +
				", created='" + created + '\'' +
				", updated='" + updated + '\'' +
				'}';
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(age);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		age = in.readInt();
	}
}
