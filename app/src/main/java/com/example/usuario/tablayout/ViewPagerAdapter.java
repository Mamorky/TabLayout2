package com.example.usuario.tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by usuario on 13/12/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private  int count;
    private ArrayList<String> titles;
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public ViewPagerAdapter(FragmentManager fm, int count,ArrayList<String> titles) {
        super(fm);
        //count es el numero de paginas
        this.count = count;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        CustomFragment customFragment = null;
        Bundle bundle = new Bundle();
        switch (position){
            case 0:
                bundle.putString("message","Fragment 1");
                customFragment = CustomFragment.newInstance(bundle);
                break;
            case 1:
                bundle.putString("message","Fragment 2");
                customFragment = CustomFragment.newInstance(bundle);
                break;
            case 2:
                bundle.putString("message","Fragment 3");
                customFragment = CustomFragment.newInstance(bundle);
                break;
            case 3:
                bundle.putString("message","Fragment 4");
                customFragment = CustomFragment.newInstance(bundle);
                break;
            case 4:
                bundle.putString("message","Fragment 5");
                customFragment = CustomFragment.newInstance(bundle);
                break;
        }
        return customFragment;
    }

    @Override
    public int getCount() {
        return count;
    }

    /*@Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }*/
}
