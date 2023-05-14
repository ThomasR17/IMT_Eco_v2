package fr.imt_atlantique.imt_eco_v2.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
    private SceneAdapter sceneAdapter;

    public DashboardFragment(MainActivity context){
        this.context=context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_dashboard, container, false);

        //Affichage du total et sous-total
        TextView somme_CO2 = view.findViewById(R.id.sommeCO2);
        TextView dashboard_car_output1 = view.findViewById(R.id.dashboard_car_output1);
        TextView dashboard_car_output2 = view.findViewById(R.id.dashboard_car_output2);
        TextView dashboard_train_output1 = view.findViewById(R.id.dashboard_train_output1);
        TextView dashboard_train_output2 = view.findViewById(R.id.dashboard_train_output2);
        TextView dashboard_plane_output1 = view.findViewById(R.id.dashboard_plane_output1);
        TextView dashboard_plane_output2 = view.findViewById(R.id.dashboard_plane_output2);
        TextView dashboard_mail_output1 = view.findViewById(R.id.dashboard_mail_output1);
        TextView dashboard_mail_output2 = view.findViewById(R.id.dashboard_mail_output2);
        TextView dashboard_visio_output1 = view.findViewById(R.id.dashboard_visio_output1);
        TextView dashboard_visio_output2 = view.findViewById(R.id.dashboard_visio_output2);

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

        ImageButton delete=view.findViewById(R.id.dashboard_delete_last);
        delete.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            if (context.user.getActivities().size()!=0){
                context.user.removeLastActivity();
                builder.setTitle("Success");
                builder.setMessage("Last activity successfully deleted");
            }else {
                builder.setTitle("Fail");
                builder.setMessage("No activity to delete");
            }
            AlertDialog dialog = builder.create();
            dialog.show();
            updateDashboard();
        });

        //Affichage des Recent activities
        RecyclerView verticalRecyclerView = view.findViewById(R.id.vertical_recycler_view);
        sceneAdapter=new SceneAdapter(context, R.layout.item_vertical_activity);
        verticalRecyclerView.setAdapter(sceneAdapter);
        return view;
    }

    private void updateDashboard(){
        //Affichage du total et sous-total
        TextView somme_CO2 = getView().findViewById(R.id.sommeCO2);
        TextView dashboard_car_output1 = getView().findViewById(R.id.dashboard_car_output1);
        TextView dashboard_car_output2 = getView().findViewById(R.id.dashboard_car_output2);
        TextView dashboard_train_output1 = getView().findViewById(R.id.dashboard_train_output1);
        TextView dashboard_train_output2 = getView().findViewById(R.id.dashboard_train_output2);
        TextView dashboard_plane_output1 = getView().findViewById(R.id.dashboard_plane_output1);
        TextView dashboard_plane_output2 = getView().findViewById(R.id.dashboard_plane_output2);
        TextView dashboard_mail_output1 = getView().findViewById(R.id.dashboard_mail_output1);
        TextView dashboard_mail_output2 = getView().findViewById(R.id.dashboard_mail_output2);
        TextView dashboard_visio_output1 = getView().findViewById(R.id.dashboard_visio_output1);
        TextView dashboard_visio_output2 = getView().findViewById(R.id.dashboard_visio_output2);

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

        RecyclerView verticalRecyclerView = getView().findViewById(R.id.vertical_recycler_view);
        verticalRecyclerView.setAdapter(sceneAdapter.reset(context));
    }
}
