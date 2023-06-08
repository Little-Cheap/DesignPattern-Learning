package 创建型模式.单例模式.demo9;

import java.io.Serializable;

/**
 * @Author: 邓国龙
 * @Date: 2023/6/8 22:59
 * 除了枚举实现类型，其它类型的单例模式会序列化，反序列化破坏单例模式
 * 解决方法
 */
public class Singleton implements Serializable {
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

    //当进行反序化是，会自动调用该方法，将该方法的返回值直接返回
    public Object readResolve(){
        return SingletonHolder.SINGLETON;
    }
}
