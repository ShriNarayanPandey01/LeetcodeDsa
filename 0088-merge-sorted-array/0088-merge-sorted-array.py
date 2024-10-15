class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        a=0
        n=len(nums1)-1
        print(n)
        while(n>=0):
            if(a==(len(nums2))):
                    break
            if(nums1[n]==0):
                nums1[n]=nums2[a]
                a+=1
                n-=1
                continue
                if(a==(len(nums2)-1)):
                    break
            n-=1
        nums1.sort()
        
                
            
            
        