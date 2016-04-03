package mine;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisTestMain {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    // ###1.连接到 redis 服务
    Jedis jedis = new Jedis("localhost");
    System.out.println("Connection to server sucessfully");
    // 查看服务是否运行
    System.out.println("1. Server is running: " + jedis.ping());

    // ###2.Redis Java String(字符串) 实例
    // 设置 redis 字符串数据
    jedis.set("w3ckey", "Redis tutorial");
    // 获取存储的数据并输出
    System.out.println("2. Stored string in redis:: " + jedis.get("w3ckey"));

    // ###3.Redis Java List(列表) 实例
    // 存储数据到列表中
    jedis.lpush("tutorial-list", "Redis");
    jedis.lpush("tutorial-list", "Mongodb");
    jedis.lpush("tutorial-list", "Mysql");
    jedis.lpush("tutorial-list", "Mysql1");
    jedis.lpush("tutorial-list", "Mysql2");
    jedis.lpush("tutorial-list", "Mysql3");
    // 获取存储的数据并输出
    List<String> list = jedis.lrange("tutorial-list", 0, 5);
    for (int i = 0; i < list.size(); i++) {
      System.out.println("3.1. Stored string in redis:: " + list.get(i));
    }
    // 使用 lambda 表达式以及函数操作(functional operation)
    list.forEach((d) -> {
      if (d.contains("Mysql")) {
        System.out.print("3.2. Stored string in redis:: " + d);
      }
      System.out.print("\n");
    });
    // 在 Java 8 中使用双冒号操作符(double colon operator)
    System.out.println("3.3. Stored string in redis:\n");
    list.forEach(System.out::println);

    // 4. Redis Java Keys 实例
    // 获取数据并输出
    Set<String> list2 = jedis.keys("*");
    list2.forEach((k) -> System.out.println("3.4. List of stored keys:: " + k));
  }
}
