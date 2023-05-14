package fr.imt_atlantique.imt_eco_v2.adapter;

import android.icu.number.ScientificNotation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import fr.imt_atlantique.imt_eco_v2.MainActivity;
import fr.imt_atlantique.imt_eco_v2.R;
import fr.imt_atlantique.imt_eco_v2.activity.Activity;
import fr.imt_atlantique.imt_eco_v2.activity.Mail;
import fr.imt_atlantique.imt_eco_v2.activity.Transport;
import fr.imt_atlantique.imt_eco_v2.activity.Visio;
import fr.imt_atlantique.imt_eco_v2.fragments.DashboardFragment;

public class SceneAdapter extends RecyclerView.Adapter<SceneAdapter.ViewHolder> {
    private MainActivity context;
    private int layoutId;
    private ArrayList<Activity> list_act;

    public SceneAdapter(MainActivity context, int layoutId){
        this.context=context;
        this.list_act=context.user.getActivities();
        this.layoutId=layoutId;
    }

    public SceneAdapter reset(MainActivity context){
        this.context=context;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView actImage;
        public TextView actName;
        public TextView actDesc;
        public ViewHolder(View itemView) {
            super(itemView);
            actImage = itemView.findViewById(R.id.image_item);
            actName = itemView.findViewById(R.id.act_name);
            actDesc = itemView.findViewById(R.id.act_desc);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(layoutId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Activity act = list_act.get(list_act.size()-position-1);

        // Mettre à jour les vues dans le ViewHolder avec les données
        switch (act.getTypeAct()) {
            case "Transport":
                switch (((Transport) act).getModeTransport()) {
                    case 0:
                        //voiture
                        holder.actImage.setImageResource(R.drawable.ic_car);
                        holder.actName.setText("Car : "+((Transport) act).getNbKm()+" km");
                        holder.actDesc.setText(act.getTypeAct()+" "+String.format("%.2f", act.getEmCO2())+" kg CO2");
                        break;
                    case 1:
                        //train
                        holder.actImage.setImageResource(R.drawable.ic_train);
                        holder.actName.setText("Train : "+((Transport) act).getNbKm()+" km");
                        holder.actDesc.setText(act.getTypeAct()+" "+String.format("%.2f", act.getEmCO2())+" kg CO2");
                        break;
                    case 2:
                        //avion
                        holder.actImage.setImageResource(R.drawable.ic_plane);
                        holder.actName.setText("Plane : "+((Transport) act).getNbKm()+" km");
                        holder.actDesc.setText(act.getTypeAct()+" "+String.format("%.2f", act.getEmCO2())+" kg CO2");
                        break;
                }
                break;
            case "Mail":
                //mail
                holder.actImage.setImageResource(R.drawable.ic_mail);
                holder.actName.setText("Mail : "+((Mail) act).getNbMail()+" mails");
                if (act.getEmCO2()<10e-3) {
                    holder.actDesc.setText("Communication " + String.format("%.2f", act.getEmCO2()*1000) + " g CO2");
                }else {
                    holder.actDesc.setText(act.getTypeAct()+" "+String.format("%.2f", act.getEmCO2())+" kg CO2");
                }
                break;
            case "Visio":
                //visio
                holder.actImage.setImageResource(R.drawable.ic_visio);
                holder.actName.setText("Visio : "+((Visio) act).getNbMin()+" min");
                if (act.getEmCO2()<10e-3) {
                    holder.actDesc.setText("Communication " + String.format("%.2f", act.getEmCO2()*1000) + " g CO2");
                }else {
                    holder.actDesc.setText(act.getTypeAct()+" "+String.format("%.2f", act.getEmCO2())+" kg CO2");
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list_act.size();
    }
}

