package org.apache.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName: RedisPool
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/7/17 19:00
 * @Version: V0.1
 */
public class RedisPool {
	private static JedisPool pool;//jedis连接池

	private static int maxTotal = 20;//最大连接数

	private static int maxIdle = 10;//最大空闲连接数

	private static int minIdle = 5;//最小空闲连接数

	private static boolean testOnBorrow = true;//在取连接时测试连接的可用性

	private static boolean testOnReturn = false;//再还连接时不测试连接的可用性

	static {
		initPool();//初始化连接池
	}

	public static Jedis getJedis(){
		return pool.getResource();
	}

	public static void close(Jedis jedis){
		jedis.close();
	}

	private static void initPool(){
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(maxTotal);
		config.setMaxIdle(maxIdle);
		config.setMinIdle(minIdle);
		config.setTestOnBorrow(testOnBorrow);
		config.setTestOnReturn(testOnReturn);
		config.setBlockWhenExhausted(true);
		pool = new JedisPool(config, "192.168.1.103", 6379, 5000);
	}
}
