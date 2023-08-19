package org.example.plan;

public class Plan {
    private String lite;
    private String classic;

    private String premium;

    private Plan() {

    }

    public Plan(String lite, String classic, String premium) {
        this.lite = lite;
        this.classic = classic;
        this.premium = premium;
    }

    public String getLite() {
        return lite;
    }

    public void setLite(String lite) {
        this.lite = lite;
    }

    public String getClassic() {
        return classic;
    }

    public void setClassic(String classic) {
        this.classic = classic;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

}
