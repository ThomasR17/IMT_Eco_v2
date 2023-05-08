package fr.imt_atlantique.imt_eco_v2.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import fr.imt_atlantique.imt_eco_v2.LandscapeModel;
import fr.imt_atlantique.imt_eco_v2.MainActivity;
import fr.imt_atlantique.imt_eco_v2.R;
import fr.imt_atlantique.imt_eco_v2.adapter.LandscapeAdapter;
import fr.imt_atlantique.imt_eco_v2.adapter.SceneAdapter;

public class AccountFragment extends Fragment {
    private MainActivity context;
    private ArrayList<LandscapeModel> lsList;

    public AccountFragment(MainActivity context){
        lsList=new ArrayList<LandscapeModel>();
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_account, container, false);

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("Landscapes");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<LandscapeModel> landscapeList = new ArrayList<>();
                for (DataSnapshot landscapeSnapshot : snapshot.getChildren()) {
                    LandscapeModel landscape = landscapeSnapshot.getValue(LandscapeModel.class);
                    landscapeList.add(landscape);
                }

                RecyclerView horizontalRecyclerView = view.findViewById(R.id.horizontal_recycler_view);
                horizontalRecyclerView.setAdapter(new LandscapeAdapter(context, landscapeList, R.layout.item_horizontal_img));

                // Set up automatic scrolling
                final int speedScroll = 3000;
                final Handler handler = new Handler();
                final Runnable runnable = new Runnable() {
                    int count = 0;
                    boolean flag = true;
                    @Override
                    public void run() {
                        if(count < landscapeList.size()){
                            if(count==landscapeList.size()-1){
                                flag = false;
                            }else if(count == 0){
                                flag = true;
                            }
                            if(flag) count++;
                            else count=0;

                            horizontalRecyclerView.smoothScrollToPosition(count);
                            handler.postDelayed(this,speedScroll);
                        } else {
                            count = 0;
                            horizontalRecyclerView.smoothScrollToPosition(count);
                            handler.postDelayed(this,speedScroll);
                        }
                    }
                };

                handler.postDelayed(runnable,speedScroll);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Gérez les erreurs de base de données Firebase ici
            }
        });

        return view;
    }

}
