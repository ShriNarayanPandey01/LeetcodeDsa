class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for(int i=0;i<word.length();i++)
        freq[word.charAt(i)-'a']++;

        Arrays.sort(freq);
        int count=0,cnt=1;
        for(int i=25;i>0;i--){
            int itr = 7;
            int sum = 0;
            while(i-itr>=0 && itr>=0){
                sum+=freq[i-itr];
                itr--;
            }
            count+=(sum*(cnt++));
            i=i-7;
        }
        return count;
    }
}