class Solution:
    def reverse ( self ,a , b , lst ):
        while a <= b:
            temp = lst[a]
            lst[a] = lst[b]
            lst[b] = temp 
            a+=1
            b-=1
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k % len(nums)
        self.reverse( 0 , len(nums)-1 ,nums )
        self.reverse(0 , k-1 , nums)
        self.reverse( k , len(nums)-1 , nums )
        