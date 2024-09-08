import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

public class graph {

    static class Edge {
        int src;
        int des;

        public Edge(int s, int d) {

            this.src = s;
            this.des = d;

        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<Edge>();

        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));

        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 3));

        // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 4));

        // graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        // graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
        // graph[5].add(new Edge(5, 6));

        // graph[6].add(new Edge(6, 5));
        
        
        //topologival sort
        //   graph[2].add(new Edge(2, 3));
        //   graph[3].add(new Edge(3, 1));
        //   graph[4].add(new Edge(4, 0));
        //   graph[4].add(new Edge(4, 1));
        //   graph[5].add(new Edge(5, 0));
        //   graph[5].add(new Edge(5, 2));


        //detection of cycle in undirected graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));

    }

    public static void BFS(ArrayList<Edge> graph[], int v) {
        Queue<Integer> q = new LinkedList<>();
        boolean vist[] = new boolean[v];
        q.add(0);
        System.out.println("BFS start from here \n");
        while (!q.isEmpty()) {
            int u = q.remove();
            if (vist[u] == false) {
                System.out.print(u);
                vist[u] = true;
                for (int i = 0; i < graph[u].size(); i++) {
                    Edge e = graph[u].get(i);
                    q.add(e.des);
                }
            }
        }
    }

    public static void BFS_disconnected(ArrayList<Edge> graph[], int start, boolean vist[]) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        System.out.println("BFS start from here");
        while (!q.isEmpty()) {
            int u = q.remove();
            if (vist[u] == false) {
                System.out.print(u);
                vist[u] = true;
                for (int i = 0; i < graph[u].size(); i++) {
                    Edge e = graph[u].get(i);
                    q.add(e.des);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge> graph[], int curr, boolean vist[]) {
        System.out.println(curr);
        vist[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);
            if (vist[e.des] == false)
                DFS(graph, e.des, vist);

        }

    }

    public static void allPath(ArrayList<Edge> graph[], boolean visit[],
            int curr, int target, String path) {
        if (curr == target) {
            System.out.println(path);
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge r = graph[curr].get(i);
            if (visit[r.des] == false) {
                visit[curr] = true;
                allPath(graph, visit, r.des, target, path + r.des);
                visit[curr] = false;

            }

        }
    }

public static boolean isCycledDirected(ArrayList<Edge> graph[], int curr, boolean visit[], boolean rec[])
{
visit[curr] = true;
rec[curr] = true;
for(int i=0; i< graph[curr].size();i++)
{
Edge e= graph[curr].get(i);
if(rec[e.des])
{
    return true;
}
else if(!visit[e.des])
{
    if(isCycledDirected(graph, e.des, visit, rec)){
        return true;
    }
}   
}
rec[curr]= false;
return false;
}

public static void topicalSortutil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> stack) {
    vis[curr] = true;
    for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        if (!vis[e.des]) {
            topicalSortutil(graph, e.des, vis, stack);

        }

    }

    stack.push(curr);
}

public static void topsort(ArrayList<Edge> graph[], int N)
{
boolean arr[]= new boolean[N];
Stack<Integer> stack= new Stack<Integer>();
for(int i=0; i<N; i++)
{
 if(!arr[i]) {
    topicalSortutil(graph, i, arr, stack);
 }  
}
while (!stack.isEmpty()) 
{

    System.out.print(stack.pop()+" -> ");
}
}



public static boolean isCycleUndirected(ArrayList<Edge> graph[], int curr, boolean vis[], int parent) {
    vis[curr] = true;
    for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        if (vis[e.des]  && e.des != parent) {
            return true;
        }
        if (!vis[e.des] ) {
            if (isCycleUndirected(graph, e.des, vis, curr)) {
                return true;
            }
        }
    }

    return false;
}


    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        System.out.println("hi");
        createGraph(graph);

        // BFS(graph, V);

        boolean vist[] = new boolean[V];
        // for (int i = 0; i < V; i++) {

        // if (vist[i] == false) {
        // BFS_disconnected(graph, i, vist);
        // }
        // }

        // System.out.println("dfs start herw");
        // DFS(graph,0, vist);

        allPath(graph, vist, 0, 5, "0");


        // topsort(graph, V);

        System.out.println(isCycleUndirected(graph, 0, new boolean[V], -1));

    }

}
