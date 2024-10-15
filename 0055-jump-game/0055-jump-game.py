class Solution:
    def canJump(self, nums: List[int]) -> bool:
        N = len(nums)
        dp = [False] * N
        dp[-1] = True
        
        for i in range(N - 1, -1, -1):
            if nums[i] == 0:
                continue
            
            lowerbound = i + 1
            upperbound = min(i + nums[i], N - 1) + 1
            
            for j in range(lowerbound, upperbound):
                if dp[j]:
                    dp[i] = True
                    break
            
        return dp[0]