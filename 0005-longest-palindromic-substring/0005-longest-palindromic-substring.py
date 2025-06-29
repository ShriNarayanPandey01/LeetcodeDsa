class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s or len(s) == 1 :
            return s+""
        max_pal = ""

        for i in range(len(s)):
            for j in range(i, len(s)):
                current_substring = s[i:j]
            
                if current_substring == current_substring[::-1] and len(current_substring) > len(max_pal):
                    max_pal = current_substring
    
        return max_pal