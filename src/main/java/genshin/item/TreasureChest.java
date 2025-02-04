package genshin.item;

/**
 * 宝箱
 */
public class TreasureChest {

    private boolean isLock = false;

    public void unlock() {

        isLock = false;

    }

    public void lock() {

        isLock = true;

    }

    public void open() {

        if(!isLock) {
            System.out.println("宝箱开启");
        }else {
            System.out.println("宝箱被锁住");
        }

    }

}
