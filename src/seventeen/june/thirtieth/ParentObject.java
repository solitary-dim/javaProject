package seventeen.june.thirtieth;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/30
 * Time: 20:38
 */
public class ParentObject {

    static class Parent {
        int age;

        int setAge(int i) {
            age = i;
            return age;
        }

        public Parent() {
            System.out.println("this is a inner class!");
        }
    }

    public static void main(String[] args) {
        //Parent parent = new Parent();
        System.out.println("this is a class with inner class");
    }
}
