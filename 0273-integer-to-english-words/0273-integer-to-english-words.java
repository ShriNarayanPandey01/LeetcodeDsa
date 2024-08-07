class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        String ret ="";
        int cnt=0;
        while(num>0){
            int nxt = num%1000;
            String s = hlp(nxt);
            num/=1000;
            if(s.length()!=0 && cnt>0)
            ret = s +" "+THOUSANDS[cnt]+(ret.length()!=0?(" "+ret):(""));
            else if(s.length()!=0)
            ret = s +""+THOUSANDS[cnt]+""+ret;
            cnt++;
        }
        return ret;
    }
    private String hlp(int n){
        if(n<20) return LESS_THAN_20[n];
        String ret = "";
        int n1 = n%10;
        int n2 = n%100;
        int n3 = n/100;
        if(n3>0){
            ret = LESS_THAN_20[n3] +" Hundred";
            if(n2<20) ret += (n2!=0?" "+LESS_THAN_20[n2]:"");
            else {
                ret += " "+TENS[n2/10]+(n1!=0?(" "+LESS_THAN_20[n1]):"");
            }
        }
        else{
            if(n2<20) ret += LESS_THAN_20[n2];
            else {
                ret += ""+TENS[n2/10]+(n1!=0?(" "+LESS_THAN_20[n1]):"");
            }
        }


        return ret;

    }
}