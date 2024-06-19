package Algorithm;

import Algo.BinarySrch.SrchTreeSampleAble;

public class Sample implements SrchTreeSampleAble {

    private int value;

    public Sample(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Sample) {

            return this.value == ((Sample)obj).value;

        }

        return false;

    }
}
