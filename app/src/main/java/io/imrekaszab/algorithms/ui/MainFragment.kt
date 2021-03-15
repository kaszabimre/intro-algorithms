package io.imrekaszab.algorithms.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asFlow
import dagger.hilt.android.AndroidEntryPoint
import io.imrekaszab.algorithms.BR
import io.imrekaszab.algorithms.R
import io.imrekaszab.algorithms.databinding.FragmentMainBinding
import io.imrekaszab.algorithms.ui.adapter.AlgorithmsAdapter
import io.imrekaszab.algorithms.utils.viewLifecycleScope
import io.imrekaszab.algorithms.viewmodel.MainViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val mainViewModel by viewModels<MainViewModel>()

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.setVariable(BR.vm, mainViewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AlgorithmsAdapter()

        binding.mainRecyclerView.adapter = adapter

        mainViewModel.algorithms.asFlow()
            .onEach { adapter.setItems(it) }
            .launchIn(viewLifecycleScope)

    }
}