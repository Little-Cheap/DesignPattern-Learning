package 创建型模式.单例模式.demo8;

/**
 * @Author: 邓国龙
 * @Date: 2023/6/8 22:59
 * 懒汉式 静态内部类方式
 */
public class Singleton {
    //私有构造方法
    private Singleton() {
    }

    //定义一个静态内部类 外部类加载不会加载内部类，只有内部类被使用了才会被调用
    private static class SingletonHolder {
        //在内部类中声明并初始化外部类的对象
        private static final Singleton SINGLETON = new Singleton();

    }

    //提供一个公共的访问方法，让外界获取该方法
    public static Singleton getInstance() {
        return SingletonHolder.SINGLETON;
    }
}
