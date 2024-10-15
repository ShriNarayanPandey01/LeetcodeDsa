class Solution:
    def maxArea(self, h: List[int]) -> int:
        res=0
        j=len(h)-1
        a=0
        i=0
        while(i<j):
            if(h[i]<=h[j]):
                vol=h[i]*(j-i)
                i+=1
            elif(h[i]>=h[j]):
                vol=h[j]*(j-i)
                j-=1
            if(vol>res):
                res=vol
        return res
        