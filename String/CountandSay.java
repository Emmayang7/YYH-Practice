//Leetcode 38

class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        String temp = countAndSay(n-1);
        temp = temp + "0";
        int count =1;
        for(int i=1; i< temp.length(); i++){ //!!!!length method
            if(temp.charAt(i) == temp.charAt(i-1)){ //!!!!do CharAt
                count++;
            }else{
                sb.append(count);
                sb.append(temp.charAt(i-1));
                count = 1; //!!!!here make count as 1 until meet the different number
            }
        }
        return sb.toString(); //!!!! toString method help StringBuilder to String
    }
}

