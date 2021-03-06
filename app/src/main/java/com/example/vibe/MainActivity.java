    // CREATE ACCOUNT
// SIGN UP ACTIVITY THROUGH
// EMAIL
// GOOGLE
// FACEBOOK

package com.example.vibe;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vibe.Adapters.FragmentsAdapter;
import com.example.vibe.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.settings:
                Intent intentS = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(intentS);
                break;
            case R.id.logout:
                auth.signOut();
                Intent intent  = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
                break;
            case R.id.groupChat:
                Intent intentG  = new Intent(MainActivity.this, GroupChatActivity.class);
                startActivity(intentG);
                break;
        }
        return true;
    }

    public void onBackPressed() {
        //  super.onBackPressed();
        moveTaskToBack(true);
    }
}