class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> ans = new HashSet<>();
        for(int i=0;i<digits.length;i++){
            if(digits[i]==0) continue;
            for(int j=0;j<digits.length;j++){
                if(j==i) continue;
                for(int u=0;u<digits.length;u++){
                    if(u==i || u==j) continue;
                    if(digits[u]%2!=0) continue;
                    int num = digits[i]*100+digits[j]*10+digits[u];
                    ans.add(num);
                }
            }
        }
        return ans.size();
    }
}