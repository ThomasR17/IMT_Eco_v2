package fr.imt_atlantique.imt_eco_v2.activity;

import static fr.imt_atlantique.imt_eco_v2.Constantes.CO2_min_visio;

public class Visio extends Activity {
    private int nbMin;

    public Visio(int nbMin) {
        super("Visio");
        this.nbMin = nbMin;
        setEmCO2(nbMin*CO2_min_visio);
    }

    public int getNbMin() {
        return nbMin;
    }

    public void setNbMin(int nbMin) {
        this.nbMin = nbMin;
    }
}
