package lib;

public class Salary {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    public Salary(int monthlySalary, int otherMonthlyIncome, int annualDeductible) {
        this.monthlySalary = monthlySalary;
        this.otherMonthlyIncome = otherMonthlyIncome;
        this.annualDeductible = annualDeductible;
    }

    // Getter for monthlySalary
    public int getMonthlySalary() {
        return monthlySalary;
    }

    // Setter for monthlySalary
    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    // Getter for otherMonthlyIncome
    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    // Setter for otherMonthlyIncome
    public void setOtherMonthlyIncome(int otherMonthlyIncome) {
        this.otherMonthlyIncome = otherMonthlyIncome;
    }

    // Getter for annualDeductible
    public int getAnnualDeductible() {
        return annualDeductible;
    }

    // Setter for annualDeductible
    public void setAnnualDeductible(int annualDeductible) {
        this.annualDeductible = annualDeductible;
    }
}
