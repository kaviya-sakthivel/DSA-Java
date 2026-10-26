// LeetCode 207 - Course Schedule
// Approach: directed graph cycle detection using DFS with 3 states.
//   0 = not visited, 1 = in current DFS path, 2 = fully processed (safe)
// Reaching a node with state 1 again means there is a cycle.
// Time: O(V + E)  |  Space: O(V + E)

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            graph.get(pre).add(course);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, graph, state)) {
                return false;                    // cycle found, cannot finish
            }
        }
        return true;
    }

    boolean hasCycle(int node, List<List<Integer>> graph, int[] state) {
        if (state[node] == 1) return true;       // back to a node on the current path
        if (state[node] == 2) return false;      // already checked, no cycle

        state[node] = 1;                         // on the current path

        for (int j = 0; j < graph.get(node).size(); j++) {
            int next = graph.get(node).get(j);
            if (hasCycle(next, graph, state)) {
                return true;
            }
        }

        state[node] = 2;                         // done, safe
        return false;
    }
}
