import Algorithm.LinkedDeQue;
import Algorithm.Sample;
import DataStructure.Tree.AVLTree;
import DataStructure.Tree.RedBlackTree;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Main {

    static RedBlackTree<Sample> redBlackTree;
    static AVLTree<Sample> avlTree;

    @BeforeAll
    public static void init() {

        redBlackTree = new RedBlackTree<>();
        avlTree = new AVLTree<>();

    }

    @Test
    public void avl() {

        for (int i = 0; i < 10; i++) {

            avlTree.add(new Sample(i));

        }

        avlTree.delete(new Sample(9));

        for (Sample sample : avlTree) {
            System.out.print(sample.getValue() + " ");
        }



    }

    @Test
    public void redBlackTree() {

        for (int i = 0; i < 10000000; i++) {

            redBlackTree.add(new Sample(i));

        }

        System.out.println(redBlackTree.get(new Sample(55555)).getValue());

    }

}
