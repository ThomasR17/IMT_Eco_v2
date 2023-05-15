package fr.imt_atlantique.imt_eco_v2.activity;

import static fr.imt_atlantique.imt_eco_v2.Constantes.stat_CO2;

public class Transport extends Activity {
    private double nbKm;
    /* 0:voiture - 1:train - 2:plane */
    private int modeTransport;

    public Transport(int modeTransport, double nbKm) {
        super("Transport");
        this.nbKm = nbKm;
        this.modeTransport = modeTransport;
        setEmCO2(nbKm*stat_CO2[modeTransport]);
    }

    public double getNbKm() {
        return nbKm;
    }

    public int getModeTransport() {
        return modeTransport;
    }
}