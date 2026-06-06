class Solution {
    public List<Integer> majorityElement(int[] arr) {
        List<Integer> list=new ArrayList<>();
        int n=arr.length;

        int cur1=0;
        int cur2=0;
        int count1=0;
        int count2=0;

        for(int i=0;i<n;i++){
            if(arr[i]==cur1){
                count1++;
            }else if(arr[i]==cur2){
                count2++;
            }else if(count1==0){
                cur1=arr[i];
                count1++;
            }else if(count2==0){
                cur2=arr[i];
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;

        for(int i=0;i<n;i++){
            if(arr[i]==cur1) count1++;
            else if(arr[i]==cur2) count2++;
        }

        int val=n/3;

        if(val<count1){
            list.add(cur1);
        }
        if(val<count2){
            list.add(cur2);
        }

        return list;

    }
}