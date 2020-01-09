package com.chen.concurrency.chapter2;

public class TaxCalculatorMain {

    public static void main(String[] args) {
        TaxCalculator calculator = new TaxCalculator(10000d,2000d){
            @Override
            public double calcTax(){

            }
        };

        double tax = calculator.calcTax();

        System.out.println(tax);
    }

}
