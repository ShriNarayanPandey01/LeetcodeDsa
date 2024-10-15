# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        dict = {}
        temp = head
        while(temp != None):
            if temp in dict : return True
            dict[temp] =1
            temp = temp.next
        return False

        