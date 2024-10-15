class Solution:
    def hlp(self, arr, ind, prev, dp):
        if ind == len(arr):
            return 0
        if dp[ind][prev] != -1:
            return dp[ind][prev]
        
        ret = 0
        
        if prev == 0 :
            ret = max(-arr[ind] + self.hlp(arr,ind,1,dp), 0 + self.hlp(arr, ind + 1, 0, dp))
        else:
            ret = max(arr[ind] + self.hlp(arr,ind+1,0,dp) , self.hlp(arr,ind+1,1,dp))
        
        
        dp[ind][prev] = ret
        
        return ret

    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[-1] * 2 for _ in range(n)]
        return self.hlp(prices, 0, 0, dp)
