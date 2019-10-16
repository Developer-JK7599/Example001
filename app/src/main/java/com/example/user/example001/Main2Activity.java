package com.example.user.example001;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {

    LinearLayout linearLayout;
    Snackbar mSnackbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        linearLayout = findViewById(R.id.linearlayout);
        mSnackbar = Snackbar.make(linearLayout, "Press again to exit", Snackbar.LENGTH_SHORT);

        /*if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.share_id:
                String str = "https://www.google.com";
                Intent share = new Intent(Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT, str);
                share.setType("text/plain");
                startActivity(Intent.createChooser(share, "Choose an send client:"));
                break;

            case R.id.menu_id:
                if (item.getTitle().equals("Logout")) {
                    Toast.makeText(this, "Logout...", Toast.LENGTH_SHORT).show();
                }
                if (item.getTitle().equals("Settings")) {
                    Toast.makeText(this, "Settings...", Toast.LENGTH_SHORT).show();
                }
                return true;

        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mSnackbar.isShown()) {
            super.onBackPressed();
        } else {
            mSnackbar.show();
        }
    }
}
