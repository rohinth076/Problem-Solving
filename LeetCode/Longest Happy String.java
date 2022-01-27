/*
Question : https://leetcode.com/problems/longest-happy-string/
*/


class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder ans = new StringBuilder("");
        PriorityQueue<int[]> p = new PriorityQueue<>((i,j)->j[1]-i[1]);
        Map<Integer,Character> m = new HashMap<>();
        p.add(new int[]{1,a});p.add(new int[]{2,b});p.add(new int[]{3,c});
        m.put(1,'a');m.put(2,'b');m.put(3,'c');
        int prev = 0,count = 0;
        while(p.peek()[1] != 0){
            int[] temp1 = p.poll();
            if(prev == temp1[0]){
                if(count == 2){
                   int[] temp2 = p.poll(); 
                   if(temp2[1] == 0)break;
                   count = 1;
                   prev = temp2[0];
                   ans.append(m.get(prev));
                   temp2[1]--;
                   p.add(temp1);p.add(temp2);
                }else{
                count++;
                ans.append(m.get(prev));
                temp1[1]--;
                p.add(temp1);  
                }
            }else{
                count = 1;
                prev = temp1[0];
                ans.append(m.get(prev));
                temp1[1]--;
                p.add(temp1);
            }
        }
        return ans.toString();
    }
}
