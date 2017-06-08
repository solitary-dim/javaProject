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
        //ʮ����ת��ʮ�����ƣ�
        Integer.toHexString(num);
        System.out.println(Integer.toHexString(num));
        //ʮ����ת�ɰ˽���
        Integer.toOctalString(num);
        System.out.println(Integer.toOctalString(num));
        //ʮ����ת�ɶ�����
        Integer.toBinaryString(num);
        System.out.println(Integer.toBinaryString(num));

        //ʮ������ת��ʮ����
        Integer.valueOf("FFFF",16).toString();
        System.out.println(Integer.valueOf("FFFF",16).toString());
        //ʮ������ת�ɶ�����
        Integer.toBinaryString(Integer.valueOf("FFFF",16));
        System.out.println(Integer.toBinaryString(Integer.valueOf("FFFF",16)));
        //ʮ������ת�ɰ˽���
        Integer.toOctalString(Integer.valueOf("FFFF",16));
        System.out.println(Integer.toOctalString(Integer.valueOf("FFFF",16)));

        //�˽���ת��ʮ����
        Integer.valueOf("576",8).toString();
        System.out.println(Integer.valueOf("576",8).toString());
        //�˽���ת�ɶ�����
        Integer.toBinaryString(Integer.valueOf("23",8));
        System.out.println(Integer.toBinaryString(Integer.valueOf("23",8)));
        //�˽���ת��ʮ������
        Integer.toHexString(Integer.valueOf("23",8));
        System.out.println(Integer.toHexString(Integer.valueOf("23",8)));


        //������תʮ����
        Integer.valueOf("0101",2).toString();
        System.out.println(Integer.valueOf("0101",2).toString());
        //������ת�˽���
        Integer.toOctalString(Integer.parseInt("0101", 2));
        System.out.println(Integer.toOctalString(Integer.parseInt("0101", 2)));
        //������תʮ������
        Integer.toHexString(Integer.parseInt("0101", 2));
        System.out.println(Integer.toHexString(Integer.parseInt("0101", 2)));
    }
}
