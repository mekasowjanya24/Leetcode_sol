class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>prev=new ArrayList<>();
        prev.add(1);
        for(int i=0;i<rowIndex;i++){
            List<Integer>cur=new ArrayList<>();
            cur.add(1);
            for(int j=0;j<prev.size()-1;j++){
                cur.add(prev.get(j)+prev.get(j+1));
            }
            cur.add(1);
            prev=cur;

        }
        return prev;
    }
}