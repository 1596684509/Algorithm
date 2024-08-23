package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E492 {

    @Test
    public void t() {

        constructRectangle(3);

    }
    public int[] constructRectangle(int area) {

        int next = 0;
        int initValue = area / 2;

        while(initValue != 0) {

            next = (initValue + area / initValue) / 2;

            if(Math.abs(next - initValue) <= 1) {

                break;

            }

            initValue = next;

        }

        while(area % next != 0) {

            next--;

        }

        return new int[] {area / next, next};

    }

}
