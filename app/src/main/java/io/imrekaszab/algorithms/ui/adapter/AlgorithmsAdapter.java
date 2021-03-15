package io.imrekaszab.algorithms.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.imrekaszab.algorithms.BR;
import io.imrekaszab.algorithms.R;
import io.imrekaszab.algorithms.model.item.AlgorithmItemModel;
import io.imrekaszab.algorithms.model.item.ItemModel;
import io.imrekaszab.algorithms.model.item.SectionAlgorithmItemModel;

public class AlgorithmsAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<ItemModel> items = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.getContext()),
            viewType,
            parent,
            false
        );

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel model = items.get(position);

        ViewDataBinding binding = holder.getBinding();
        binding.setVariable(BR.model, model);
        binding.executePendingBindings();
    }

    @Override
    public int getItemViewType(int position) {
        ItemModel item = items.get(position);

        if (item instanceof SectionAlgorithmItemModel) {
            return R.layout.view_main_section_item;
        } else if (item instanceof AlgorithmItemModel) {
            return R.layout.view_main_item;
        }

        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<ItemModel> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }
}


