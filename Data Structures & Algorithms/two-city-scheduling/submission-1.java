class Solution {

    public int twoCitySchedCost(int[][] c) {
        // Arrays.sort(c,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> a=new PriorityQueue<>((i1, i2) -> (c[i2][0] - c[i2][1]) - (c[i1][0] - c[i1][1]));
        PriorityQueue<Integer> b=new PriorityQueue<>((i1, i2) -> (c[i2][1] - c[i2][0]) - (c[i1][1] - c[i1][0]));
        int m=c.length;
        int n=m/2,costa=0,costb=0;
        // for(int i=0;i<m;i++)
        // {
        //     System.out.println(c[i][0]+" "+c[i][1]);
        // }
        for(int i=0;i<m;i++)
        {
            if(c[i][0]<=c[i][1])
            {
                if(a.size()==n)
                {
                    if(c[a.peek()][0]>c[i][0])
                    {
                        int p=a.poll();
                        a.add(i);
                        b.add(p);
                        costa+=c[i][0]-c[p][0];
                        costb+=c[p][1];
                    }
                    else
                    {
                    b.add(i);
                    costb+=c[i][1];

                    }
                }
                else
                {
                    a.add(i);
                    costa+=c[i][0];
                }
            }
            else
            {
                if(b.size()==n)
                {
                    if((c[b.peek()][1] - c[b.peek()][0]) > (c[i][1] - c[i][0]))
                    {
                        int p=b.poll();
                        b.add(i);
                        a.add(p);
                        costb+=c[i][1]-c[p][1];
                        costa+=c[p][0];
                    }
                    else
                    {

                    a.add(i);
                    costa+=c[i][0];
                    }
                }
                else
                {
                    b.add(i);
                    costb+=c[i][1];
                }

            }

        }
        return costa+costb;
    }
}