package DataStructure;

import java.util.Arrays;
import java.util.logging.Logger;

public class Graph {

    //存储顶点
    private ArrayList<String> vertexList;

    //存储连接矩阵 边缘
    private int[][] edges;

    //边的个数
    private int numOfEdges;

    public static void main(String[] args) {

        int n = 5;
        Graph graph = new Graph(5);
        graph.insertVertex("A");
        graph.insertVertex("A");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");

        graph.inserEdegs(0, 1, 1);
        graph.inserEdegs(0, 2, 1);
        graph.inserEdegs(1, 4, 1);
        graph.inserEdegs(2, 4, 1);
        graph.inserEdegs(3, 4, 1);

        graph.showGraph();

    }

    public Graph(int n) {

        vertexList = new ArrayList<String>();
        edges = new int[n][n];
        numOfEdges = 0;

    }

    //插入顶点
    public void insertVertex(String vertxt) {
        vertexList.add(vertxt);
    }

    /**
     * 插入边
     * @param e1 边的下标
     * @param e2 边的下标
     * @param weight 用来当做边的权值， 0 无边，1右边
     */
    public void inserEdegs(int e1, int e2, int weight) {

        edges[e1][e2] = weight;
        edges[e2][e1] = weight;
        numOfEdges++;

    }

    //返回节点个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //返回边的个数
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 获取邻接矩阵对应下标的值
     * @param e1
     * @param e2
     * @return
     */
    public int getWeight(int e1, int e2) {

        return edges[e1][e2];

    }

    public void showGraph() {

        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }

    }
}
