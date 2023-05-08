package fr.imt_atlantique.imt_eco_v2.activity;

import static fr.imt_atlantique.imt_eco_v2.Constantes.CO2_PJ_CINQMO;
import static fr.imt_atlantique.imt_eco_v2.Constantes.CO2_PJ_UNMO;
import static fr.imt_atlantique.imt_eco_v2.Constantes.CO2_par_mail;

public class Mail extends Activity {
    private int nbMail;
    private boolean pj_unMo;
    private boolean pj_cinqMo;

    public Mail(int nbMail, boolean pj_unMo, boolean pj_cinqMo) {
        super("Mail");
        this.nbMail = nbMail;
        this.pj_unMo = pj_unMo;
        this.pj_cinqMo = pj_cinqMo;
        if (pj_unMo) {
            setEmCO2(nbMail * CO2_PJ_UNMO);
        } else if (pj_cinqMo) {
            setEmCO2(nbMail * CO2_PJ_CINQMO);
        } else {
            setEmCO2(nbMail * CO2_par_mail);
        }

    }

    public int getNbMail() {
        return nbMail;
    }

    public void setNbMail(int nbMail) {
        this.nbMail = nbMail;
    }

    public boolean isPj_unMo() {
        return pj_unMo;
    }

    public void setPj_unMo(boolean pj_unMo) {
        this.pj_unMo = pj_unMo;
    }

    public boolean isPj_cinqMo() {
        return pj_cinqMo;
    }

    public void setPj_cinqMo(boolean pj_cinqMo) {
        this.pj_cinqMo = pj_cinqMo;
    }
}