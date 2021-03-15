package io.imrekaszab.algorithms.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import dagger.hilt.android.AndroidEntryPoint;
import io.imrekaszab.algorithms.BR;
import io.imrekaszab.algorithms.databinding.FragmentMainBinding;
import io.imrekaszab.algorithms.ui.adapter.AlgorithmsAdapter;
import io.imrekaszab.algorithms.viewmodel.MainViewModel;

@AndroidEntryPoint
public class MainFragment extends Fragment {
    private MainViewModel mainViewModel;
    private FragmentMainBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.setVariable(BR.vm, mainViewModel);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AlgorithmsAdapter adapter = new AlgorithmsAdapter();

        mainViewModel.getAlgorithms()
            .observe(getViewLifecycleOwner(), adapter::setItems);

        binding.mainRecyclerView.setAdapter(adapter);
    }
}
