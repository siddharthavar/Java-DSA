package Graph;

import java.util.*;

public class dijkstra {

    static class Edge{
        int src, dest, weight;
        public  Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
        }
    
        public static void  buildgraph(ArrayList<Edge> graph[]){
            for(int i=0; i< graph.length;i++){
                graph[i] = new ArrayList<>();
            }

            graph[0].add(new Edge(0,1,2));
            graph[0].add(new Edge(0,2,4));

            graph[1].add(new Edge(1,3,7));
            graph[1].add(new Edge(1,2,1));

            graph[2].add(new Edge(2,4,3));

            graph[3].add(new Edge(3,5,1));

            graph[4].add(new Edge(4,3,2));
            graph[4].add(new Edge(4,5,5));

        }

        static class Pair implements Comparable<Pair>{
        int node, dist;
         Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pair p2)
        {return this.dist -p2.dist ;}

    }


    public static void Dijkstra(ArrayList<Edge> graph[], int src, int v)
    {
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        pq.add(new Pair(src,0));

        int dict[]= new int[v];
        Arrays.fill(dict, Integer.MAX_VALUE);
        dict[src]=0;

        boolean visit[]= new boolean[v];
        while(!pq.isEmpty()){
            Pair curr= pq.remove();
            if(visit[curr.node] == false){
                visit[curr.node]=true;
                for(Edge e: graph[curr.node]){
                    int u= e.src;
                    int v_dest=e.dest;
                    if(dict[u]+ e.weight < dict[v_dest]){
                        dict[v_dest]= dict[u]+ e.weight;
                        pq.add(new Pair(v_dest,dict[v_dest]));
                    }
                

            }

        }}

        for (int  b : dict) 
        { System.out.println(b);
            
        }

    }


    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        buildgraph(graph);

        Dijkstra(graph,  0, v);
        
    }
    
}
