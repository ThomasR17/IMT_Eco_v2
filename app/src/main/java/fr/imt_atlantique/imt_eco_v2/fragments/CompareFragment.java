package fr.imt_atlantique.imt_eco_v2.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import fr.imt_atlantique.imt_eco_v2.MainActivity;
import fr.imt_atlantique.imt_eco_v2.R;
import fr.imt_atlantique.imt_eco_v2.activity.Mail;
import fr.imt_atlantique.imt_eco_v2.activity.Transport;
import fr.imt_atlantique.imt_eco_v2.activity.Visio;

public class CompareFragment extends Fragment {
    private MainActivity context;

    public CompareFragment(MainActivity context){this.context=context;}

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_compare, container, false);

        //Recuperer les TextView
        TextView act1 = view.findViewById(R.id.compare_act1);
        TextView act1_CO2 = view.findViewById(R.id.compare_act1_CO2);
        TextView act2 = view.findViewById(R.id.compare_act2);
        TextView act2_CO2 = view.findViewById(R.id.compare_act2_CO2);

        //Reset
        act1.setText("");
        act1_CO2.setText("");
        act2.setText("");
        act2_CO2.setText("");

        //Notification en cas d'erreur
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        //Ajout Activité: 0 Voiture
        ImageButton carSubmit = view.findViewById(R.id.compare_car_submit);
        carSubmit.setOnClickListener(v -> {
            EditText inputKm = view.findViewById(R.id.compare_car_input);
            String kmString = inputKm.getText().toString();

            //Compare
            String act1String = act1.getText().toString();
            String act2String = act2.getText().toString();

            if (!kmString.isEmpty() && !kmString.equals("0")) {
                // Créer une nouvelle instance Transport
                Transport act = new Transport(0, Double.parseDouble(kmString));

                //Ajout dans comparaison
                if (act1String.equals("")){
                    act1.setText("Car " + kmString + " km");
                    act1_CO2.setText(String.format("%.2f",act.getEmCO2()) + "\nkgCO2");
                } else if (act2String.equals("")) {
                    act2.setText("Car " + kmString + " km");
                    act2_CO2.setText(String.format("%.2f",act.getEmCO2()) + "\nkgCO2");
                } else {
                    builder.setTitle("Fail");
                    builder.setMessage("No empty space to compare. Please remove one activity.");
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }else{
                builder.setTitle("Fail");
                builder.setMessage("Please enter a valid value.");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            //reset
            inputKm.setText("");
        });

        //Ajout Activité: 1 Train
        ImageButton trainSubmit = view.findViewById(R.id.compare_train_submit);
        trainSubmit.setOnClickListener(v -> {
            EditText inputKm = view.findViewById(R.id.compare_train_input);
            String kmString = inputKm.getText().toString();

            //Compare
            String act1String = act1.getText().toString();
            String act2String = act2.getText().toString();

            if (!kmString.isEmpty() && !kmString.equals("0")) {
                // Créer une nouvelle instance Transport
                Transport act = new Transport(1, Double.parseDouble(kmString));

                //Ajout dans comparaison
                if (act1String.equals("")){
                    act1.setText("Train " + kmString + " km");
                    act1_CO2.setText(String.format("%.2f",act.getEmCO2()) + "\nkgCO2");
                } else if (act2String.equals("")) {
                    act2.setText("Train " + kmString + " km");
                    act2_CO2.setText(String.format("%.2f",act.getEmCO2()) + "\nkgCO2");
                } else {
                    builder.setTitle("Fail");
                    builder.setMessage("No empty space to compare. Please remove one activity.");
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }else{
                builder.setTitle("Fail");
                builder.setMessage("Please enter a valid value.");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            //reset
            inputKm.setText("");
        });

        //Ajout Activité: 2 Avion
        ImageButton planeSubmit = view.findViewById(R.id.compare_plane_submit);
        planeSubmit.setOnClickListener(v -> {
            EditText inputKm = view.findViewById(R.id.compare_plane_input);
            String kmString = inputKm.getText().toString();

            //Compare
            String act1String = act1.getText().toString();
            String act2String = act2.getText().toString();


            if (!kmString.isEmpty() && !kmString.equals("0")) {
                // Créer une nouvelle instance Transport
                Transport act = new Transport(2, Double.parseDouble(kmString));

                //Ajout dans comparaison
                if (act1String.equals("")){
                    act1.setText("Plane " + kmString + " km");
                    act1_CO2.setText(String.format("%.2f",act.getEmCO2()) + "\nkgCO2");
                } else if (act2String.equals("")) {
                    act2.setText("Plane " + kmString + " km");
                    act2_CO2.setText(String.format("%.2f",act.getEmCO2()) + "\nkgCO2");
                } else {
                    builder.setTitle("Fail");
                    builder.setMessage("No empty space to compare. Please remove one activity.");
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

            }else{
                builder.setTitle("Fail");
                builder.setMessage("Please enter a valid value.");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            //reset
            inputKm.setText("");
        });

        //Ajout Activité: Mail
        ImageButton mailSubmit = view.findViewById(R.id.compare_mail_submit);
        mailSubmit.setOnClickListener(v -> {
            EditText inputMail = view.findViewById(R.id.compare_mail_input);
            String nbMailString = inputMail.getText().toString();

            //Compare
            String act1String = act1.getText().toString();
            String act2String = act2.getText().toString();


            RadioButton inputBox1 = view.findViewById(R.id.compare_mail_OneMo);
            RadioButton inputBox5 = view.findViewById(R.id.compare_mail_FiveMo);
            boolean pj_unMo=inputBox1.isChecked();
            boolean pj_cinqMo=inputBox5.isChecked();

            if (!nbMailString.isEmpty() && !nbMailString.equals("0")) {
                int nbMail = Integer.parseInt(nbMailString);
                // Créer une nouvelle instance Transport
                Mail act = new Mail(nbMail, pj_unMo, pj_cinqMo);
                String text;
                String textCO2;

                if (act.getEmCO2() < 10e-3) {
                    if (nbMail > 1) {
                        if (!(pj_unMo || pj_cinqMo)) {
                            text=(nbMail + " mails\nwithout attachment");
                        } else if (pj_unMo) {
                            text=(nbMail + " mails\n+ 1 Mo attachment");
                        } else {
                            text=(nbMail + " mails\n+ 5 Mo attachment");
                        }
                    } else {
                        if (!(pj_unMo || pj_cinqMo)) {
                            text=(nbMail + " mail\nwithout attachment");
                        } else if (pj_unMo) {
                            text=(nbMail + " mail\n+ 1 Mo attachment");
                        } else {
                            text=(nbMail + " mail\n+ 5 Mo attachment");
                        }
                    }
                    textCO2=String.format("%.2f", act.getEmCO2() * 1000) + "\ngCO2";
                } else {
                    if (nbMail > 1) {
                        if (!(pj_unMo || pj_cinqMo)) {
                            text=(nbMail + " mails\nwithout attachment");
                        } else if (pj_unMo) {
                            text=(nbMail + " mails\n+ 1 Mo attachment");
                        } else {
                            text=(nbMail + " mails\n+ 5 Mo attachment");
                        }
                    } else {
                        if (!(pj_unMo || pj_cinqMo)) {
                            text=(nbMail + " mail\nwithout attachment");
                        } else if (pj_unMo) {
                            text=(nbMail + " mail\n+ 1 Mo attachment");
                        } else {
                            text=(nbMail + " mail\n+ 5 Mo attachment");
                        }
                    }
                    textCO2=String.format("%.2f", act.getEmCO2()) + "\nkgCO2";
                }

                //Ajout dans comparaison
                if (act1String.equals("")){
                    act1.setText(text);
                    act1_CO2.setText(textCO2);
                } else if (act2String.equals("")) {
                    act2.setText(text);
                    act2_CO2.setText(textCO2);
                } else {
                    builder.setTitle("Fail");
                    builder.setMessage("No empty space to compare. Please remove one activity.");
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                //reset
                inputMail.setText("");
                inputBox1.setChecked(false);
                inputBox5.setChecked(false);
            }else{
                builder.setTitle("Fail");
                builder.setMessage("Please enter a valid value.");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        //Ajout Activité: Visio
        ImageButton visioSubmit = view.findViewById(R.id.compare_visio_submit);
        visioSubmit.setOnClickListener(v -> {
            EditText inputMin = view.findViewById(R.id.compare_visio_input);
            String nbMinString = inputMin.getText().toString();

            //Compare
            String act1String = act1.getText().toString();
            String act2String = act2.getText().toString();


            if (!nbMinString.isEmpty() && !nbMinString.equals("0")) {
                int nbMin = Integer.parseInt(nbMinString);
                // Créer une nouvelle instance Transport
                Visio act = new Visio(nbMin);
                String textCO2;
                if (act.getEmCO2()<10e-3) {
                    textCO2=String.format("%.2f", act.getEmCO2()*1000) + "\ngCO2";
                }else {
                    textCO2=String.format("%.2f", act.getEmCO2()) + "\nkgCO2";
                }

                //Ajout dans comparaison
                if (act1String.equals("")){
                    act1.setText("Visio " + nbMinString + " min");
                    act1_CO2.setText(textCO2);
                } else if (act2String.equals("")) {
                    act2.setText("Visio " + nbMinString + " min");
                    act2_CO2.setText(textCO2);
                } else {
                    builder.setTitle("Fail");
                    builder.setMessage("No empty space to compare. Please remove one activity.");
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }else{
                builder.setTitle("Fail");
                builder.setMessage("Please enter a valid value.");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            //reset
            inputMin.setText("");
        });

        //Suppression d'activité
        ImageButton del_act1 = view.findViewById(R.id.compare_delete_act1);
        del_act1.setOnClickListener(v -> {
            if (act1.getText().toString().equals("")){
                builder.setTitle("Fail");
                builder.setMessage("Nothing to delete.");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else {
                act1.setText("");
                act1_CO2.setText("");
            }
        });

        ImageButton del_act2 = view.findViewById(R.id.compare_delete_act2);
        del_act2.setOnClickListener(v -> {
            if (act2.getText().toString().equals("")){
                builder.setTitle("Fail");
                builder.setMessage("Nothing to delete.");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else {
                act2.setText("");
                act2_CO2.setText("");
            }
        });

        return view;
    }
}
