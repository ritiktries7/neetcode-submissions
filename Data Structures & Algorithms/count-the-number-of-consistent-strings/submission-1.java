class Solution {
    public int countConsistentStrings(String a, String[] w) {
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<a.length();i++)
        set.add(a.charAt(i));
        int count=w.length;
        for(String s:w)
        {
            for(int i=0;i<s.length();i++)
            {
                if(!set.contains(s.charAt(i)))
                {
                count--;
                break;
                }
            }
    
        }
        return count;
    }
}