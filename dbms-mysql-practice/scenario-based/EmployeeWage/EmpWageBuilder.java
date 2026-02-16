package com.EmployeeWage;

import java.util.ArrayList;
import java.util.Random;

public class EmpWageBuilder implements IEmpWageBuilder {

	private ArrayList<CompanyEmpWage> companyList;
	private static final int IS_ABSENT = 0;
	private static final int IS_PART_TIME = 1;
	private static final int IS_FULL_TIME = 2;

	private static final int PART_TIME_HOURS = 4;
	private static final int FULL_TIME_HOURS = 8;

	public EmpWageBuilder() {
		companyList = new ArrayList<>();
	}

	@Override
	public void addCompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {

		CompanyEmpWage company = new CompanyEmpWage(companyName, wagePerHour, maxWorkingDays, maxWorkingHours);

		companyList.add(company);
	}

	@Override
	public void computeEmployeeWage(String companyName) {

		CompanyEmpWage company = getCompanyByName(companyName);

		if (company == null) {
			System.out.println("Company not found!");
			return;
		}

		computeWage(company);
	}

	private void computeWage(CompanyEmpWage company) {

		int totalWorkingHours = 0;
		int totalWorkingDays = 0;
		int totalWage = 0;

		Random random = new Random();

		while (totalWorkingHours < company.getMaxWorkingHours() && totalWorkingDays < company.getMaxWorkingDays()) {

			totalWorkingDays++;

			int empCheck = random.nextInt(3);
			int workingHours = 0;

			switch (empCheck) {
			case IS_PART_TIME:
				workingHours = PART_TIME_HOURS;
				break;

			case IS_FULL_TIME:
				workingHours = FULL_TIME_HOURS;
				break;

			default:
				workingHours = 0;
			}

			totalWorkingHours += workingHours;

			int dailyWage = workingHours * company.getWagePerHour();
			totalWage += dailyWage;

			company.addDailyWage(dailyWage);
		}

		company.setTotalWage(totalWage);

		System.out.println(company);
	}

	@Override
	public int getTotalWage(String companyName) {

		CompanyEmpWage company = getCompanyByName(companyName);

		if (company != null) {
			return company.getTotalWage();
		}

		return 0;
	}

	private CompanyEmpWage getCompanyByName(String companyName) {

		for (CompanyEmpWage company : companyList) {
			if (company.getCompanyName().equalsIgnoreCase(companyName)) {
				return company;
			}
		}

		return null;
	}
}
