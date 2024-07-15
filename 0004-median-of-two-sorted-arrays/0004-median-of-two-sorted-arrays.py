class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        merge=[]
        i=0
        j=0
        while(i<len(nums1) and j<len(nums2)):
            if(nums1[i]>=nums2[j]):
                merge.append(nums2[j])
                j+=1
            else:
                merge.append(nums1[i])
                i+=1
        while(i<len(nums1)):
            merge.append(nums1[i])
            i+=1
        while(j<len(nums2)):
            merge.append(nums2[j])
            j+=1
        if(len(merge)%2==0):
            return (merge[len(merge)//2]+merge[(len(merge)//2)-1])/2
        return merge[len(merge)//2]/1
            
        
                    


