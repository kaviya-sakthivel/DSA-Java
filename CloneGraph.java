import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}

class Solution {
    // key = original node, value = its clone
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;           // empty graph

        if (map.containsKey(node)) {             // already cloned
            return map.get(node);
        }

        Node clone = new Node(node.val);         // create the clone
        map.put(node, clone);                    // store BEFORE visiting neighbors

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
