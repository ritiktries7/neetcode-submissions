/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
    // class Pair
    // {
    //     Node node;
    //     int he;
    //     public Pair(Node node,int he)
    //     { 
    //         this.node=node;
    //         this.he=he;
    //     }
    // }
    // Node h[];
    // Stack<Pair> st=new Stack<>();
    // public int height(Node root)
    // {
    //     if(root==null)
    //     return 0;
    //     return 1+height(root.left);
    // }
    // public void path(Node root,int he)
    // {
    //     if(root==null)
    //     return;
    //     path(root.left,he+1);
    //     path(root.right,he+1);
    //     st.push(new Pair(root,he));
    // }
        // int n=height(root);
        // h=new Node[n];
        // Arrays.fill(h,null);
        // path(root,0);
        // while(!st.isEmpty())
        // {
        //     Pair p=st.pop();
        //     // System.out.println(p.node.val+" "+p.he);
        //     Node cur=p.node;
        //     int he=p.he;
        //     cur.next=h[he];
        //     h[he]=cur;
        // }
        // return root;
    // public void makemap(Node root,int he,HashMap<Integer,ArrayList<Node>> map)
    // {
    //     if(root==null)
    //     return;
    //     map.putIfAbsent(he,new ArrayList<>());
    //     map.get(he).add(root);
    //     makemap(root.left,he+1,map);
    //     makemap(root.right,he+1,map);
    // }
    class Pair
    {
        Node node;
        int he;
        public Pair(Node node,int he)
        { 
            this.node=node;
            this.he=he;
        }
    }
    public Node connect(Node root) {        
        HashMap<Integer,ArrayList<Node>> map=new HashMap<>();
        // makemap(root,0,map);
        if(root==null)
        return root;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            Node cur=p.node;
            int he=p.he;
            map.putIfAbsent(he,new ArrayList<>());
            map.get(he).add(cur);
            if(cur.left!=null)
            q.add(new Pair(cur.left,he+1));
            if(cur.right!=null)
            q.add(new Pair(cur.right,he+1));
        }
        for(int he:map.keySet())
        {
            ArrayList<Node> list=map.get(he);
            list.add(null);
            for(int i=list.size()-2;i>=0;i--)
            {
                list.get(i).next=list.get(i+1);
            }
        }
        return root;
    }
}