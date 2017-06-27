package seventeen.june.eighth;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/8
 * Time: 10:44
 */
public class HexConversion {

    public static void main(String[] args) {
        int num = 20;
        //十进制转成十六进制：
        Integer.toHexString(num);
        System.out.println(Integer.toHexString(num));
        //十进制转成八进制
        Integer.toOctalString(num);
        System.out.println(Integer.toOctalString(num));
        //十进制转成二进制
        Integer.toBinaryString(num);
        System.out.println(Integer.toBinaryString(num));

        //十六进制转成十进制
        Integer.valueOf("FFFF",16).toString();
        System.out.println(Integer.valueOf("FFFF",16).toString());
        //十六进制转成二进制
        Integer.toBinaryString(Integer.valueOf("FFFF",16));
        System.out.println(Integer.toBinaryString(Integer.valueOf("FFFF",16)));
        //十六进制转成八进制
        Integer.toOctalString(Integer.valueOf("FFFF",16));
        System.out.println(Integer.toOctalString(Integer.valueOf("FFFF",16)));

        //八进制转成十进制
        Integer.valueOf("576",8).toString();
        System.out.println(Integer.valueOf("576",8).toString());
        //八进制转成二进制
        Integer.toBinaryString(Integer.valueOf("23",8));
        System.out.println(Integer.toBinaryString(Integer.valueOf("23",8)));
        //八进制转成十六进制
        Integer.toHexString(Integer.valueOf("23",8));
        System.out.println(Integer.toHexString(Integer.valueOf("23",8)));


        //二进制转十进制
        Integer.valueOf("0101",2).toString();
        System.out.println(Integer.valueOf("0101",2).toString());
        //二进制转八进制
        Integer.toOctalString(Integer.parseInt("0101", 2));
        System.out.println(Integer.toOctalString(Integer.parseInt("0101", 2)));
        //二进制转十六进制
        Integer.toHexString(Integer.parseInt("0101", 2));
        System.out.println(Integer.toHexString(Integer.parseInt("0101", 2)));
    }
}
