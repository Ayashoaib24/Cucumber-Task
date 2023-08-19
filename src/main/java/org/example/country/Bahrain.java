package org.example.country;


import org.example.plan.Plan;

public class Bahrain implements Country {

    @Override
    public String getCountryCurrency() {
        return "BHD";
    }

    @Override
    public Plan getCountryPlan() {
        return new Plan("2", "3", "6");
    }
}
