package io.imrekaszab.algorithms.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.imrekaszab.algorithms.BR
import io.imrekaszab.algorithms.R
import io.imrekaszab.algorithms.databinding.FragmentDetailsBinding
import io.imrekaszab.algorithms.viewmodel.DetailsViewModel

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_main) {

    private val detailsViewModel by viewModels<DetailsViewModel>()

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.setVariable(BR.vm, detailsViewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()

        return binding.root
    }
}