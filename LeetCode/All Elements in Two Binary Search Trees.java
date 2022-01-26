/*
Question : https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
*/
class Solution {
    void dfs(TreeNode r,List<Integer> l){
        if(r == null)return;
        
        dfs(r.left,l);
        l.add(r.val);
        dfs(r.right,l);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l = new ArrayList<>();
        dfs(root1,l);
        dfs(root2,l);
        Collections.sort(l);
        return l;
    }
}
