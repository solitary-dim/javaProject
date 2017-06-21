package sixteen.september.recursion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by solitary.wang on 2016/3/24.
 */
public class Rabbit {

//    一般而言，兔子在出生两个月后，就有繁殖能力，一对兔子每个月能生出一对小兔子来。如果所有兔子都不死，那么一年以后可以繁殖多少对兔子？

    private static Long rab(int n){
        if (n < 0){
            return Long.valueOf(0);
        } else if(n == 0 || n == 1) {
            return Long.valueOf(1);
        } else {
            return rab(n-1) + rab(n-2);
        }
    }

    // n!
    private static Long Fac(int n){
        if(n == 1 || n == 0) {
            return Long.valueOf(1);
        } else {
            return n*Fac(n-1);
        }
    }

//    求一组整数中的最大(小)值（整数是一个int[]数组，个数未知）
    private static int max(int []num){
        if(num.length == 1){
            return num[0];
        } else if (num.length == 2) {
            return ( (num[0] > num[1]) ? num[0] : num[1]);
        } else {
            int []numb = new int[num.length-1];
            for(int i = 0 ; i < num.length-1 ; i ++){
                numb[i] = num[i];
            }
            return ( (max(numb) > num[num.length-1]) ? max(numb) : num[num.length-1]);
        }
    }

    public static void main(String[]args){
        System.out.println(rab(12));
        System.out.println(Fac(4));
        int []a = new int[]{1,25,12,456,15,26,42,15,48,65,35,15,4845};
        System.out.println(max(a));
        System.out.println("hel");
        Date date = new Date();
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
        System.out.println(dFormat.format(date));
    }
}
