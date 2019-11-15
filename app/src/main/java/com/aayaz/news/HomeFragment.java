package com.aayaz.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aayaz.news.database.tables.Fact;
import com.aayaz.news.database.tables.FactAdapter;
import com.aayaz.news.viewModels.ListFagmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ListFagmentViewModel mViewModel;
    private FactAdapter factAdapter;

    private List<Fact> facts = new ArrayList<>();

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initViewModel();

        mRecyclerView = view.findViewById(R.id.mRecyclerView);
        initRecyclerView();

        return view;
    }

    private void initRecyclerView() {
        mRecyclerView.hasFixedSize();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
    }

    /**
     * intialize viewmodel and observe the fact data
     * Any changes in database observer will call onChange method
     */
    private void initViewModel() {

        Observer<List<Fact>> factObserver = new Observer<List<Fact>>() {
            @Override
            public void onChanged(List<Fact> facts) {
                if (facts != null) {
                    HomeFragment.this.facts.clear();
                    HomeFragment.this.facts.addAll(facts);
                    if (factAdapter == null) {
                        factAdapter = new FactAdapter(getActivity(), HomeFragment.this.facts);
                        mRecyclerView.setAdapter(factAdapter);
                    } else {
                        factAdapter.notifyDataSetChanged();
                    }
                }
            }
        };

        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ListFagmentViewModel.class);

        mViewModel.getFacts().observe(getActivity(), factObserver);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
