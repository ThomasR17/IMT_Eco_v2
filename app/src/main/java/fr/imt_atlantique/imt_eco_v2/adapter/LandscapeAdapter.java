package fr.imt_atlantique.imt_eco_v2.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import fr.imt_atlantique.imt_eco_v2.LandscapeModel;
import fr.imt_atlantique.imt_eco_v2.MainActivity;
import fr.imt_atlantique.imt_eco_v2.R;
import fr.imt_atlantique.imt_eco_v2.activity.Activity;
import fr.imt_atlantique.imt_eco_v2.activity.Transport;

public class LandscapeAdapter extends RecyclerView.Adapter<LandscapeAdapter.ViewHolder> {
    private MainActivity context;
    private int layoutId;
    private ArrayList<LandscapeModel> lsList;

    public LandscapeAdapter(MainActivity context, ArrayList<LandscapeModel> lsList, int layoutId){
        this.context=context;
        this.lsList=lsList;
        this.layoutId=layoutId;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewThumbnail;
        public ViewHolder(View itemView) {
            super(itemView);
            imageViewThumbnail = itemView.findViewById(R.id.image_item);
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
        LandscapeModel lm= lsList.get(position);

        Glide.with(context).load(Uri.parse(lm.imageUrl)).into(holder.imageViewThumbnail);
    }

    @Override
    public int getItemCount() {
        return lsList.size();
    }
}


