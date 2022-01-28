/*
Question : https://leetcode.com/problems/design-add-and-search-words-data-structure/
*/

class Node{
    Node links[];
    boolean flag;
    Node(){
        links = new Node[26];
        flag = false;
    }
    boolean containsKey(char key){
        return (links[key-'a'] != null);
    }
    void put(char i){
        links[i-'a'] = new Node();
    }
    Node get(char i){
        return links[i-'a'];
    }
    void setEnd(){
        flag = true;
    }
    boolean isEnd(){
        return flag;
    }
}

class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node p = root;
        for(char i:word.toCharArray()){
            if(!p.containsKey(i)){
                p.put(i);
            }
            p = p.get(i);
        }
        p.setEnd();
    }
    
    public boolean search(String word) {
        return fun(root,word);
    }
    boolean fun(Node p,String word){
        int n = word.length();
        for(int i=0;i<n;i++){
            if(word.charAt(i) == '.'){
                boolean flag = false;
                for(int j=0;j<26;j++)
                    if(p.containsKey((char)(j+'a'))){
                        flag = fun(p.get((char)(j+'a')),word.substring(i+1,n));
                        if(flag)return true;
                    }
                return false;
            }
            else{
                if(!p.containsKey(word.charAt(i)))return false;
                
                p = p.get(word.charAt(i));
            }
        }
        return p.isEnd();
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
