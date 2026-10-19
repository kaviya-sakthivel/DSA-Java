class Solution {
    int count=0;
    int res=-1;
    public int kthSmallest(TreeNode root, int k) {
        count=0;
        res=-1;
        inorder(root,k);
        return res;
    }
    void inorder(TreeNode node, int k){
        if(node==null) return ;
        if(count>=k)
        return ;
        inorder(node.left,k);
      
        count++;
        if(count==k){
        res=node.val;
        return;
    }
    inorder(node.right,k);

}
}
