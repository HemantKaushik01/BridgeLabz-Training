package com.EmployeeWage;

public class EmployeeWageApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program");

        IEmpWageBuilder empWageBuilder = new EmpWageBuilder();

        empWageBuilder.addCompanyEmpWage("TCS", 20, 20, 100);
        empWageBuilder.addCompanyEmpWage("Infosys", 25, 22, 120);

        empWageBuilder.computeEmployeeWage("TCS");
        empWageBuilder.computeEmployeeWage("Infosys");

        int totalWage = empWageBuilder.getTotalWage("TCS");
        System.out.println("Queried Total Wage for TCS: " + totalWage);
    }
}

