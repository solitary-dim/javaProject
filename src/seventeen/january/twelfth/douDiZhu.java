package seventeen.january.twelfth;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/1/12
 * Time: 16:18
 */
public class douDiZhu {

    private static final int TOTAL = 54;
    private static final int GROUP = 3;

    private static final int MIN = (TOTAL - GROUP) / GROUP;
    private static final int MAX = MIN + GROUP;

    public static void main(String[] args) {
        String[] base = new String[TOTAL];
        List<Integer> list = new ArrayList<>();
        int i = 1;
        for (int j = 0; j < 52; j++) {
            switch (i) {
                case 1:
                    base[j] = "A";
                    break;
                case 11:
                    base[j] = "J";
                    break;
                case 12:
                    base[j] = "Q";
                    break;
                case 13:
                    base[j] = "K";
                    break;
                default:
                    base[j] = i + "";
                    break;
            }
            i++;
            while (i > 13) {
                i = 1;
            }
        }
        base[52] = "黑";
        base[53] = "紅";
        for (String str : base) {
            System.out.println(str);
        }
        System.out.println("========================================");

        i = 1;
        Random random = new Random();
        do {
            int m = random.nextInt(1024);
            m = m / 3;
            if (m < TOTAL && !list.contains(m)) {
                list.add(m);
                System.out.print(m + " ");
            }
            i++;
        } while (list.size() < TOTAL);
        System.out.println("\n" + i);
        System.out.println(list.size());
        System.out.println("========================================");

        String[] a = new String[MIN];
        String[] b = new String[MIN];
        String[] c = new String[MAX];
        i = 0;
        for (Integer index : list) {
            if (i < MIN) {
                a[i] = base[index];
            } else if (i < MIN * 2) {
                b[i - MIN] = base[index];
            } else {
                c[i - MIN * 2] = base[index];
            }
            i++;
            System.out.print(index + " ");
        }
        System.out.println("\n========================================");

        System.out.println("\n农民: ");
        for (String str : a) {
            System.out.print(str + " ");
        }
        System.out.println("\n农民: ");
        for (String str : b) {
            System.out.print(str + " ");
        }
        System.out.println("\n地主 : ");
        for (String str : c) {
            System.out.print(str + " ");
        }
        System.out.println("\n");


    }
}
