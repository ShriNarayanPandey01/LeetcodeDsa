class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        a,b,i = m-1,n-1 , n+m-1
        while a >= 0 and b >=0 :
            if nums1[a] > nums2[b]:
                nums1[i] = nums1[a]
                i-=1
                a-=1
            else: 
                nums1[i] = nums2[b]
                i-=1
                b-=1
        while a >= 0 :
            nums1[i] = nums1[a]
            i-=1
            a-=1
        while b >= 0 :
            nums1[i] = nums2[b]
            i-=1
            b-=1