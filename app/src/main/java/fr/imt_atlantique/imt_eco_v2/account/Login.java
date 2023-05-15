package fr.imt_atlantique.imt_eco_v2.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fr.imt_atlantique.imt_eco_v2.MainActivity;
import fr.imt_atlantique.imt_eco_v2.R;
import fr.imt_atlantique.imt_eco_v2.adapter.LandscapeAdapter;
import fr.imt_atlantique.imt_eco_v2.adapter.SceneAdapter;
import fr.imt_atlantique.imt_eco_v2.fragments.AccountFragment;
import fr.imt_atlantique.imt_eco_v2.fragments.AddAnActivityFragment;
import fr.imt_atlantique.imt_eco_v2.fragments.CompareFragment;
import fr.imt_atlantique.imt_eco_v2.fragments.DashboardFragment;

public class Login extends Fragment {
    MainActivity context;

    public Login(MainActivity context){this.context=context;}

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.login, container, false);

        //à revoir
        //RecyclerView horizontalRecyclerView = view.findViewById(R.id.login_horizontal_recycler_view);
        Button loginButton = view.findViewById(R.id.login_buttonLogin);
        loginButton.setOnClickListener((View v) -> {
            // Perform login validation and transition to MainActivity
            // Code for login validation

            // Replace the current fragment with MainActivity
            context.loadFragment(context.addAnActivityFragment, R.string.title_add_an_activity);
            context.setBottomNavigationViewVisibility(View.VISIBLE);
        });

        TextView signupButton = view.findViewById(R.id.login_Dont_have_acc);
        signupButton.setOnClickListener((View v) -> {
            // Replace the current fragment with MainActivity
            context.loadFragment(context.createAccountFragment, R.string.title_sign_up);
            context.setBottomNavigationViewVisibility(View.GONE);
        });

        // Hide the BottomNavigationView in the login fragment
        context.setBottomNavigationViewVisibility(View.GONE);

        return view;
    }

}
