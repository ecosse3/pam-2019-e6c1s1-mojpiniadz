package wel.wat.edu.pl.mojpiniadz.fragments;

/*
Ta klasa pozwala na sterowanie fragmentami, czyli wyborze, któy aktualnie jest na ekranie naszego smartfona.
 */


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class FragmentCollection extends FragmentPagerAdapter {
    public FragmentCollection(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                return new wydatkiFragment();
            case 1:
                return new zarobkiFragment();
            case 2:
                return new podsumowanieFragment();
                default:
             return new wydatkiFragment();
        }
    }

    @Override
    public int getCount(){
        return 3;
    }


}
