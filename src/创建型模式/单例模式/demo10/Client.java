package 创建型模式.单例模式.demo10;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: 邓国龙
 * @Date: 2023/6/8 23:04
 * 反射破坏单例模式
 * 解决方法
 */
public class Client {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //获取Singleton的字节码对象
        Class<Singleton> singletonClass = Singleton.class;
        //获取无参构造方法
        Constructor<Singleton> declaredConstructor = singletonClass.getDeclaredConstructor();
        //取消访问检查 因为是私有的构造方法
        declaredConstructor.setAccessible(true);
        //创建Singleton对象
        Singleton singleton = declaredConstructor.newInstance();
        Singleton singleton1 = declaredConstructor.newInstance();
        System.out.println(singleton1 == singleton);

    }
}
