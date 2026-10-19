class Solution {
    int maxSum=Integer.MIN_VALUE;
    // public int maxPathSum(TreeNode root) {
    //     maxSum = Integer.MIN_VALUE;
    //     maxGain(root);
    //     return maxSum;
    // }

    int maxGain(TreeNode root) {
        if(root==null)
        return 0;
        int ld=maxGain(root.left);
        int rd=maxGain(root.right);
      
    
    int leftgain;
    if(ld>0){
        leftgain=ld;
    }
    else{
        leftgain=0;
    }
    int rightgain;
    if(rd>0){
        rightgain=rd;
    }
    else{
        rightgain=0;
    }
    int pathThroughNode= root.val+leftgain+rightgain;
    if(pathThroughNode>maxSum){
        maxSum=pathThroughNode;
        
    }
    int better;
    if(leftgain>rightgain){
        better =leftgain;
    }
    else{
        better = rightgain;
    }
    return root.val+better;
}
int maxPathSum(TreeNode root){
    maxSum=Integer.MIN_VALUE;
    maxGain(root);
    return maxSum;
}
}
