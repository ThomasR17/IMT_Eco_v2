package fr.imt_atlantique.imt_eco_v2.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import fr.imt_atlantique.imt_eco_v2.MainActivity;
import fr.imt_atlantique.imt_eco_v2.R;
import fr.imt_atlantique.imt_eco_v2.activity.Transport;

public class AddAnActivityFragment extends Fragment {
    private MainActivity context;

    public AddAnActivityFragment(MainActivity context){
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_an_activity, container, false);
        ImageButton carSubmit = view.findViewById(R.id.add_an_activity_car_submit);
        TextView bottomText = view.findViewById(R.id.add_an_activity_bottom_text);

        carSubmit.setOnClickListener(v -> {
            EditText inputKm = view.findViewById(R.id.add_an_activity_car_input);
            String kmString = inputKm.getText().toString();

            // Créer une nouvelle instance Transport
            Transport act = new Transport(0, Double.parseDouble(kmString));

            //Ajout dans les activités de User
            context.user.addActivity(act);

            // Informer de la confirmation d'ajout de la nouvelle activité
            bottomText.setText("Activity added : Car " + kmString + " km soit "+context.user.getActivities().get(context.user.getActivities().size()-1).getEmCO2()+"kgCO2");
        });





        return view;
    }
}
