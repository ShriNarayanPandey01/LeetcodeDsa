class Solution {
    
    public int trap(int[] height){
    int a=0,b=height.length-1,maxl=0,maxr=0,water=0;
    while(a<b){
        if(height[a]<height[b]){
            if(height[a]>=maxl)
            maxl=height[a++];
            else
            water+=(maxl-height[a++]);
        }
        else{
            if(height[b]>=maxr)
            maxr=height[b--];
            else
            water+=(maxr-height[b--]);
        }
    }return water;
        }
       }
        
    
    
