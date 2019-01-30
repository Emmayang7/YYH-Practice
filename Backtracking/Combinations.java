//Leetcode 77

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n<=0){
            return result;
        }
        List<Integer> cur = new ArrayList<Integer>();
        DFS(result, cur, 1, n, k);
        return result;
    }
    
    public void DFS(List<List<Integer>> result, List<Integer> cur, int s, int n, int k){
        if(cur.size() == k){//!!!! function name
            result.add(new ArrayList<>(cur)); //!!!!List can't use arraylist result[level], simply add it
            return;
        }
        if(cur.size() > k){
            return;
        }
        for(int i= s; i< n+1; i++){ //!!!! typo , than ;
            cur.add(i);
            DFS(result, cur, i+1, n, k);
            cur.remove(cur.size()-1);
        }
        
    }
    
    //Runtime )(n!) not that efficient
}


//Others solution
public static List<List<Integer>> combine(int n, int k) {
List<List<Integer>> combs = new ArrayList<List<Integer>>();
combine(combs, new ArrayList<Integer>(), 1, n, k);
return combs;
}
public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
if(k==0) {
combs.add(new ArrayList<Integer>(comb));
return;
}
for(int i=start;i<=n;i++) {
comb.add(i);
combine(combs, comb, i+1, n, k-1);
comb.remove(comb.size()-1);
}
}
