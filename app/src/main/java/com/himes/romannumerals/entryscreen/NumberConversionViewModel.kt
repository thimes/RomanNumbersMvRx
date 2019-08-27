package com.himes.romannumerals.entryscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.PersistState
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.himes.romannumerals.R
import com.himes.romannumerals.databinding.EntryFragmentBinding
import com.himes.romannumerals.models.RomanNumeral
import com.himes.romannumerals.models.RomanValue
import com.himes.romannumerals.mvrx.MvRxViewModel

data class NumberConversionState(@PersistState val romanNumeral: RomanNumeral = RomanNumeral("")): MvRxState

class NumberConversionViewModel(
    numberConversionState: NumberConversionState
) : MvRxViewModel<NumberConversionState>(numberConversionState) {
    fun addValue(newValue: RomanValue) = setState { copy(romanNumeral = romanNumeral.addValue(newValue)) }
    fun delete() = setState { copy(romanNumeral = RomanNumeral(romanNumeral.delete())) }
}

class EntryScreenFragment: BaseMvRxFragment(), EntryScreenHandler {
    private lateinit var binding: EntryFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = EntryFragmentBinding.inflate(inflater, container, false)
        binding.handler = this
        return binding.root
    }

    private val viewModel : NumberConversionViewModel by activityViewModel()

    override fun addValue(newValue: RomanValue) = viewModel.addValue(newValue)
    override fun deleteLast() = viewModel.delete()
    override fun convert() = findNavController().navigate(R.id.action_entryFragment_to_resultFragment)

    override fun invalidate() = withState(viewModel) { state ->
        binding.state = state
    }
}

interface EntryScreenHandler {
    fun addValue(newValue: RomanValue)
    fun deleteLast()
    fun convert()
}
