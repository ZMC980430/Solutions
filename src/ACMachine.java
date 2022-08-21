import java.util.*;

public class ACMachine {
    private int length;
    private final TreeNode root = new TreeNode('0');
    public ACMachine(String[] words){
        for(String w: words){
            TreeNode cur = root;
            for(char c: w.toCharArray()) {
                cur.addChild(c);
                cur = cur.getChild(c);
            }
        }
    }

    public void buildFail(){
        this.root.fail = this.root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            for(TreeNode child: cur.children) {
                if(child != null) {
                    if(cur.fail.getChild(child.val)!=null) {
                        child.fail = cur.fail.getChild(child.val);
                    }
                    child.fail = root;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] s = {"ample", "bsd", "apple", "apps", "ss"};
//        ACMachine m = new ACMachine(s);
        List<Integer>[] collection = new ArrayList[10];
    }
};
class TreeNode {
    public List<TreeNode> children;
    public TreeNode fail;
    public char val;
    public TreeNode(char val) {
        this.children = new ArrayList<TreeNode>();
        this.val = val;
        for(int i=0; i<26; i++){
            this.children.add(null);
        }
    }
    public void addChild(char val){
        int index = val - 'a';
        if(this.children.get(index) == null) {
            this.children.set(index, new TreeNode(val));
        }
    }
    public TreeNode getChild(char val){
        return this.children.get(val-'a');
    }
};