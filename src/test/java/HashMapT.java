import DataStructure.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashMapT {

    @Test
    public void t() {

        HashMap hashMap = new HashMap();
        hashMap.add("key1", 1);
        hashMap.add("key2", 2);
        hashMap.add("key3", 3);
        hashMap.add("key4", 4);

        Assertions.assertEquals(4, hashMap.size());

        Assertions.assertEquals(2, hashMap.remove("key2"));

        Assertions.assertFalse(hashMap.isEmpty());

        Assertions.assertEquals(3, hashMap.size());

        Assertions.assertEquals(1, hashMap.get("key1"));

        hashMap.remove("key1");
        hashMap.remove("key3");
        hashMap.remove("key4");
        Assertions.assertTrue(hashMap.isEmpty());




    }

}
