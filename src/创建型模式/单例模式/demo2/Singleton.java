package 创建型模式.单例模式.demo2;

/**
 * @Author: 邓国龙
 * @Date: 2023/6/8 22:59
 * 饿汉式：静态代码块
 */
public class Singleton {
    //1.私有构造方法
    private Singleton() {
    }

    //2.在本类中创建本类对象
    private static Singleton singleton;

    //3. 在静态代码块中进行赋值
    static {
        singleton = new Singleton();
    }

    //3.提供一个公共的访问方法，让外界获取该方法
    public static Singleton getInstance() {
        return singleton;
    }
}
