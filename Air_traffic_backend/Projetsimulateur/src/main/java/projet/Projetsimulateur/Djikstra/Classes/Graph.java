package projet.Projetsimulateur.Djikstra.Classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Graph {
    public List<List<Edge>> adjList = null;
    public List<Edge> edges;

    // Constructor
    public Graph(List<Edge> edges, int n)
    {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // add edges to the directed graph
        for (Edge edge: edges) {
            adjList.get(edge.AeroportDepartId).add(edge);
        }
    }
}
