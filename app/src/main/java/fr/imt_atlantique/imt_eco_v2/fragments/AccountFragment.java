package fr.imt_atlantique.imt_eco_v2.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

                RecyclerView horizontalRecyclerView = view.findViewById(R.id.account_horizontal_recycler_view);
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

        //Notification en cas d'erreur
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        // Change email
        TextView email = view.findViewById(R.id.account_email);
        email.setText(context.user.getEmail());
        Button emailButton = view.findViewById(R.id.account_email_submit);
        emailButton.setOnClickListener(v -> {
            EditText input = view.findViewById(R.id.acc_input_email);
            String newEmail = input.getText().toString();
            if (newEmail.isEmpty()) {
                builder.setTitle("Fail");
                builder.setMessage("Please enter a valid email.");
                AlertDialog dialog = builder.create();
                dialog.show();
            } else if (android.util.Patterns.EMAIL_ADDRESS.matcher(newEmail).matches()) {
                context.user.setEmail(newEmail);
                // Reset
                input.setText("");
                updateInformation();
            } else {
                builder.setTitle("Fail");
                builder.setMessage("Please enter a valid email.");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

// Change password
        TextView password = view.findViewById(R.id.account_password);
        password.setText(context.user.getPassword());
        Button passwordButton = view.findViewById(R.id.account_password_submit);
        passwordButton.setOnClickListener(v -> {
            EditText input = view.findViewById(R.id.acc_input_password);
            String newPassword = input.getText().toString();
            if (newPassword.isEmpty()) {
                builder.setTitle("Fail");
                builder.setMessage("Please enter a valid password.");
                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                context.user.setPassword(newPassword);
                updateInformation();
                // Reset
                input.setText("");
            }
        });

        // Change secret_response
        TextView secret_response = view.findViewById(R.id.account_secret_response);
        secret_response.setText(context.user.getSecretWord());
        Button secretButton = view.findViewById(R.id.acc_secret_submit);
        secretButton.setOnClickListener(v -> {
            EditText input = view.findViewById(R.id.acc_input_secret);
            String newSecretResponse = input.getText().toString();
            if (newSecretResponse.isEmpty()) {
                builder.setTitle("Fail");
                builder.setMessage("Please enter a valid secret response.");
                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                context.user.setSecretWord(newSecretResponse);
                updateInformation();
                // Reset
                input.setText("");
            }
        });


        return view;
    }

    private void updateInformation(){
        TextView email = getView().findViewById(R.id.account_email);
        email.setText(context.user.getEmail());

        TextView password = getView().findViewById(R.id.account_password);
        password.setText(context.user.getPassword());

        TextView secret_response = getView().findViewById(R.id.account_secret_response);
        secret_response.setText(context.user.getSecretWord());
    }
}
