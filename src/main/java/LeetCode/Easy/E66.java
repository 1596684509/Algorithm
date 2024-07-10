package LeetCode.Easy;

public class E66 {

    public static void main(String[] args) {

        int[] ins = new int[]{9};

        for (int in : plusOne(ins)) {

            System.out.print(in);

        }


    }

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0;) {

            if(digits[i] == 9) {

                if(i == 0) {

                    digits = new int[digits.length + 1];
                    digits[0] = 1;
                    for (int i1 = 1; i1 < digits.length; i1++) {

                        digits[i1] = 0;

                    }

                    return digits;

                }

                digits[i] = 0;
                i--;

            }else {

                digits[i] = digits[i] + 1;
                break;

            }

        }

        return digits;

    }
}
