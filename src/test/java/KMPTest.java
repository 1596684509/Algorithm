import Algorithm.KMP;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class KMPTest {

    private static KMP kmp;

    @BeforeAll
    public static void init() {

        kmp = new KMP("leetcode", "code");

    }

    @Test
    public void Text1() {

        System.out.println(kmp.getIndex());

    }

}
