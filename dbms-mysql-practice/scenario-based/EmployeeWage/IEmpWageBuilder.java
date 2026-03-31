package com.EmployeeWage;

interface IEmpWageBuilder {
	void addCompanyEmpWage(String companyName,int wagePerHou, int maxWorkingDays,int maxWorkingHours);
	void computeEmployeeWage(String companyName);
	int getTotalWage(String companyName);
}
