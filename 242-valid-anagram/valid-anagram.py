class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        arr=[0 for i in range(26)]

        for i in range(len(s)):
            arr[ord(s[i])-97]+=1
        
        for i in range(len(t)):
            arr[ord(t[i])-97]-=1
        
        for i in range(26):
            if arr[i]!=0:
                return False
        return True
        
