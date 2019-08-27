package com.himes.romannumerals.resultscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.himes.romannumerals.databinding.ResultFragmentBinding
import com.himes.romannumerals.entryscreen.NumberConversionViewModel

class ResultFragment : BaseMvRxFragment(), ResultScreenHandler {
    private val viewModel: NumberConversionViewModel by activityViewModel()

    lateinit var binding : ResultFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = ResultFragmentBinding.inflate(inflater, container, false)
        binding.handler = this
        return binding.root
    }

    override fun goBack() = findNavController().popBackStack()

    override fun invalidate() = withState(viewModel) { state ->
        binding.state = state
    }
}

interface ResultScreenHandler {
    fun goBack(): Boolean
}
