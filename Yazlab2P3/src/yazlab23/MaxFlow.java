/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlab23;

/**
 *
 * @author K4RK1N
 */
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.LinkedList;

public class MaxFlow {

    /**
     * @return the oooo
     */
    private int k = 0;
    private String oooo = "";
    private String sonoooo = "";

    /**
     * @param aV the V to set
     */
    public static void setV(int aV) {
        V = aV;
    }
    // Java program for implementation of Ford Fulkerson algorithm 

    public static int V; //Number of vertices in graph 

    /* Returns true if there is a path from source 's' to sink 
	't' in residual graph. Also fills parent[] to store the 
	path */
    boolean bfs(int rGraph[][], int s, int t, int parent[]) {
        // Create a visited array and mark all vertices as not 
        // visited 
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; ++i) {
            visited[i] = false;
        }

        // Create a queue, enqueue source vertex and mark 
        // source vertex as visited 
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        // Standard BFS Loop 
        while (queue.size() != 0) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (visited[v] == false && rGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        // If we reached sink in BFS starting from source, then 
        // return true, else false 
        return (visited[t] == true);
    }

    // Returns tne maximum flow from s to t in the given graph 
    int fordFulkerson(int graph[][], int s, int t) {
        int u, v;

        // Create a residual graph and fill the residual graph 
        // with given capacities in the original graph as 
        // residual capacities in residual graph 
        // Residual graph where rGraph[i][j] indicates 
        // residual capacity of edge from i to j (if there 
        // is an edge. If rGraph[i][j] is 0, then there is 
        // not) 
        int rGraph[][] = new int[V][V];

        for (u = 0; u < V; u++) {
            for (v = 0; v < V; v++) {
                rGraph[u][v] = graph[u][v];
            }
        }

        // This array is filled by BFS and to store path 
        int parent[] = new int[V];

        int max_flow = 0; // There is no flow initially 

        // Augment the flow while tere is path from source 
        // to sink 
        ArrayList<String> ular = new ArrayList<String>();
        while (bfs(rGraph, s, t, parent)) {
            // Find minimum residual capacity of the edhes 
            // along the path filled by BFS. Or we can say 
            // find the maximum flow through the path found. 
            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }

            // update residual capacities of the edges and 
            // reverse edges along the path 
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
                ular.add(u + "");

            }

            // Add path flow to overall flow 
            k++;
            max_flow += path_flow;

        }
        //Arrayliste bitiş düğümünü ekleme

        ular.add(0, t + "");
        for (int i = 0; i < ular.size(); i++) {
            if (ular.get(i).equals(s + "")) {
                ular.add(i + 1, t + "");
            }
        }
        ular.remove(ular.size() - 1);

        //Arraylisti diziye çevirme
        String[] oooo = new String[ular.size()];
        for (int i = 0; i < ular.size(); i++) {

            oooo[i] = ular.get(ular.size() - i - 1);

        }

        for (int i = 0; i < oooo.length; i++) {
            sonoooo = sonoooo.concat(oooo[i]);

        }

        // Return the overall flow 
        return max_flow;
    }

    // Driver program to test above functions 
    /*public static void main(String[] args) throws java.lang.Exception {
        // Let us create a graph shown in the above example 
        
    }*/
    /**
     * @return the k
     */
    public int getK() {
        return k;
    }

    /**
     * @return the sonoooo
     */
    public String getSonoooo() {
        return sonoooo;
    }

}
