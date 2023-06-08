package 创建型模式.单例模式.demo11;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: 邓国龙
 * @Date: 2023/6/9 1:41
 */
public class RunTimeDemo {
    public static void main(String[] args) throws IOException {
        //获取RunTime对象
        Runtime runtime = Runtime.getRuntime();
        //调用runtime的exec方法，参数是一个命令
        Process ipconfig = runtime.exec("ipconfig");
        InputStream inputStream = ipconfig.getInputStream();
        byte[] bytes = new byte[1024 * 1024 * 100];
        int read = inputStream.read(bytes);
        System.out.println(new String(bytes,0,read,"GBK"));
    }
}
