package com.blogspot.terminalcoders.RSA;
// (c) Coded By AJITH K P [ ajithkp560 ]
// http://www.terminalcoders.blogspot.com
// RSA Algorithm implementation in Java [with GUI]
import java.util.Random;

public class PrimeNumberGen {
    private int n;
    public int getPrimeNumber(){
        this.n = (int)(new Random().nextDouble()*100)+250;
        int l = 0;
        //n (log n + log log n - 1 + (log log (n) - 2)/log n - ((log log (n))2 - 6 log log (n) + 11)/(2 log2 n))
        //l = (long) ((this.n)*(Math.log(this.n) + (Math.log(Math.log(this.n)) -1) + ((Math.log(Math.log(this.n))-2)/(Math.log(this.n))) - ((Math.pow(Math.log(Math.log(this.n)),2) - (6 * (Math.log(Math.log(this.n))))+11)/(2 * (Math.pow( Math.log(this.n) ,2)))) ));
        l = (int) ((this.n)*(Math.log(this.n) + (Math.log(Math.log(this.n)) -1) + ((Math.log(Math.log(this.n))-2)/(Math.log(this.n))) - ((Math.log(Math.log(this.n)) -21.0/10.0)/Math.log(this.n)) ));
        for(int i=l;;i++){
            if(isPrime(i)){
                return i;
            }
        }
    }
    private boolean isPrime(int n){
        if(n%2 == 0 || n%3 == 0) return false;
        for(int i=5; i*i<=n; i+=6){
            if(n%i == 0 || n%(i+2)==0) return false;
        }
        return true;
    }
}
