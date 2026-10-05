/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1,TreeNode root2){
		List<Integer> list1=new ArrayList<>();
		List<Integer> list2=new ArrayList<>();
		
		inOrder(list1,root1);
		inOrder(list2,root2);
		
		return mergeTwoLists(list1,list2);
	}
	public static void inOrder(List<Integer> list,TreeNode node){
		if(node==null){
			return;
		}
		inOrder(list,node.left);
		list.add(node.val);
		inOrder(list,node.right);
	}
	
	public static List<Integer> mergeTwoLists(List<Integer> list1,List<Integer> list2){
		int i=0;
		int j=0;
		List<Integer> result=new ArrayList<>();
		int m=list1.size();
		int n=list2.size();
		
		while(i<m && j<n){
			if(list1.get(i)<=list2.get(j)){
				result.add(list1.get(i));
				i++;
			}else{
				result.add(list2.get(j));
				j++;
			}
		}
		
		while(i<m){
			result.add(list1.get(i));
			i++;
		}
		while(j<n){
			result.add(list2.get(j));
			j++;
		}
		return result;
	}
}