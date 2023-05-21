package fr.imt_atlantique.imt_eco_v2.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import fr.imt_atlantique.imt_eco_v2.MainActivity;
import fr.imt_atlantique.imt_eco_v2.R;
import fr.imt_atlantique.imt_eco_v2.activity.Mail;
import fr.imt_atlantique.imt_eco_v2.activity.Transport;
import fr.imt_atlantique.imt_eco_v2.activity.Visio;

public class AddAnActivityFragment extends Fragment {
    private MainActivity context;

    public AddAnActivityFragment(MainActivity context){
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_an_activity, container, false);
        TextView bottomText = view.findViewById(R.id.add_an_activity_bottom_text);

        //Notification en cas d'erreur
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        //Ajout Activité: 0 Voiture
        ImageButton carSubmit = view.findViewById(R.id.add_an_activity_car_submit);
        carSubmit.setOnClickListener(v -> {
            EditText inputKm = view.findViewById(R.id.add_an_activity_car_input);
            String kmString = inputKm.getText().toString();

            if (kmString != null && !kmString.isEmpty() && !kmString.equals("0")) {
                if (Double.parseDouble(kmString)<20000){
                    // Créer une nouvelle instance Transport
                    Transport act = new Transport(0, Double.parseDouble(kmString));

                    //Ajout dans les activités de User
                    context.user.addActivity(act);

                    // Informer de la confirmation d'ajout de la nouvelle activité
                    bottomText.setText("Activity added : Car " + kmString + " km e.g " + String.format("%.2f",act.getEmCO2()) + "kgCO2");
                }
                else{
                    builder.setTitle("Fail");
                    builder.setMessage("Please enter a value inferior to 20 0000.");
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
        ImageButton trainSubmit = view.findViewById(R.id.add_an_activity_train_submit);
        trainSubmit.setOnClickListener(v -> {
            EditText inputKm = view.findViewById(R.id.add_an_activity_train_input);
            String kmString = inputKm.getText().toString();

            if (kmString != null && !kmString.isEmpty() && !kmString.equals("0")) {
                if (Double.parseDouble(kmString)<20000) {
                    // Créer une nouvelle instance Transport
                    Transport act = new Transport(1, Double.parseDouble(kmString));

                    //Ajout dans les activités de User
                    context.user.addActivity(act);

                    // Informer de la confirmation d'ajout de la nouvelle activité
                    bottomText.setText("Activity added : Train " + kmString + " km e.g " + String.format("%.2f", act.getEmCO2()) + "kgCO2");
                }else{
                    builder.setTitle("Fail");
                    builder.setMessage("Please enter a value inferior to 20 0000.");
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
        ImageButton planeSubmit = view.findViewById(R.id.add_an_activity_plane_submit);
        planeSubmit.setOnClickListener(v -> {
            EditText inputKm = view.findViewById(R.id.add_an_activity_plane_input);
            String kmString = inputKm.getText().toString();

            if (kmString != null && !kmString.isEmpty() && !kmString.equals("0")) {
                if (Double.parseDouble(kmString)<20000){
                    // Créer une nouvelle instance Transport
                    Transport act = new Transport(2, Double.parseDouble(kmString));

                    //Ajout dans les activités de User
                    context.user.addActivity(act);

                    // Informer de la confirmation d'ajout de la nouvelle activité
                    bottomText.setText("Activity added : Plane " + kmString + " km e.g " + String.format("%.2f",act.getEmCO2()) + "kgCO2");
                }else{
                    builder.setTitle("Fail");
                    builder.setMessage("Please enter a value inferior to 20 0000.");
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
        ImageButton mailSubmit = view.findViewById(R.id.add_an_activity_mail_submit);

        RadioGroup radioGroup = view.findViewById(R.id.add_an_activity_radiogroup);
        RadioButton inputBox1 = view.findViewById(R.id.add_an_activity_mail_OneMo);
        RadioButton inputBox5 = view.findViewById(R.id.add_an_activity_mail_FiveMo);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.add_an_activity_mail_OneMo) {
                inputBox5.setChecked(false);
            } else if (checkedId == R.id.add_an_activity_mail_FiveMo) {
                inputBox1.setChecked(false);
            }
        });

        mailSubmit.setOnClickListener(v -> {
            EditText inputMail = view.findViewById(R.id.add_an_activity_mail_input);
            String nbMailString = inputMail.getText().toString();

            boolean pj_unMo=inputBox1.isChecked();
            boolean pj_cinqMo=inputBox5.isChecked();

            if (nbMailString != null && !nbMailString.isEmpty() && !nbMailString.equals("0")) {
                int nbMail = Integer.parseInt(nbMailString);
                // Créer une nouvelle instance Transport
                Mail act = new Mail(nbMail, pj_unMo, pj_cinqMo);

                //Ajout dans les activités de User
                context.user.addActivity(act);

                // Informer de la confirmation d'ajout de la nouvelle activité
                if (act.getEmCO2() < 10e-3) {
                    if (nbMail > 1) {
                        if (!(pj_unMo || pj_cinqMo)) {
                            bottomText.setText("Activity added : " + nbMail + " mails without attachment e.g " + String.format("%.2f", act.getEmCO2() * 1000) + "gCO2");
                        } else if (pj_unMo == true) {
                            bottomText.setText("Activity added : " + nbMail + " mails with a 1 Mo attachment e.g " + String.format("%.2f", act.getEmCO2() * 1000) + "gCO2");
                        } else {
                            bottomText.setText("Activity added : " + nbMail + " mails with a 5 Mo attachment e.g " + String.format("%.2f", act.getEmCO2() * 1000) + "gCO2");
                        }
                    } else {
                        if (!(pj_unMo || pj_cinqMo)) {
                            bottomText.setText("Activity added : " + nbMail + " mail without attachment e.g " + String.format("%.2f", act.getEmCO2() * 1000) + "gCO2");
                        } else if (pj_unMo == true) {
                            bottomText.setText("Activity added : " + nbMail + " mail with a 1 Mo attachment e.g " + String.format("%.2f", act.getEmCO2() * 1000) + "gCO2");
                        } else {
                            bottomText.setText("Activity added : " + nbMail + " mail with a 5 Mo attachment e.g " + String.format("%.2f", act.getEmCO2() * 1000) + "gCO2");
                        }
                    }
                } else {
                    if (nbMail > 1) {
                        if (!(pj_unMo || pj_cinqMo)) {
                            bottomText.setText("Activity added : " + nbMail + " mails without attachment e.g " + String.format("%.2f", act.getEmCO2()) + "kgCO2");
                        } else if (pj_unMo == true) {
                            bottomText.setText("Activity added : " + nbMail + " mails with a 1 Mo attachment e.g " + String.format("%.2f", act.getEmCO2()) + "kgCO2");
                        } else {
                            bottomText.setText("Activity added : " + nbMail + " mails with a 5 Mo attachment e.g " + String.format("%.2f", act.getEmCO2()) + "kgCO2");
                        }
                    } else {
                        if (!(pj_unMo || pj_cinqMo)) {
                            bottomText.setText("Activity added : " + nbMail + " mail without attachment e.g " + String.format("%.2f", act.getEmCO2()) + "kgCO2");
                        } else if (pj_unMo == true) {
                            bottomText.setText("Activity added : " + nbMail + " mail with a 1 Mo attachment e.g " + String.format("%.2f", act.getEmCO2()) + "kgCO2");
                        } else {
                            bottomText.setText("Activity added : " + nbMail + " mail with a 5 Mo attachment e.g " + String.format("%.2f", act.getEmCO2()) + "kgCO2");
                        }
                    }

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
            //reset
            inputMail.setText("");
        });

        //Ajout Activité: Visio
        ImageButton visioSubmit = view.findViewById(R.id.add_an_activity_visio_submit);
        visioSubmit.setOnClickListener(v -> {
            EditText inputMin = view.findViewById(R.id.add_an_activity_visio_input);
            String nbMinString = inputMin.getText().toString();

            if (nbMinString != null && !nbMinString.isEmpty() && !nbMinString.equals("0")) {
                int nbMin = Integer.parseInt(nbMinString);
                // Créer une nouvelle instance Transport
                Visio act = new Visio(nbMin);

                //Ajout dans les activités de User
                context.user.addActivity(act);

                // Informer de la confirmation d'ajout de la nouvelle activité
                if (act.getEmCO2()<10e-3) {
                    bottomText.setText("Activity added : Visio " + nbMin + " min e.g " + String.format("%.2f", act.getEmCO2()*1000) + "gCO2");
                }else {
                    bottomText.setText("Activity added : Visio " + nbMin + " min e.g " + String.format("%.2f", act.getEmCO2()) + "kgCO2");
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

        return view;
    }
}
