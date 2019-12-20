package lhj.leetcode;

/**988. 从叶结点开始的最小字符串
 * 给定一颗根结点为 root 的二叉树，书中的每个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。
 *
 * 找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 *
 * （小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。）
 *
 */
public class SmallestFromLeaf {


    public String smallestFromLeaf(TreeNode root) {
        dfs(root,new StringBuilder());
        return res;
    }

    String res = "";
    public void dfs(TreeNode root,StringBuilder st){
        if(root == null) {
            return;
        }
        //将数字转化成字符串
        char ch = (char) root.val;
        ch+=97;
        String s = String.valueOf(ch);
        st.insert(0,s);
        dfs(root.left,st);
        dfs(root.right,st);
        if(root.left==null && root.right==null){
            String tmp = st.toString();
            if(this.res.equals("")){
                this.res = tmp;
            }
            if(tmp.compareTo(this.res)<0){
                this.res = tmp;
            }
        }
        st.deleteCharAt(0);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
