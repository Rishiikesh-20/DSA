/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node,Node> map=new HashMap<>();
        return recur(node,map);
    }
    public Node recur(Node node,HashMap<Node,Node> map){
        Node newNode=new Node(node.val);
        List<Node> existing=node.neighbors;
        List<Node> newNeigh=new ArrayList<>();
        map.put(node,newNode);
        for(Node temp:existing){
            if(map.containsKey(temp)){
                newNeigh.add(map.get(temp));
            }else{
                newNeigh.add(recur(temp,map));
            }
        }
        newNode.neighbors=newNeigh;
        return newNode;
    }
}