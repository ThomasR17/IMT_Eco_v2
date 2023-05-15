package fr.imt_atlantique.imt_eco_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.nio.file.FileSystemLoopException;
import java.util.ArrayList;

import fr.imt_atlantique.imt_eco_v2.account.CreateAccountFragment;
import fr.imt_atlantique.imt_eco_v2.account.Login;
import fr.imt_atlantique.imt_eco_v2.fragments.AccountFragment;
import fr.imt_atlantique.imt_eco_v2.fragments.AddAnActivityFragment;
import fr.imt_atlantique.imt_eco_v2.fragments.CompareFragment;
import fr.imt_atlantique.imt_eco_v2.fragments.DashboardFragment;


/*
TODOLIST:
Finir fragment_account
faire login, resset, create
dans login etc. ajouter spinner pour secret question(modifier attribut de User)

base de données sur account
 */
public class MainActivity extends AppCompatActivity {
    //A changer en liste de User si on veut développer en plusieurs comptes
    public User user=User.Example();
    public Fragment addAnActivityFragment;
    public Fragment dashboardFragment;
    public Fragment compareFragment;
    public Fragment accountFragment;
    public Fragment createAccountFragment;
    public Fragment login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addAnActivityFragment = new AddAnActivityFragment(this);
        compareFragment = new CompareFragment(this);
        dashboardFragment = new DashboardFragment(this);
        accountFragment = new AccountFragment(this);
        login = new Login(this);
        createAccountFragment = new CreateAccountFragment(this);

        loadFragment(login, R.string.title_login);

        //navigation
        BottomNavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setOnItemSelectedListener((MenuItem item) -> {
            switch (item.getItemId()) {
                case R.id.nav_add_an_activity:
                    loadFragment(addAnActivityFragment, R.string.title_add_an_activity);
                    return true;

                case R.id.nav_compare:
                    loadFragment(compareFragment, R.string.title_compare);
                return true;

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

    public void setBottomNavigationViewVisibility(int visibility) {
        BottomNavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setVisibility(visibility);
    }
}
