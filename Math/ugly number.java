//Leetcode 263

class Solution {
    public boolean isUgly(int num) {
        if( num < 1){ ///read question postive number
            return false;
        }
        if( num > 2147483647){
            return false;
        }
        
        if(num < 7){
            return true;
        }
        for(int i=7; i <= num; i++ ){
            if( isPrime(i) == true){
                if(abs_num%i ==0){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isPrime(int num){
        if(num == 2) return true;
        if(num < 2 || num % 2 == 0) return false;
        for(int i=3; i<=Math.sqrt(num); i+=2){
            if(num % i == 0){ //can be divide by odd number
                return false;
            }
        }
        return true;
    }
    
    /*
     public boolean isUgly(int num) {
     if (num <= 0) return false;
     while (num % 2 == 0) num /= 2;
     while (num % 3 == 0) num /= 3;
     while (num % 5 == 0) num /= 5;
     return num == 1;
     ///////
     if(num==0){
     return false;
     }
     while(num!=1){
     if(num%2==0){
     num/=2;
     }
     if(num%3==0){
     num/=3;
     }
     if(num%5==0){
     num/=5;
     }
     if(num%5!=0 && num%3!=0 && num%2!=0 && num!=1){
     return false;
     }
     }
     return true;
     }*/
}
