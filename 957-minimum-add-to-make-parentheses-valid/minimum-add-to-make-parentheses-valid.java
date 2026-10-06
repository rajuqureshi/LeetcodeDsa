class Solution {
    public int minAddToMakeValid(String s) {
        if(s.length()==0) return 0;
        int open = 0;
        int ans = 0;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') open++;
            else{
                if(open>0) open--;
                else ans++;
            }
        }
        return ans+open;
    }
}