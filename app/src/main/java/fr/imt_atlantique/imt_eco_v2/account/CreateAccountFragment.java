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

import fr.imt_atlantique.imt_eco_v2.MainActivity;
import fr.imt_atlantique.imt_eco_v2.R;

public class CreateAccountFragment extends Fragment {
    MainActivity context;

    public CreateAccountFragment(MainActivity context) {
        this.context = context;
    }

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_account, container, false);

        Button signinButton = view.findViewById(R.id.sign_in_button);
        signinButton.setOnClickListener((View v) -> {
            // Perform login validation and transition to MainActivity
            // Code for login validation

            // Replace the current fragment with MainActivity
            context.loadFragment(context.addAnActivityFragment, R.string.title_add_an_activity);
            context.setBottomNavigationViewVisibility(View.VISIBLE);
        });

        TextView to_login_button = view.findViewById(R.id.Already_have_acc);
        to_login_button.setOnClickListener((View v) -> {
            context.loadFragment(context.login, R.string.title_login);
            context.setBottomNavigationViewVisibility(View.GONE);
        });

        context.setBottomNavigationViewVisibility(View.GONE);
        return view;
    }
}