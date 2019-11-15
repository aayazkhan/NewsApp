package com.aayaz.news;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.aayaz.news.database.tables.Title;
import com.aayaz.news.network.Networkstate;
import com.aayaz.news.viewModels.DownloadDataViewModel;

public class MainActivity extends AppCompatActivity {

    private DownloadDataViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViewModel();

        if (Networkstate.haveNetworkConnection(getApplication())) {
            mViewModel.downloadData();
        }

        HomeFragment homeFragment = HomeFragment.newInstance();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.content, homeFragment);
        fragmentTransaction.commit();

    }

    private void initViewModel() {

        Observer<Title> titleObserver = new Observer<Title>() {
            @Override
            public void onChanged(Title title) {
                if (title != null) {
                    setTitle(title.getTitle());
                }
            }
        };

        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(DownloadDataViewModel.class);
        mViewModel.getTitle().observe(MainActivity.this, titleObserver);

    }


}
