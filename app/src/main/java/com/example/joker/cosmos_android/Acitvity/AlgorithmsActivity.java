package com.example.joker.cosmos_android.Acitvity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.joker.cosmos_android.Adapter.AlgorithmAdapter;
import com.example.joker.cosmos_android.Adapter.TabPagerAdapter;
import com.example.joker.cosmos_android.Database.Algorithms;
import com.example.joker.cosmos_android.Database.SubAlgorithms;
import com.example.joker.cosmos_android.R;
import com.example.joker.cosmos_android.Utils.AlgorithmsClickListener;
import com.example.joker.cosmos_android.ViewModel.AlgorithmsViewModel;
import com.example.joker.cosmos_android.ViewModel.UserModel;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.data.model.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.List;

public class AlgorithmsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabPagerAdapter tabPagerAdapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference userRef;

    //    authenticator provider
    List<AuthUI.IdpConfig> providers = Arrays.asList(
            new AuthUI.IdpConfig.GoogleBuilder().build()
    );
    private FirebaseAuth firebaseAuth;

    //    user
    private FirebaseUser user;


    //    auth state listener
    private FirebaseAuth.AuthStateListener authStateListener;

    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //   button=(SignInButton)findViewById(R.id.login_with_google).setOnClickListener(this);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(false);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.pager);
        tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), this);
        tabPagerAdapter.addFragment(new Tab1(), "TAB1");
        tabPagerAdapter.addFragment(new Tab2(), "TAB2");
        tabPagerAdapter.addFragment(new Tab3(), "TAB3");
        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setColor(R.color.cyan_600, R.color.cyan_800);      //default color
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        userRef = firebaseDatabase.getReference("users");

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        setColor(R.color.cyan_600, R.color.cyan_800);
                        break;
                    case 1:
                        setColor(R.color.teal_500, R.color.teal_700);
                        break;
                    case 2:
                        setColor(R.color.cyan_600, R.color.cyan_800);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                user = firebaseAuth.getCurrentUser();


                if (user != null) {


                    // get user detail
                    String id = user.getUid();
                    String name = user.getDisplayName();
                    String email = user.getEmail();

                    String imgURL = user.getPhotoUrl() != null ? user.getPhotoUrl().toString() : null;

                    //create model
                    UserModel userModel = new UserModel(id, name, email, imgURL);

                    //add to firebase database
                    userRef.child(userModel.getId()).setValue(userModel);
                    userRef.push().setValue(userModel);

                } else {

                    // Create and launch sign-in intent

                    StartSignIn();
                }
            }
        };

    }

    private void setColor(int primary, int primaryDark) {

        toolbar.setBackgroundColor(ContextCompat.getColor(AlgorithmsActivity.this, primary));
        tabLayout.setBackgroundColor(ContextCompat.getColor(AlgorithmsActivity.this, primary));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(AlgorithmsActivity.this, primaryDark));
        }

    }


    private void StartSignIn() {

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
    }

    //        menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.signout:
                StartSignOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void StartSignOut() {

        AuthUI.getInstance()
                .signOut(AlgorithmsActivity.this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {

                        Toast.makeText(AlgorithmsActivity.this, "Succesfully Signed Out", Toast.LENGTH_SHORT).show();


                    }
                });

    }

    @Override
    protected void onPause() {
        super.onPause();

        firebaseAuth.removeAuthStateListener(authStateListener);

    }

    @Override
    protected void onResume() {
        super.onResume();

        firebaseAuth.addAuthStateListener(authStateListener);

    }


}
