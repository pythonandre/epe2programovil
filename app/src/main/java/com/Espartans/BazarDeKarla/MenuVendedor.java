package com.Espartans.BazarDeKarla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.Espartans.BazarDeKarla.Fragments.HistorialFragment;
import com.Espartans.BazarDeKarla.Fragments.MiCuentaFragment;
import com.Espartans.BazarDeKarla.Fragments.ScanerFragment;
import com.google.android.material.navigation.NavigationView;


public class MenuVendedor extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    //variables para el fragment
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_vendedor);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navview);
        //Establecer evento onClick al navigationView
        navigationView.setNavigationItemSelectedListener(this);
        setActionBarDrawerToggle();
        setFragmetn();
    }

    private void setActionBarDrawerToggle() {
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
    }

    private void setFragmetn() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new ScanerFragment());
        fragmentTransaction.commit();
        setTitle("Scanner");
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (item.getItemId() == R.id.Scanner){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new ScanerFragment());
            fragmentTransaction.commit();
            setTitle("Scanner");
        }
        if (item.getItemId() == R.id.MiCuenta){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new MiCuentaFragment());
            fragmentTransaction.commit();
            setTitle("Mi Cuenta");
        }
        if (item.getItemId() == R.id.Historial){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new HistorialFragment());
            fragmentTransaction.commit();
            setTitle("Historial");
        }
        if (item.getItemId() == R.id.CerrarSesion){
            finish();
        }


        return false;
    }
}