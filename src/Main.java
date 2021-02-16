public class Main {
    public static void main(String[] args) {
        //Testing
        //Reading all the data
        GraphReader graphReader = new GraphReader();
        Graph graph = graphReader.reader("graphS.paed");

        //Generation of the new ID array
        ArrayAssignment arrayAssignment = new ArrayAssignment();
        arrayAssignment.newIdAssigner(graph.getNodes());
    }


}
