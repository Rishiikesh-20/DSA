# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if root==None:
            return False
        def dfs(node,sum=0):
            if node.left==None and node.right==None:
                if node.val+sum==targetSum:
                    return True
                return False
            elif node.left==None:
                return dfs(node.right,sum+node.val)
            elif node.right==None:
                return dfs(node.left,sum+node.val)
            
            temp=dfs(node.right,sum+node.val)
            if temp:
                return True
            return dfs(node.left,sum+node.val)
        return dfs(root,0)
            

