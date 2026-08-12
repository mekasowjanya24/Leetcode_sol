class Solution {
    public double minPrice(int[] prices, int[] discounts) {
       prices= reverse(prices);
       discounts= reverse(discounts);
        int n=prices.length;
        int m=discounts.length;
        double sum=0;
        int i=0;
     for(;i<n && i<m;i++){
         sum=sum+prices[i]*(100-discounts[i])/100.0;
     }
        
            for(;i<n;i++){
                sum=sum+prices[i];
            }
    return sum;
    }
    private int [] reverse(int [] arr){
        Arrays.sort(arr);
        for(int i=0,j=arr.length-1;i<j;i++,j--){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        return arr;
    }
}