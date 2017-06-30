package seventeen.june.thirtieth;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/30
 * Time: 20:41
 */
public class ChildObject extends ParentObject.Parent {

    public static void main(String[] args) {
        ChildObject childObject = new ChildObject();
        System.out.println(childObject.setAge(5));
    }
}
