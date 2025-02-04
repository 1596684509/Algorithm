import Algorithm.PrefixSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrefixSumT {

    @Test
    public void t() {

        PrefixSum prefixSum = new PrefixSum(new int[]{1, 7, 3, 6, 5 ,6});
        Assertions.assertEquals(6, prefixSum.rangeSum(0, 2));

    }

}
