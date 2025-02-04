package Algorithm;

public class PrefixSum {

    private int[] meta;
    private int[] prefix;

    /**
     * 计算前缀和
     * @param meta
     */
    public PrefixSum(int[] meta) {
        this.meta = meta;
    }

    private void createPrefix() {

        prefix = new int[meta.length + 1];

        if(meta == null) {
            return;
        }

        for (int metaI = 1; metaI <= meta.length; metaI++) {

            prefix[metaI] = prefix[metaI - 1] + meta[metaI - 1];

        }

    }

    public int rangeSum(int i, int j) {

        if(prefix == null) {
            createPrefix();
        }

        return prefix[j + 1] - prefix[i];

    }

    public int[] getPrefix() {

        if(prefix == null) {

            createPrefix();

        }

        return prefix;

    }
}
