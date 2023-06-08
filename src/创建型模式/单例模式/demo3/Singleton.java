package 创建型模式.单例模式.demo3;

/**
 * @Author: 邓国龙
 * @Date: 2023/6/8 22:59
 * 懒汉式
 */
public class Singleton {
    //私有构造方法
    private Singleton() {
    }

    //在本类中创建本类对象
    private static Singleton singleton;

    //提供一个公共的访问方法，让外界获取该方法
    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
