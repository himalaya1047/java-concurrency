package com.chen.concurrency.chapter2;

public class TaxCalculator {

    private final double salary;

    private final double bonus;

    public TaxCalculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    protected double calcTax(){

        return 0.0d;

    }

    public double calculate(){
        return this.calcTax();
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }
}
