package fr.imt_atlantique.imt_eco_v2.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import fr.imt_atlantique.imt_eco_v2.MainActivity;
import fr.imt_atlantique.imt_eco_v2.R;
import fr.imt_atlantique.imt_eco_v2.adapter.SceneAdapter;

public class Login extends Fragment {
    MainActivity context;

    public Login(MainActivity context){this.context=context;}

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.login, container, false);

        RecyclerView horizontalRecyclerView = view.findViewById(R.id.login_horizontal_recycler_view);
        horizontalRecyclerView.setAdapter(new SceneAdapter(context, R.layout.item_horizontal_img));

        return view;
    }
}
