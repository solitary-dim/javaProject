package sixteen.july.javaframe;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2016/7/21
 * Time: 9:31
 */
public class Test {

    public static void main(String[] args) throws IOException {
        Image i = new Image("F:\\Tulips.jpg");
        i.setHeight(768);
        i.setWidth(1024);
        i.cutBigImg(true, 10);
    }
}
