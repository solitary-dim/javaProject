package seventeen.july.mapNullPointTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 17-7-3
 * Time: 下午1:59
 * To change this template use File | Settings | File Templates.
 */
public class TreeAndLeafTest {

    public static void main(String[] args) {
        Map<String, Leaf> leaves = new HashMap<>();
        Tree tree = new Tree();
        tree.setLeaves(leaves);
        Map ma = tree.getLeaves();
        Leaf leaf = (Leaf) ma.get("sa");
        if (null == leaf) {
            System.out.println("null");
        } else {
            System.out.println("value=" + leaf.getNum());
        }
        System.out.println("end");
    }
}
