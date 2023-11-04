package projet.Projetsimulateur.Djikstra.Services;

import projet.Projetsimulateur.Djikstra.Classes.Edge;
import projet.Projetsimulateur.Djikstra.Classes.Graph;
import projet.Projetsimulateur.Exceptions.AeroportNotfound;
import projet.Projetsimulateur.classes.Aeroport;
import projet.Projetsimulateur.classes.Avion;
import projet.Projetsimulateur.enums.TypeAvion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws AeroportNotfound {

        // initialize edges as per the above diagram
        // (u, v, w) represent edge from vertex `u` to vertex `v` having weight `w`
         List<Edge> edges = new ArrayList<>();
        Edge edge3= new Edge(2, 1, 76);
        Edge edge2 = new Edge(3, 1, 21);
        Edge edge1= new Edge(3, 2, 81);
        Edge edge4= new Edge(2, 4, 181);
        Edge edge5= new Edge(1, 4, 11);
        Edge edge6 =new Edge(3,4,50);
        Edge edge7= new Edge(4, 1, 11);
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);
        edges.add(edge6);
        edges.add(edge7);

        // total number of nodes in the graph (labelled from 0 to 4)
        int n = 5;

        // construct graph
        Graph graph = new Graph(edges, n);

        // run the Dijkstra’s algorithm from every node


             System.out.println( Djikstrampl.findShortestPaths(graph, 3, 5,4));




    }
}
