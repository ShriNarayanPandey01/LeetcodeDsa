class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[List[int]]
        :type newInterval: List[int]
        :rtype: List[List[int]]
        """
        intervals.append(newInterval)
        intervals.sort()
        merged = []
        for arr in intervals:
            if len(merged) == 0:
                merged.append(arr)
            else :
                if arr[0] <= merged[-1][1]:
                    if arr[1] < merged[-1][1]:
                        continue
                    else :
                        merged[-1][0] = min( arr[0] , merged[-1][0])
                        merged[-1][1] = max( arr[1] , merged[-1][1])
                else : merged.append(arr)
        return merged