class Solution {
    public int minimumOR(int[][] grid) {
       Set<Integer>possible=new HashSet<>();
        possible.add(0);
        for(int [] row:grid){
            Set<Integer> next=new HashSet<>();
            for(int prev:possible){
                for(int val:row){
                    next.add(prev|val);
                }
            }
            possible=next;
        }
                
             int min=Integer.MAX_VALUE;
                for(int v:possible){
                    min=Math.min(min,v);
                
                }
        return min;
            }
        }
    