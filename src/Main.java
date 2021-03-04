import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new GraphReader().reader("graphXS.paed");
        Dijkstra d = new Dijkstra(graph);
        List<Node> rand = d.findShortestPath(0,9);
        for(Node node:rand){
            System.out.print(node.getId());
            if(rand.indexOf(node) != rand.size()-1){
                System.out.print(" -> ");
            }
        }
    }
}
