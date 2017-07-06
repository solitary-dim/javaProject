package seventeen.july.generateColor;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/7/6
 * Time: 14:30
 */
public final class GenerateColors {

    public static void main(String[] args) {
        GenerateColors generateColors = new GenerateColors();
        List<String> list = generateColors.getColors(5);
        for (String str : list) {
            System.out.println("color: " + str);
        }
    }

    private List<String> getColors(int num) {
        //生成颜色
        Set<String> colors = new HashSet<>();
        while (colors.size() < num) {
            String r, g, b;
            Random random = new Random();
            r = Integer.toHexString(random.nextInt(256)).toUpperCase();
            g = Integer.toHexString(random.nextInt(256)).toUpperCase();
            b = Integer.toHexString(random.nextInt(256)).toUpperCase();
            r = r.length() == 1 ? "0" + r : r;
            g = g.length() == 1 ? "0" + g : g;
            b = b.length() == 1 ? "0" + b : b;
            colors.add("#" + r + g + b);
        }
        final List<String> colorArr = new ArrayList<>();
        for (String str : colors) {
            colorArr.add(str);
        }
        return colorArr;
    }
}
