package sixteen.february.sixteenth.inherit;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2/16/16
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class test {
    public static void main(String[]args){
        // 11!
        int i = 1;
        int sum = 1;
        for(int m = 0 ; m < 10 ; m++){
            sum = sum * (i+1);
            i++;
        }
        System.out.println(sum);
    }
}
