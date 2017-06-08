package seventeen.may.tweentyforth;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/5/24
 * Time: 10:08
 */
public class May24thTest {

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        Set<String> set = new HashSet<>();
        set.add("posCertIdImage");
        set.add("firBuzAreaImage");
        set.add("handCertIdImage");
        set.add("secBuzAreaImage");
        set.add("buzLicenImage");
        set.add("openPerImage");
        if (set.contains("posCertIdImage")) {
            System.out.println("hello");
        }
    }
}
