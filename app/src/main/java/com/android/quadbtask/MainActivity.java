package com.android.quadbtask;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.chip.Chip;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout dLayout;
    NavigationView navigationView;
    ImageButton menuDrawer;
    CardView cardView;
    RelativeLayout hiddenLayout;
    Chip chipExpand,chipCollapes;
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dLayout=findViewById(R.id.dLayout);
        navigationView=findViewById(R.id.navigation);
        menuDrawer=findViewById(R.id.menuDrawer);
        cardView=findViewById(R.id.first_name);
        hiddenLayout=findViewById(R.id.hiddenLayout);
        chipExpand=findViewById(R.id.more_clip);
        chipCollapes=findViewById(R.id.collapse);
        bottomNavigation = findViewById(R.id.bottom_navigation);

        chipExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenLayout.getVisibility()==View.VISIBLE)
                {
                    TransitionManager.beginDelayedTransition(cardView,
                            new AutoTransition());
                    hiddenLayout.setVisibility(View.GONE);

                }
                else {

                    TransitionManager.beginDelayedTransition(cardView,
                            new AutoTransition());
                    hiddenLayout.setVisibility(View.VISIBLE);
                    chipExpand.setVisibility(View.GONE);
                }
            }
        });

        chipCollapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenLayout.getVisibility()==View.VISIBLE) {
                    TransitionManager.beginDelayedTransition(cardView,
                            new AutoTransition());
                    hiddenLayout.setVisibility(View.GONE);

                }

            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        menuDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dLayout.openDrawer(GravityCompat.END);
            }
        });


    }

}