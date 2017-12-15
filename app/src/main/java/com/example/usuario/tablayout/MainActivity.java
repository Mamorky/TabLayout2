package com.example.usuario.tablayout;

import android.app.FragmentManager;
import android.content.res.TypedArray;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Opcion1:
 * En este ejercicio se ha visto como crear un tablayout de forma independiente al viewpager,
 * para ello hay que implementar el listener en tablayout y el listener en viewpager y vincularlos de forma que se actualice
 * el otro elemento
 *
 * Opcion2:
 * Vincula el viepager con el metodo setupViewPager().
 * se debe cumplir que el titulo de las pestañas del tab se inicializa mediante el metodo getPageTitle
 */
public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabs);

        setSupportActionBar(toolbar);

        //Para que el tab se pueda mover
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        //Añadir texto a las tabs mediante un array de string

        for(String title:getResources().getStringArray(R.array.tab_layout)){
            tabLayout.addTab(tabLayout.newTab());
        }


        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),
                new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.tab_layout)))));
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        /* Opcion 1:
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.setScrollPosition(position,0f,true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/

        //Opcion 2
        tabLayout.setupWithViewPager(viewPager);
        //Si quiero personalizar las pestañas siempre se debe realizar despues  del metodo anterior

        setupTabIcons();
    }

    private void setupTabIcons() {
        TypedArray typedArray = getResources().obtainTypedArray(R.array.icons);
        for(int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(typedArray.getResourceId(i,-1));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_fragment,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
