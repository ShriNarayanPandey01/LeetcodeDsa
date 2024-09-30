class Solution {
    public int[] validSequence(String word1, String word2) {
        int[] seq = new int[word2.length()];
        Arrays.fill(seq , -1);
        if(hlp(seq , word1 , word2 ,0,0,1))
        return seq;
        return new int[]{};
    }
    public boolean hlp(int[] seq , String word1 , String word2 , int s1 ,int s2 , int chance){
        if( s1 == word1.length() && s2 != word2.length() ) return false;
        if(s2 == word2.length() ) return true;

        boolean valid = false;
        if( word1.charAt(s1) == word2.charAt(s2) )
        {   
            seq[s2] = s1;
            // System.out.print(word1.charAt(s1)+" ");
            valid = hlp(seq , word1 ,word2 ,s1+1 , s2+1 , chance);
        }
        else  if (chance == 1){
            // System.out.print(word1.charAt(s1)+" ");
            seq[s2] = s1;
            valid = hlp(seq , word1 ,word2 ,s1+1 ,s2+1 , 0);
        }
        valid = valid || hlp(seq , word1 ,word2 ,s1+1 ,s2 ,chance);
        if (!valid) seq[s2] = -1; 
        return valid;
    }
}