package com.NeuroQuantum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Experiment> list = new ArrayList<>();
        boolean flag = true;
        while (flag) {

            System.out.println("\n1: Add Experiment");
            System.out.println("2: Display Experiment Summary");
            System.out.println("3: Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:

                    System.out.print("Enter number of experiments: ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < n; i++) {

                        System.out.println("\nEnter details for Experiment " + (i + 1));

                        System.out.print("Experiment ID: ");
                        int experimentId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Experiment Title: ");
                        String experimentTitle = sc.nextLine();

                        System.out.print("Lead Researcher: ");
                        String leadResearcher = sc.nextLine();

                        System.out.print("Funding Amount: ");
                        double fundingAmount = sc.nextDouble();

                        sc.nextLine();
                        System.out.print("Complexity Level (QubitOpt / Entanglement / Cryptography): ");
                        String complexityLevel = sc.nextLine();

                        System.out.print("Initiation Month (1-12): ");
                        int initiationMonth = sc.nextInt();

                        System.out.print("Initiation Year: ");
                        int initiationYear = sc.nextInt();
                        sc.nextLine();

                        Experiment exp = new ExperimentInfo(
                                experimentId,
                                experimentTitle,
                                leadResearcher,
                                fundingAmount,
                                complexityLevel,
                                initiationMonth,
                                initiationYear
                        );

                        list.add(exp);
                    }

                    break;
                case 2:

                    if (list.isEmpty()) {
                        System.out.println("No experiments available.");
                        break;
                    }

                    Experiment highestImpact = list.get(0);

                    for (Experiment exp : list) {

                        int monthsActive = Experiment.getMonthsActive(
                                ((ExperimentInfo) exp).getInitiationMonth(),
                                ((ExperimentInfo) exp).getInitiationYear()
                        );

                        double innovationScore =
                                exp.calculateInnovationScore(monthsActive);

                        double resourceConsumption =
                                exp.calculateResourceConsumption(monthsActive);

                        System.out.println("\n-----------------------------");
                        System.out.println("Title: " +
                                ((ExperimentInfo) exp).getExperimentTitle());
                        System.out.println("Months Active: " + monthsActive);
                        System.out.println("Innovation Score: " + innovationScore);
                        System.out.println("Resource Consumption: " + resourceConsumption);

                        highestImpact =
                                exp.getHigherImpactExperiment(highestImpact, exp);
                    }

                    System.out.println("\n=================================");
                    System.out.println("Higher Impact Experiment (Based on Funding):");
                    System.out.println(
                            ((ExperimentInfo) highestImpact).getExperimentTitle()
                    );
                    System.out.println("Funding Amount: " +
                            highestImpact.getFundingAmount());
                    System.out.println("=================================");

                    break;

                case 3:
                    System.out.println("Exiting...");
            
                    flag= false;
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
