class Solution {
    public void generate(int n, List<String> list,String str,int open,int close){
        if(close==n){
            list.add(str);
        }
        if(open<n){
            generate(n,list,str+"(",open+1,close);
        }
        if(close<open){
            generate(n,list,str+")",open,close+1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
            generate(n,list,"",0,0);
            return list;
    }
}