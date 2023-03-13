package com.overflowing;

public class Offer26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null) return false;
        return sub(A, B);
    }
    public boolean sub(TreeNode A, TreeNode B) {
        if(B==null) return true;
        if(A==null) return false;
        if(A.val==B.val)
            return (isSubStructure(A.left, B.left) && isSubStructure(A.right, B.right))
                    || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(){}

        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(null, null, 0);
        TreeNode b = new TreeNode(null, null, 0);
        Offer26 o = new Offer26();
        System.out.println(o.isSubStructure(root, b));
    }
}
