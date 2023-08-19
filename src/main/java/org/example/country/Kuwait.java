package org.example.country;


import org.example.plan.Plan;

public class Kuwait implements Country {
    @Override
    public String getCountryCurrency() {
        return "KWD";
    }

    @Override
    public Plan getCountryPlan() {
        return new Plan("1.2", "2.5", "4.8");
    }
}
