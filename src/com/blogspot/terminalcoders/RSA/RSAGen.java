package com.blogspot.terminalcoders.RSA;
// (c) Coded By AJITH K P [ ajithkp560 ]
// http://www.terminalcoders.blogspot.com
// RSA Algorithm implementation in Java [with GUI]
import java.math.BigInteger;
import java.util.Random;
import java.util.Vector;

public class RSAGen {
    private  int p, q, n, phi, publicKey, privateKey;
    public RSAGen(){
        p = new PrimeNumberGen().getPrimeNumber();
        q = new PrimeNumberGen().getPrimeNumber();
        while(p==q)
            q = new PrimeNumberGen().getPrimeNumber();
        n = p*q;
        phi = (p-1)*(q-1);
        Vector<Integer> coPrimes = getCoPrimes(phi);
        publicKey = coPrimes.get(new Random().nextInt(coPrimes.size()));
        privateKey = eEuclid(phi, publicKey);
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }

    public int getN() {
        return n;
    }

    public int getPhi() {
        return phi;
    }

    public int getPublicKey() {
        return publicKey;
    }

    public int getPrivateKey() {
        return privateKey;
    }

    //Generate list of co-primes for select as public key
    private Vector<Integer> getCoPrimes(int n){
        Vector<Integer> coPrimeList = new Vector<>();
        BigInteger bInt1 = BigInteger.valueOf(n);
        for(int i=3;i<n;i++){
            BigInteger bInt2 = BigInteger.valueOf(i);
            BigInteger gcd = bInt1.gcd(bInt2);
            if(gcd.compareTo(BigInteger.valueOf(1))==0){
                coPrimeList.add(i);
            }
        }
        return coPrimeList;
    }

    //Generate Private Key using ext. Euclidean Algo.
    private int eEuclid(int phi, int publicKey){
        int d1=0, r1=phi, d2=1, r2=publicKey;
        while (r2>0){
            int a = r1/r2;
            int t = d1;
            d1 = d2;
            d2 = t - a * d2;
            t = r1;
            r1 = r2;
            r2 = t - a * r2;
        }
        if (r1==1){
            if(d1>=0) return d1 % phi;
            return  phi + d1 % phi;
        }
        return 0;
    }
}
