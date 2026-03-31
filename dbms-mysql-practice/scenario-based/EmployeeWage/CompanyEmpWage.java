package com.EmployeeWage;

import java.util.ArrayList;

public class CompanyEmpWage {

	private String companyName;
	private int wagePerHour;
	private int maxWorkingDays;
	private int maxWorkingHours;
	private int totalWage;
	private ArrayList<Integer> dailyWageList;

	public CompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
		this.companyName = companyName;
		this.wagePerHour = wagePerHour;
		this.maxWorkingDays = maxWorkingDays;
		this.maxWorkingHours = maxWorkingHours;
		this.dailyWageList = new ArrayList<>();
	}

	public String getCompanyName() {
		return companyName;
	}

	public int getWagePerHour() {
		return wagePerHour;
	}

	public int getMaxWorkingDays() {
		return maxWorkingDays;
	}

	public int getMaxWorkingHours() {
		return maxWorkingHours;
	}

	public void setTotalWage(int totalWage) {
		this.totalWage = totalWage;
	}

	public int getTotalWage() {
		return totalWage;
	}

	public void addDailyWage(int dailyWage) {
		dailyWageList.add(dailyWage);
	}

	public ArrayList<Integer> getDailyWageList() {
		return dailyWageList;
	}

	@Override
	public String toString() {
		return "Company: " + companyName + ", Total Wage: " + totalWage + ", Daily Wages: " + dailyWageList;
	}
}
