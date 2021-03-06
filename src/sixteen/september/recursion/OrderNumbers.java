package sixteen.september.recursion;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2016/9/14
 * Time: 10:48
 */
public class OrderNumbers {

    public static void main(String[] args){

        String ids[] = {"11", "02", "", "546"};
        for (String id : ids) {

            System.out.println(Long.valueOf(id));
        }

        String s = "fd12323124214";
        System.out.println(s.replace("$,", ""));

        //int olds[] = {104,120,122,137,141,154,124,125,138,139,147,216,149,153,166,152,167,168,156,157,158,159,160,161,162,163,164,165,169,174,175,178,179,184,188,189,170,171,172,173,176,177,180,181,182,183,185,186,193,214,217,220,221,222,223,224,225,227,228,229,236,226,218,234,235,240};
        //int news[] = {137,138,139,141,147,149,152,153,154,156,157,158,159,160,161,162,163,164,165,166,167,168,169,171,172,173,175,176,177,178,180,181,182,184,185,186,188,189,193,214,216,217,218,220,221,222,223,224,225,226,227,228,229,104,234,235,236,240,120,122,124,125};
        int olds[] = {104,120,122,137,141,154,124,125,138,139,147,216,149,153,166,152,167,168,156,157,158,159,160,161,162,163,164,165,169,175,178,184,188,189,171,172,173,176,177,180,181,182,185,186,193,214,217,220,221,222,223,224,225,227,228,229,236,226,218,234,235,240};
        int news[] = {137,138,139,141,147,149,152,153,154,156,157,158,159,160,161,162,163,164,165,166,167,168,169,171,172,173,175,176,177,178,180,181,182,184,185,186,188,189,193,214,216,217,218,220,221,222,223,224,225,226,227,228,229,104,234,235,236,240,120,122,124,125};
        sortLTB(olds);
        sortLTB(news);
    }

    //从小到大排序
    public static void sortLTB(int arr[]){
        int num = arr.length;
        String s = "";


        for (int i = 1 ; i < num ; i++)  {
            for ( int j = 0 ; j < i ; j++){
                if (arr[i] < arr[j]) {
                    int sus = arr[j];
                    arr[j] = arr[i];
                    arr[i] = sus;
                }
            }
        }
        for (int i = 0 ; i < num; i++) {
            s += ","+arr[i];
        }
        System.out.println(s);
    }

}
