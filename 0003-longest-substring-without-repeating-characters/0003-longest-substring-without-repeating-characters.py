class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        data={}
        arr=[]
        fin=0
        low=0
        sub=0
        if(len(s)==0):
            return 0
        if(len(s)==1):
            return 1
        for i in range(len(s)):
            sub+=1
            if(s[i] not in data):
                data[s[i]]=i
            elif(s[i] in data):
                if(sub-low-1)>fin:
                    fin=sub-low-1
                if(data[s[i]]>=low):
                    low=data[s[i]]+1
                data[s[i]]=i
       
        if(sub-low)>fin:
            fin=sub-low
                
                
        return fin
                
        
                
                
        