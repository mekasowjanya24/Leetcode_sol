class Solution {
    public int minimumOR(int[][] grid) {
        int m=grid.length;
        int result=0;
        for(int bit=29;bit>=0;bit--){
            int candidate=result|(1<<bit);
            boolean canAvoid=true;
            for(int[]row:grid){
                boolean rowHasOption=false;
                for(int val:row){
                    if((val &(1<<bit))==0){
                        rowHasOption=true;
                            break;
                    }
                }
                if(!rowHasOption){
                    canAvoid=false;
                    break;
                }
                    }
            if(!canAvoid){
                result|=(1<<bit);
            }
                }
        return result;
            }
        }
    