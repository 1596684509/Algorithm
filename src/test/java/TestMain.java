import Algorithm.Sample;
import DataStructure.Tree.RedBlackTree;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestMain {

    private static RedBlackTree<Sample> tree;
    private static int count = 10;

    @BeforeAll
    public static void init() {

        tree = new RedBlackTree<>();

    }

    @Test
    public void test() {

        for (int i = 0; i < count; i++) {

            tree.add(new Sample(i));

        }


        tree.breadthOrder();

    }

}
