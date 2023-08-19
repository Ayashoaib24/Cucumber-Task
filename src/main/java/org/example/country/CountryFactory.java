package org.example.country;

import org.example.country.Bahrain;
import org.example.country.Country;
import org.example.country.Kuwait;
import org.example.country.SaudiArabia;

public class CountryFactory {

    public static Country provideCountryPlan(String country) throws Exception {
        return switch (country) {
            case "sa" -> new SaudiArabia();
            case "kw" -> new Kuwait();
            case "bh" -> new Bahrain();
            default -> throw new Exception("undefined country");
        };
    }

}
