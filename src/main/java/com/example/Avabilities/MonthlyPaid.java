package com.example.Avabilities;

public class MonthlyPaid {

    private double monthlyIncome;
    private boolean checkout;
    public MonthlyPaid(double monthlyIncome, boolean checkout) {
        this.monthlyIncome = monthlyIncome;
        this.checkout = checkout;
    }
    public double getMonthlyIncome() {
        return monthlyIncome;
    }
    public void setMonthlyIncome(double monthlyPaid) {
        this.monthlyIncome = monthlyPaid;
    }

    public boolean isCheckout() {
        return checkout;
    }
    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }

}
