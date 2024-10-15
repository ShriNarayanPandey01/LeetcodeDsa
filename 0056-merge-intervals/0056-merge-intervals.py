class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        merged = []
        intervals.sort()
        for arr in intervals:
            if len(merged) == 0:
                merged.append(arr)
            else:
                if arr[0] <= merged[-1][1] :
                    merged[-1][1] = max(arr[1] , merged[-1][1])
                else :
                    merged.append(arr)
        return merged