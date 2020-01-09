### 策略模式

````java
package com.chen.concurrency.chapter2;

public class TaxCalculator {

    private final double salary;

    private final double bonus;

    private CalculatorStrategy calculatorStrategy;

    public TaxCalculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    protected double calcTax(){

        return calculatorStrategy.calculate(salary,bonus);

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

    public void setCalculatorStrategy(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = calculatorStrategy;
    }
}
````

### 接口与实现

````java
package com.chen.concurrency.chapter2;

public interface CalculatorStrategy {

    double calculate(double salary, double bonus);

}
````

````java
package com.chen.concurrency.chapter2;

public class SimpleCalculatorStrategy implements CalculatorStrategy{

    private final static double SALARY_RATE = 0.1;
    private final static double BONUS_RATE = 0.15;

    @Override
    public double calculate(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }
}
````

````java
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
````