package seventeen.june.eighth;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/8
 * Time: 10:38
 */
public class GenerateUUID {

    /*
     GUID��һ��128λ�������֣�һ����16���Ʊ�ʾ��
     �㷨�ĺ���˼���ǽ�ϻ���������������ʱ�䡢һ���漴��������GUID��
     �������Ͻ������һ̨����ÿ�����10000000��GUID������Ա�֤�����������ϣ�3240�겻�ظ���
     */

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }
}
