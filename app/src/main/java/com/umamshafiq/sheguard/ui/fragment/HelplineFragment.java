package com.umamshafiq.sheguard.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.umamshafiq.sheguard.R;
import com.umamshafiq.sheguard.databinding.FragmentHelplineBinding;
import com.umamshafiq.sheguard.model.HelplineModel;
import com.umamshafiq.sheguard.ui.adapter.HelplineAdapter;

import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class HelplineFragment extends Fragment {

    private final ArrayList<HelplineModel> helplines = new ArrayList<>();
    private FragmentHelplineBinding binding;
    private HelplineAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHelplineBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        ((AppCompatActivity) requireActivity()).setSupportActionBar(binding.header.toolbar);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            binding.header.collapsingToolbar.setTitle(getString(R.string.activity_helpline_title));
            binding.header.collapsingToolbar.setSubtitle(getString(R.string.activity_helpline_desc));
        }

        helplines.add(new HelplineModel(
                getString(R.string.helpline_name1),
                getString(R.string.helpline_num1)
        ));
        helplines.add(new HelplineModel(
                getString(R.string.helpline_name2),
                getString(R.string.helpline_num2)
        ));
        helplines.add(new HelplineModel(
                getString(R.string.helpline_name3),
                getString(R.string.helpline_num3)
        ));

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new HelplineAdapter(requireContext(), helplines);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        return view;
    }
}