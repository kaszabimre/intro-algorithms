package io.imrekaszab.algorithms.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import io.imrekaszab.algorithms.BR
import io.imrekaszab.algorithms.R
import io.imrekaszab.algorithms.data.model.Algorithm
import io.imrekaszab.algorithms.data.model.item.AlgorithmItemModel
import io.imrekaszab.algorithms.data.model.item.ItemModel
import io.imrekaszab.algorithms.data.model.item.SectionAlgorithmItemModel
import io.imrekaszab.algorithms.utils.command.ItemAction
import io.imrekaszab.algorithms.utils.command.ItemActionProvider
import java.util.ArrayList

class AlgorithmsAdapter : RecyclerView.Adapter<AlgorithmsAdapter.ViewHolder>(), ItemActionProvider<Algorithm> {
    private val items: MutableList<ItemModel> = ArrayList()
    private var itemClickedListener: ItemAction<Algorithm>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = items[position]

        if (model is AlgorithmItemModel) {
            holder.itemView.setOnClickListener {
                itemClickedListener?.invoke(model.algorithm)
            }
        }

        val binding = holder.binding
        binding.setVariable(BR.model, model)
        binding.executePendingBindings()
    }

    override fun getItemViewType(position: Int): Int = when (items[position]) {
        is SectionAlgorithmItemModel -> R.layout.view_main_section_item
        is AlgorithmItemModel -> R.layout.view_main_item
        else -> super.getItemViewType(position)
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: ArrayList<ItemModel>?) {
        this.items.clear()
        this.items.addAll(items!!)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.executePendingBindings()
        }
    }

    override fun setOnItemClickedAction(action: ItemAction<Algorithm>?) {
        this.itemClickedListener = action
    }
}
