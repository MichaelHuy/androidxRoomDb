package com.identiv.myapplication.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.identiv.myapplication.R;
import com.identiv.myapplication.databinding.FragmentMainBinding;
import com.identiv.myapplication.recyclerview.MainActivityFragmentRecyclerViewAdapter;
import com.identiv.myapplication.viewmodel.BlogPostsViewModel;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FragmentMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        MainActivityFragmentRecyclerViewAdapter recyclerViewAdapter = new MainActivityFragmentRecyclerViewAdapter(new ArrayList<>());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerView.setAdapter(recyclerViewAdapter);

        BlogPostsViewModel viewModel = ViewModelProviders.of(this).get(BlogPostsViewModel.class);

        viewModel.getBlogPosts().observe(getViewLifecycleOwner(), recyclerViewAdapter::setBlogPosts);

        return binding.getRoot();
    }
}
