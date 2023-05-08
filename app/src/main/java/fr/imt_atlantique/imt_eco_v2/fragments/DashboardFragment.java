package fr.imt_atlantique.imt_eco_v2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import fr.imt_atlantique.imt_eco_v2.MainActivity;
import fr.imt_atlantique.imt_eco_v2.R;
import fr.imt_atlantique.imt_eco_v2.activity.Activity;
import fr.imt_atlantique.imt_eco_v2.activity.Mail;
import fr.imt_atlantique.imt_eco_v2.activity.Transport;
import fr.imt_atlantique.imt_eco_v2.activity.Visio;
import fr.imt_atlantique.imt_eco_v2.adapter.SceneAdapter;

public class DashboardFragment extends Fragment {
    private MainActivity context;

    public DashboardFragment(MainActivity context){
        this.context=context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_dashboard, container, false);

        //Affichage du total et sous-total
        TextView somme_CO2;
        TextView dashboard_car_output1;
        TextView dashboard_car_output2;
        TextView dashboard_train_output1;
        TextView dashboard_train_output2;
        TextView dashboard_plane_output1;
        TextView dashboard_plane_output2;
        TextView dashboard_mail_output1;
        TextView dashboard_mail_output2;
        TextView dashboard_visio_output1;
        TextView dashboard_visio_output2;

        somme_CO2 = view.findViewById(R.id.sommeCO2);
        dashboard_car_output1 = view.findViewById(R.id.dashboard_car_output1);
        dashboard_car_output2 = view.findViewById(R.id.dashboard_car_output2);
        dashboard_train_output1 = view.findViewById(R.id.dashboard_train_output1);
        dashboard_train_output2 = view.findViewById(R.id.dashboard_train_output2);
        dashboard_plane_output1 = view.findViewById(R.id.dashboard_plane_output1);
        dashboard_plane_output2 = view.findViewById(R.id.dashboard_plane_output2);
        dashboard_mail_output1 = view.findViewById(R.id.dashboard_mail_output1);
        dashboard_mail_output2 = view.findViewById(R.id.dashboard_mail_output2);
        dashboard_visio_output1 = view.findViewById(R.id.dashboard_visio_output1);
        dashboard_visio_output2 = view.findViewById(R.id.dashboard_visio_output2);

        somme_CO2.setText(String.format("%.2f", context.user.total_CO2));
        dashboard_car_output1.setText(String.format("%.2f", context.user.total_km_car));
        dashboard_car_output2.setText(String.format("%.2f", context.user.total_CO2_car));
        dashboard_train_output1.setText(String.format("%.2f", context.user.total_km_train));
        dashboard_train_output2.setText(String.format("%.2f", context.user.total_CO2_train));
        dashboard_plane_output1.setText(String.format("%.2f", context.user.total_km_plane));
        dashboard_plane_output2.setText(String.format("%.2f", context.user.total_CO2_plane));
        dashboard_mail_output1.setText(String.format("%.2f", context.user.total_nb_mail));
        dashboard_mail_output2.setText(String.format("%.2f", context.user.total_CO2_mail));
        dashboard_visio_output1.setText(String.format("%.2f", context.user.total_min_visio));
        dashboard_visio_output2.setText(String.format("%.2f", context.user.total_CO2_visio));

        //Affichage des Recent activities
        RecyclerView verticalRecyclerView = view.findViewById(R.id.vertical_recycler_view);
        verticalRecyclerView.setAdapter(new SceneAdapter(context, R.layout.item_vertical_activity));

        return view;
    }
}
