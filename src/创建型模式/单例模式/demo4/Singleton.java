package 创建型模式.单例模式.demo4;

/**
 * @Author: 邓国龙
 * @Date: 2023/6/8 22:59
 * 懒汉式 双重检查锁
 */
public class Singleton {
    //私有构造方法
    private Singleton() {
    }

    //在本类中创建本类对象
    //使用volatile 因为volatile具有保证可见性和避免因指令重排，避免了在多线程情况下，因指令重排导致的对象空指针的问题
    private static volatile Singleton singleton;

    //提供一个公共的访问方法，让外界获取该方法
    public static  Singleton getInstance() {
        // 第一次判断 如果第一次的值不是null，不需要抢占锁，直接返回对象
        if (singleton == null) {
            synchronized (Singleton.class){
                //第二次判断
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
