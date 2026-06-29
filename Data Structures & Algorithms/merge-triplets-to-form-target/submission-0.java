class Solution {
    public boolean mergeTriplets(int[][] tp, int[] t) {
        int a=0,b=0,c=0;
        for(int i=0;i<tp.length;i++)
        {
            if(tp[i][0]>t[0] || tp[i][1]>t[1] || tp[i][2]>t[2])
            continue;
            else
            {
                a=Math.max(a,tp[i][0]);
                b=Math.max(b,tp[i][1]);
                c=Math.max(c,tp[i][2]);
                if(a==t[0] && b==t[1] && c==t[2])
                return true;
            }
        }
        return false;
    }
}
