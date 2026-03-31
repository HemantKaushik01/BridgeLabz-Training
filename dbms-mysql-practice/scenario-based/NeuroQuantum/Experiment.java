package com.NeuroQuantum;

import java.time.LocalDate;

public interface Experiment {

    double calculateInnovationScore(int monthsActive);

    double calculateResourceConsumption(int monthsActive);

    double getFundingAmount();

    default Experiment getHigherImpactExperiment(Experiment e1, Experiment e2) {
        if (e1.getFundingAmount() > e2.getFundingAmount()) {
            return e1;
        } else {
            return e2;
        }
    }

    static int getMonthsActive(int initiationMonth, int initiationYear) {

        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();

        int monthsActive =
                ((currentYear - initiationYear) * 12)
                + (currentMonth - initiationMonth);

        return monthsActive;
    }
}
