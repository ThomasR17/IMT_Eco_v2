package fr.imt_atlantique.imt_eco_v2.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import fr.imt_atlantique.imt_eco_v2.R;
import fr.imt_atlantique.imt_eco_v2.adapter.SceneAdapter;

public class Login {

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.login, container, false);

        //RecyclerView horizontalRecyclerView = view.findViewById(R.id.horizontal_recycler_view);
        //horizontalRecyclerView.setAdapter(new SceneAdapter(R.layout.item_horizontal_img));

        return view;
    }

    /*
    * @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login, container, false);

        Button loginButton = view.findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vérifier les informations de connexion de l'utilisateur ici
                boolean isLoginSuccessful = true; // Mettez ici le résultat de la vérification

                if (isLoginSuccessful) {
                    Intent intent = new Intent(getActivity(), ActivitiesActivity.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }*/
}
