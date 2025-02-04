package Algorithm;

import java.util.Random;

public class InfiniteRandom {

    private int[][] animeArray = new int[5][5];

    public static void main(String[] args) {

        InfiniteRandom infiniteRandom = new InfiniteRandom();
        infiniteRandom.initArray();
        int init = 0;
        while(true) {

            int x = infiniteRandom.getRandomInd();
            while(infiniteRandom.animeArray[init][x] != 1) {

                x = infiniteRandom.getRandomInd();

            }

            infiniteRandom.print(x);
            init = x;

        }

    }

    private void initArray() {

        animeArray[0] = new int[]{0, 1, 0, 0, 0};
        animeArray[1] = new int[]{0, 0, 1, 1, 1};
        animeArray[2] = new int[]{0, 0, 0, 1, 0};
        animeArray[3] = new int[]{0, 0, 0, 0, 1};
        animeArray[4] = new int[]{1, 0, 0, 0, 0};

    }

    private void print(int i) {
        System.out.print(i);
    }

    private int getRandomInd() {

        Random random = new Random();
        return random.nextInt(animeArray.length);

    }

}
