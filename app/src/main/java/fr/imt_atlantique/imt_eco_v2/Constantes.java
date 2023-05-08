package fr.imt_atlantique.imt_eco_v2;

public class Constantes {
    /*
    Here you can find all the coefficients necessary for calculating
    the CO2 emissions for all the listed activities.
    They are editable to ensure they are up-to-date.
    */

    //Transport
    /* 0:voiture - 1:train - 2:plane */
    public static final double[] stat_CO2 = {0.21, 0.03, 0.22};

    //Mail
    public static final double CO2_par_mail = 0.00007;
    public static final double CO2_PJ_UNMO = 0.0007;
    public static final double CO2_PJ_CINQMO = 0.008;

    //Visio
    public static final double CO2_min_visio=0.03;
}

