package com.chen.concurrency.chapter2;

public class TaxCalculatorMain {

    public static void main(String[] args) {
        /*TaxCalculator calculator = new TaxCalculator(10000d,2000d){
            @Override
            public double calcTax(){
                return getSalary() * 0.1 + getBonus() * 0.15;
            }
        };

        double tax = calculator.calcTax();

        System.out.println(tax);*/

        TaxCalculator calculator = new TaxCalculator(10000d,2000d);
        CalculatorStrategy strategy = new SimpleCalculatorStrategy();

        calculator.setCalculatorStrategy(strategy);

        System.out.println(calculator.calculate());
    }

}
