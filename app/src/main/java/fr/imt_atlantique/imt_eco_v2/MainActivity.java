package fr.imt_atlantique.imt_eco_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.nio.file.FileSystemLoopException;
import java.util.ArrayList;

import fr.imt_atlantique.imt_eco_v2.fragments.AccountFragment;
import fr.imt_atlantique.imt_eco_v2.fragments.AddAnActivityFragment;
import fr.imt_atlantique.imt_eco_v2.fragments.DashboardFragment;

public class MainActivity extends AppCompatActivity {
    //A changer en liste de User si on veut développer en plusieurs comptes
    public User user=User.Example();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment addAnActivityFragment = new AddAnActivityFragment();
        //Fragment compareFragment = new CompareFragment();
        Fragment dashboardFragment = new DashboardFragment(this);
        Fragment accountFragment = new AccountFragment(this);


        //navigation
        BottomNavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setOnItemSelectedListener((MenuItem item) -> {
            switch (item.getItemId()) {
                case R.id.nav_add_an_activity:
                    loadFragment(addAnActivityFragment, R.string.title_add_an_activity);
                    return true;
        /*
            case R.id.nav_compare:
                loadFragment(compareFragment, R.string.title_compare);
                return true;
             */
                case R.id.nav_dashboard:
                    loadFragment(dashboardFragment, R.string.title_dashboard);
                    return true;
                case R.id.nav_account:
                    loadFragment(accountFragment, R.string.title_account);
                    return true;

                default:
                    return false;
            }
        });

    }

    public void loadFragment(Fragment fragment, int string) {
        TextView pageTitle = findViewById(R.id.page_title);
        Resources resources = getResources();
        pageTitle.setText(resources.getString(string));

        //fragment_container
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
