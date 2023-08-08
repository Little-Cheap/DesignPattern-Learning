package 创建型模式.单例模式.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 邓国龙
 * @Date: 2023/8/8 16:52
 */
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(" ");
        list.add("1111");
        list.add("2222");
        list.add("3333");
        List<String> collect = list.stream().filter(str -> {
            return !str.isBlank();
        }).toList();
        System.out.println("1111111111");
        System.out.println(collect);
    }
}
