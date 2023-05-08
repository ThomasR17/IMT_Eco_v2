package fr.imt_atlantique.imt_eco_v2;

import java.util.ArrayList;

import fr.imt_atlantique.imt_eco_v2.activity.Activity;
import fr.imt_atlantique.imt_eco_v2.activity.Mail;
import fr.imt_atlantique.imt_eco_v2.activity.Transport;
import fr.imt_atlantique.imt_eco_v2.activity.Visio;

public class User {
    private ArrayList<Activity> activities;
    private String email;
    private String password;
    private String secretWord;

    public double total_CO2=0;
    public double total_CO2_car=0;
    public double total_km_car=0;
    public double total_CO2_train=0;
    public double total_km_train=0;
    public double total_CO2_plane=0;
    public double total_km_plane=0;
    public double total_CO2_mail=0;
    public double total_nb_mail=0;
    public double total_CO2_visio=0;
    public double total_min_visio=0;

    public User(ArrayList<Activity> activities, String email, String password, String secretWord) {
        this.activities = activities;
        this.email = email;
        this.password = password;
        this.secretWord = secretWord;
    }

    public static User Example(){
        //Stockage de la liste d'act
        ArrayList<Activity> listAct=new ArrayList<Activity>();
        //Voiture
        listAct.add(new Transport(0, 15.49));
        //train
        listAct.add(new Transport(1, 1.5));
        //plane
        listAct.add(new Transport(2, 10.5));
        //mail
        listAct.add(new Mail(1, true, true));
        //visio
        listAct.add(new Visio(10));
        User u = new User(listAct, "email", "password", "secretword");
        u.maj();
        return u;
    }

    public void maj(){
        for(int i=0; i<activities.size();i++){
            Activity a=activities.get(i);
            total_CO2+=a.getEmCO2();
            switch (a.getTypeAct()){
                case ("Transport"):
                    switch (((Transport) a).getModeTransport()){
                        case 0:
                            total_CO2_car+=a.getEmCO2();
                            total_km_car+=((Transport) a).getNbKm();
                            break;
                        case 1:
                            total_CO2_train+=a.getEmCO2();
                            total_km_train+=((Transport) a).getNbKm();
                            break;
                        case 2:
                            total_CO2_plane+=a.getEmCO2();
                            total_km_plane+=((Transport) a).getNbKm();
                    }
                    break;
                case ("Mail"):
                    total_CO2_mail+=a.getEmCO2();
                    total_nb_mail+=((Mail)a).getNbMail();
                    break;
                case("Visio"):
                    total_CO2_visio+=a.getEmCO2();
                    total_min_visio+=((Visio)a).getNbMin();
                    break;
            }
        }
    }

    // Getters and setters for activities, email, password and secretWord
    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void add(Activity activity) {
        activities.add(activity);
        maj();
    }

    public void remove(Activity activity){
        activities.remove(activity);
        maj();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }
}

