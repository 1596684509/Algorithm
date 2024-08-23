package LeetCode.Easy;

public class E461 {

    public int hammingDistance(int x, int y) {

        int z = x ^ y;

        z = z - ((z >>> 1) & 0x55555555);
        z = (z & 0x33333333) + ((z >>> 2) & 0x33333333);
        z = (z + (z >>> 4)) & 0x0f0f0f0f;
        z = z + (z >>> 8);
        z = z + (z >>> 16);

        return z & 0x3f;

    }

}
