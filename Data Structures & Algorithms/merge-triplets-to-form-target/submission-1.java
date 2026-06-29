class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] t) {
        int a=0,b=0,c=0;
        for(int tp[]:triplets)
        {
            if(tp[0]>t[0] || tp[1]>t[1] || tp[2]>t[2])
            continue;
            else
            {
                a=Math.max(a,tp[0]);
                b=Math.max(b,tp[1]);
                c=Math.max(c,tp[2]);
                if(a==t[0] && b==t[1] && c==t[2])
                return true;
            }
        }
        return false;
    }
}
