import Algorithm.LinkedDeQue;
import Algorithm.Sample;
import DataStructure.Tree.AVLTree;
import DataStructure.Tree.RedBlackTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class Main {

    private static AVLTree<Sample> avlTree;
    private static int count = 10;
    private static int objInt = 55555;


    @BeforeAll
    public static void init() {
        avlTree = new AVLTree<>();
        for (int i = 0; i < count; i++) {
            avlTree.add(new Sample(i));
        }
    }


    @Test
    public void test() {

        System.out.println("广度遍历-——-——-——-——-——");
        avlTree.breadthOrder();
        System.out.println();

        System.out.println("前序遍历-——-——-——-——-——");
        avlTree.preOrder();
        System.out.println();

        System.out.println("中序遍历-——-——-——-——-——");
        avlTree.minOrder();
        System.out.println();

        System.out.println("后序遍历-——-——-——-——-——");
        avlTree.afterOrder();
        System.out.println();

    }

}
