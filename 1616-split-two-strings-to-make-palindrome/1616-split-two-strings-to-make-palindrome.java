class Solution {
    public  boolean isPalindrome(String str) {
        if (str == null) return false;
        
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean checkPalindromeFormation(String a, String b) {
        boolean flag1 = true , flag2 = true ;
        int i = 0 , j = a.length()-1;
        while(i <= j &&( flag1 || flag2)){
            if( a.charAt(i) != b.charAt(j) && flag1 ){
                if( !isPalindrome( a.substring(0, i)+b.substring(i,b.length())) &&  !isPalindrome( a.substring(0, j+1)+b.substring(j+1,b.length())) )
                    flag1 = false;
                else return true;
                
            }
            if( a.charAt(j) !=  b.charAt(i) && flag2 ){
                if( !isPalindrome( b.substring(0, i)+a.substring(i,b.length())) && !isPalindrome( b.substring(0, j+1)+a.substring(j+1,b.length())))
                    flag2 = false;
                else return true;
            }
            i++;j--;
        }
        if( flag1 || flag2) return true; 
        if( isPalindrome(a) || isPalindrome(b)) return true;
        return false;
    }
}