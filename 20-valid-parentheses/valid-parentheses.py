class Solution:
    def isValid(self, s: str) -> bool:
        openbrac=set(['(','{','['])
        closebrac=set([')','}',']'])

        map={
            '{':'}',
            '(':')',
            '[':']'
        }

        stack=[]

        for x in s:
            if x in openbrac:
                stack.append(x)
            else:
                if not stack:
                    return False
                if map[stack[-1]]==x:
                    stack.pop()
                else:
                    return False
        if stack:
            return False
        return True
                