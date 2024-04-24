package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


public class Employee {
    
public enum Gender {
    MALE, FEMALE
}
    private String employeeId;
    private PersonalInfo personalInfo;
    private Gender gender;
    private int yearJoined;
    private int monthJoined;
    private int dayJoined;
    private int monthWorkingInYear;

    private boolean isForeigner;

    private Salary salary;

    private String spouseName;
    private String spouseIdNumber;

    private List<String> childNames;
    private List<String> childIdNumbers;

    public Employee(String employeeId, PersonalInfo personalInfo, int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, Gender gender) {
        this.employeeId = employeeId;
        this.personalInfo = personalInfo;
        this.yearJoined = yearJoined;
        this.monthJoined = monthJoined;
        this.dayJoined = dayJoined;
        this.isForeigner = isForeigner;
        this.gender = gender;

        childNames = new LinkedList<String>();
        childIdNumbers = new LinkedList<String>();
    }

    // Getter and setter for salary
    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    // Method to set monthly salary based on grade and foreigner status
    public void setMonthlySalary(int grade) {
        int baseSalary;
        switch (grade) {
            case 1:
                baseSalary = 3000000;
                break;
            case 2:
                baseSalary = 5000000;
                break;
            case 3:
                baseSalary = 7000000;
                break;
            default:
                throw new IllegalArgumentException("Invalid grade: " + grade);
        }
        int adjustedSalary = isForeigner ? (int) (baseSalary * 1.5) : baseSalary;
        salary.setMonthlySalary(adjustedSalary);
    }

    // Setter for annual deductible
    public void setAnnualDeductible(int deductible) {
        salary.setAnnualDeductible(deductible);
    }

    // Setter for additional income
    public void setAdditionalIncome(int income) {
        salary.setOtherMonthlyIncome(income);
    }

    // Setter for spouse
    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    // Method to add child
    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    // Method to calculate annual income tax
    public int getAnnualIncomeTax() {
        LocalDate date = LocalDate.now();
        if (date.getYear() == yearJoined) {
            monthWorkingInYear = date.getMonthValue() - monthJoined;
        } else {
            monthWorkingInYear = 12;
        }
        return TaxFunction.calculateTax(salary.getMonthlySalary(), salary.getOtherMonthlyIncome(), monthWorkingInYear, salary.getAnnualDeductible(), spouseIdNumber.equals(""), childIdNumbers.size());
    }
}
