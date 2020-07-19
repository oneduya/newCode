package org.apache.redis;

import redis.clients.jedis.Jedis;

/**
 * @ClassName: PfTest
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/7/18 21:10
 * @Version: V0.1
 */
public class PfTest {
	public static void main(String[] args) {
		Jedis jedis = new Jedis();
		jedis.del("codehole");
		for (int i=0; i<100000; i++) {
			jedis.pfadd("codehole", "user"+i);
		}
		long total = jedis.pfcount("codehole");
		System.out.printf("%d %d",10000,total);
		jedis.close();
	}
}
