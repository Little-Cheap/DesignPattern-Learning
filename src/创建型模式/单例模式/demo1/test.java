package 创建型模式.单例模式.demo1;

/**
 * @Author: 邓国龙
 * @Date: 2023/6/21 10:03
 */
public class test {
    public static void main(String[] args) {
//        String url = "https://eplattest.baoiem.com/imps-mp/service/MPQM03/setTechnicalDirector";
//        String substring = url.substring(0, url.indexOf("imps-mp"))+"imps-mc";
//        System.out.println(substring);
        byte a = 127;
        byte b = 127;
//        b =(byte) (a + b); // error : cannot convert from int to byte
//        System.out.println(b);
        b += a; // ok
        System.out.println(b);

        switch ("1234565"){
            case "1223" :
                System.out.println("1222");
        }

    }
}
