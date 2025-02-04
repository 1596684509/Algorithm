package LeetCode.Easy;

import org.junit.jupiter.api.Test;

public class E717 {

    @Test
    public void t() {

        isOneBitCharacter(new int[]{1, 2, 3});

    }

    public boolean isOneBitCharacter(int[] bits) {

        if(bits.length == 1 || bits[bits.length - 2] == 0) {
            return true;
        }else {

            for (int bisI = 0; bisI < bits.length; bisI++) {

                if(bits[bisI] == 1) {

                    bisI++;

                    if(bits.length - bisI + 1 == 2) {

                        return false;

                    }else if(bits.length - (bisI + 1) == 1) {

                        return true;

                    }

                }

            }

        }

        return false;

    }

    public boolean isOneBitCharacterOther(int[] bits) {

        int index = bits.length - 2;
        int count = 0;

        for (int i = index; i >= 0; i--) {

            if(bits[i] == 1) {
                count++;
            }else {
                break;
            }

        }

        return (count & 1) == 0;

    }

}
