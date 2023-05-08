package fr.imt_atlantique.imt_eco_v2.activity;

public class Activity {
    private String typeAct;
    private double EmCO2;

    protected Activity(String typeAct) {
        this.typeAct = typeAct;
    }

    // Getters and setters for name and EmCO2

    public String getTypeAct() {
        return typeAct;
    }

    public double getEmCO2() {
        return EmCO2;
    }

    public void setEmCO2(double EmCO2) {
        this.EmCO2 = EmCO2;
    }
}