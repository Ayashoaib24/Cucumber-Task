package org.example.country;


import org.example.plan.Plan;

public class SaudiArabia implements Country {

    @Override
    public String getCountryCurrency() {
        return "SAR";
    }

    @Override
    public Plan getCountryPlan() {
        return new Plan("15", "25", "60");
    }
}
