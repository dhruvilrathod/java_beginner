package oops;

import java.math.BigDecimal;

public class SimpleInstrestCalculator {

    private final BigDecimal amount;
    private final BigDecimal interest;

    SimpleInstrestCalculator(String amount, String interest) {
        this.amount = new BigDecimal(amount);
        this.interest = new BigDecimal(interest).divide(new BigDecimal(100));
    }

    public static void main(String[] args) {
        SimpleInstrestCalculator calculator = new SimpleInstrestCalculator("4500.00", "7.5");
        BigDecimal total = calculator.calculateTotalValue(5);
        System.out.println(total);
    }

    public BigDecimal calculateTotalValue(int years) {
        return this.amount.add(this.amount.multiply(this.interest).multiply(new BigDecimal(years)));
    }
}
