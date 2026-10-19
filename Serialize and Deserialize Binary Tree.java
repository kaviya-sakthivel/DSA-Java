public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
        return "null";
        String left=serialize(root.left);
        String ryt=serialize(root.right);
        return root.val+","+left+","+ryt;
    }
    int index;
    public TreeNode deserialize(String data) {
        String []values=data.split(",");
        index=0;
        return buildTree(values);    
        }
        TreeNode buildTree(String []values){
            String curr=values[index];
            index++;
            if(curr.equals("null"))
            return null;
            TreeNode node=new TreeNode(Integer.parseInt(curr));
            node.left=buildTree(values);
            node.right=buildTree(values);
            return node;
        }
}
