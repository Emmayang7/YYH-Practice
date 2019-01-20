//Leetcode 779

class Solution {
    public int kthGrammar(int N, int K) {
        /*String strN = findN(N);
         if(K > strN.length()){
         return -1;
         }
         return Character.getNumericValue(strN.charAt(K-1));                      //Character.getNumericValue(c);  */
        if (N == 1) return 0;
        if (N == 2) return K == 1 ? 0 : 1;
        int full = (int) Math.pow(2, N - 1);
        int mid = full / 2;
        if (K <= mid) {  // the index is less than the half of the total number in this level
            return kthGrammar(N - 1, K);  // the result would be the same index in the previous level
        } else {   // the index is over the half of the total number
            if (N % 2 == 0) return kthGrammar(N - 1, full - K + 1) == 1 ? 0 : 1; // level number is even, get flipped result
            else return kthGrammar(N - 1, full - K + 1) == 1 ? 1 : 0; // // level number is odd, get exact same result
        }
        
        // TC: O(N) each recursion we send N one level down so it only takes N times to get the final result
        // AS: O(N) it goes up to N call stacks
    }
    
    //Memory Limit Exceeded
    public String findN(int N){
        if (N==1){
            return "0";
        }
        String temp = findN(N-1); //!!!! don't copy paste, check the correct function name
        StringBuilder Result = new StringBuilder();
        for(int i=0; i< temp.length(); i++){
            if(temp.charAt(i) == '0'){ //!!!! type string char
                Result.append("01");
            }
            if(temp.charAt(i) == '1'){
                Result.append("10");
            }
        }
        return Result.toString();
    }
}
