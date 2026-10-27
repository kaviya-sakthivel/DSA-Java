import java.util.*;
class Solution{
  public int countComponents(int n, int[][] edges){
    List<List<Integer>> graph=new ArrayList<>();
    for(int i=0;i<n;i++){
      graph.add(new ArrayList<>());
    }
    for(int i=0;i<edges.length;i++){
      int u=edges[i][0];
      int v=edges[i][1];
      graph.get(u).get(v);
      graph.get(v).get(u);
    }
    boolean[] visited=new boolean[n];
    int cnt=0;
    for(int i=0;i<n;i++){
      if(!visited[i]){
        cnt++;
        dfs(i,graph,visited);
      }
    }
    return cnt;
  }
  void dfs(int i,List<List<Integer>> graph,boolean[] visited){
    visited[node]=true;
    for(int j=0;j<graph.get(node).size();j++){
      int next=graph.get(node).get(j);
      if(!visited[next]){
      dfs(next,graph,visited);
    }
  }
  }
}
  
