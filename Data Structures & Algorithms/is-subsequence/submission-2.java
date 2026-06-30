class Solution {
    int dp[][];
    public boolean path(String s, String t,int i,int j) {
        if(i < 0)
        return true;
        if(j < 0)
        return false;
        if(dp[i][j]!=-1)
        return dp[i][j]==1;
        boolean check=false;
        if(s.charAt(i)==t.charAt(j))
        check=path(s,t,i-1,j-1);
        else
        check=path(s,t,i,j-1);
        dp[i][j]=check==true?1:0;
        return check;

        
    }
    public boolean isSubsequence(String s, String t) {
        // int i=0,j=0;
        // while(i<s.length() && j<t.length())
        // {
        //     if(s.charAt(i)==t.charAt(j))
        //     {
        //         i++;
        //         j++;
        //     }
        //     else
        //     j++;
        // }
        // if(i==s.length())
        // return true;
        // return false;
        dp=new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();i++)
        Arrays.fill(dp[i],-1);
        return path(s,t,s.length()-1,t.length()-1);
    }
}