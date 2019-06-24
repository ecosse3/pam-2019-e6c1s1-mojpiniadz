package wel.wat.edu.pl.mojpiniadz.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import wel.wat.edu.pl.mojpiniadz.fragments.FragmentCollection;
import wel.wat.edu.pl.mojpiniadz.R;
import wel.wat.edu.pl.mojpiniadz.fragments.podsumowanieFragment;
import wel.wat.edu.pl.mojpiniadz.fragments.wydatkiFragment;
import wel.wat.edu.pl.mojpiniadz.fragments.zarobkiFragment;

/*
Znajdują się tu listy wydatków, zarobków i podsumowanie, umieszczone we fragmentach. Na raz można wyświtlić jedną, a
sterowanie tym jest poprzez naciśnięcie przycisków. Znajduje się tu również obsługa przycisku (w aplikacji po
prawej na dole), który służy do dodania rekordu w wydatkach lub zarobkach.
 */
public class MainActivity extends AppCompatActivity {


    private ViewPager viewpager;
    private FragmentCollection adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //viewpager=findViewById(R.id.pager);
        //adapter=new FragmentCollection(getSupportFragmentManager());
        //viewpager.setAdapter(adapter);
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.frame, new wydatkiFragment());
        fragmentTransaction1.commit();




        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        if(id==R.id.action_options){
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        if (id==R.id.action_about){
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.action_wydatki:
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frame, new wydatkiFragment());
                    fragmentTransaction1.commit();
                    return true;
                case R.id.action_zarobki:
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.frame, new zarobkiFragment());
                    fragmentTransaction2.commit();
                    return true;

                case R.id.action_podsumowanie:
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.frame, new podsumowanieFragment());
                    fragmentTransaction3.commit();
                    return true;
            }
            return false;
        }
    };

}
