package 创建型模式.单例模式.demo6;

/**
 * @Author: 邓国龙
 * @Date: 2023/6/8 23:04
 */
public class Client {
    public static void main(String[] args) {
        //1. 创建Singleton类的对象
        Singleton instance = Singleton.SINGLETON;
        Singleton instance1 = Singleton.SINGLETON;

        //2. 判断获取的两个对象是否是同一个对象
        System.out.println(instance == instance1);

    }
}
