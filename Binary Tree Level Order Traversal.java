class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
        return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> curr=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode currlvl=queue.poll();
                curr.add(currlvl.val);
                if(currlvl.left!=null)
                queue.add(currlvl.left);
                if(currlvl.right!=null)
                queue.add(currlvl.right);
            }
            res.add(curr);
        }
        return res;
    }
}
