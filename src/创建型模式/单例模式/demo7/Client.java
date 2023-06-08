package 创建型模式.单例模式.demo7;

import java.io.*;

/**
 * @Author: 邓国龙
 * @Date: 2023/6/8 23:04
 */
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Client.writeObjectToFile();
        Client.readObjectFromFile();
        Client.readObjectFromFile();
    }



    public static void readObjectFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\学习\\设计模式\\DesignPattern-Learning\\src\\创建型模式\\单例模式\\demo7\\a.txt"));
        Singleton instance = (Singleton)objectInputStream.readObject();
        System.out.println(instance);
        objectInputStream.close();
    }

    public static void writeObjectToFile() throws IOException {
        Singleton instance = Singleton.getInstance();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\学习\\设计模式\\DesignPattern-Learning\\src\\创建型模式\\单例模式\\demo7\\a.txt"));
        objectOutputStream.writeObject(instance);
        objectOutputStream.close();
    }
}
