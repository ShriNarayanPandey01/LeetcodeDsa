class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        a , b = 0 , len(numbers) -1
        while a < b :
            if numbers[a] + numbers[b] == target: return [a+1,b+1]
            if numbers[a] + numbers[b] > target : b-=1
            else : a+=1
        return [0,0]
            