package cn.sepiggy;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RedisTest {

    @Test
    public void testRedisJava() {
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");

        System.out.println("连接成功");
        // 查看服务是否运行
        System.out.println("服务正在运行：" + jedis.ping());
    }

    @Test
    public void testRedisStringJava() {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");

        // 设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        System.out.println("redis 存储的字符串为：" + jedis.get("runoobkey"));
    }

    @Test
    public void testRedisListJava() {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");

        // 存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");

        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0, 2);
        for (String s : list) {
            System.out.println("列表项为：" + s);
        }
    }

    @Test
    public void testRedisKeyJava() {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");

        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key);
        }
    }
}
