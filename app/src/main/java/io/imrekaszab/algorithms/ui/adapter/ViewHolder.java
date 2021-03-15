package io.imrekaszab.algorithms.ui.adapter;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    @NonNull
    private final ViewDataBinding binding;

    @NonNull
    public ViewDataBinding getBinding() {
        return binding;
    }

    public ViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        this.binding.executePendingBindings();
    }
}