class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        char[] arr=s.toCharArray();
        int n=arr.length;
        int sum=0;
        int cur=0;
        for(int i=0;i<n;i++){
            if(i+1<n && map.get(arr[i])<map.get(arr[i+1])){
                sum-=map.get(arr[i]);
            }else{
                sum+=map.get(arr[i]);
            }
        }
        return sum;

    }
}