class Solution {

   
    public long countOfSubstrings(String word, int k) {
        int cons = 0;
        HashMap<Character , Integer> vow = new HashMap<>();


        long sum = 0;
        
        int[] nextConsonant = new int[word.length()];
        int nextConsonantIndex = word.length();
        for (int i = word.length() - 1; i >= 0; i--) {
            nextConsonant[i] = nextConsonantIndex;
            char ch = word.charAt(i);
            if (!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')) {
                nextConsonantIndex = i;
            }
        }

        int a = 0 , b = 0 ;
        while(b<word.length()){
            char ch = word.charAt(b);
            boolean isVow = false;
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vow.put(ch , vow.getOrDefault(ch , 0)+1);
                isVow = true;
            }
            else cons++;  
            
            while(cons > k){
                char c = word.charAt(a);
                a++;
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    if( vow.get(c) == 1)
                        vow.remove(c);
                    else
                        vow.put(c , vow.getOrDefault(c , 0)-1);
                else cons--;
            }
          
            while( cons == k && vow.size() == 5 && a <= b ){
                sum += nextConsonant[b] - b ;
                char c = word.charAt(a++);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    if( vow.get(c) == 1)
                        vow.remove(c);
                    else
                        vow.put(c , vow.getOrDefault(c , 0)-1);
                else cons--;
            }
            
           

            b++;
        }

        // while( a <= b && vow.size() == 5 && cons == k){
        //     char c = word.charAt(a);
        //     a++;
        //     if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        //         if( vow.get(c) == 1)
        //             vow.remove(c);
        //         else
        //             vow.put(c , vow.getOrDefault(c , 0)-1);
        //     else cons--;
        //     sum++;
        // }

        
        return sum;


    }
}