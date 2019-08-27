package com.himes.romannumerals.entryscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.PersistState
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.himes.romannumerals.databinding.FragmentEntryBinding
import com.himes.romannumerals.models.RomanNumeral
import com.himes.romannumerals.models.RomanValue
import com.himes.romannumerals.mvrx.MvRxViewModel

data class EntryScreenState(@PersistState val romanNumeral: RomanNumeral = RomanNumeral("")): MvRxState

class EntryScreenViewModel(
    entryScreenState: EntryScreenState
) : MvRxViewModel<EntryScreenState>(entryScreenState) {
    fun addValue(newValue: RomanValue) = setState { copy(romanNumeral = romanNumeral.addValue(newValue)) }
    fun delete() = setState { copy(romanNumeral = RomanNumeral(romanNumeral.numeral.dropLast(1))) }
}

class EntryScreenFragment: BaseMvRxFragment(), EntryScreenHandler {
    private lateinit var bindings: FragmentEntryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindings = FragmentEntryBinding.inflate(inflater, container, false)
        bindings.handler = this
        return bindings.root
    }

    val viewModel : EntryScreenViewModel by fragmentViewModel()

    override fun addValue(newValue: RomanValue) = viewModel.addValue(newValue)
    override fun deleteLast() = viewModel.delete()

    override fun invalidate() = withState(viewModel) { state ->
        bindings.state = state
    }
}

interface EntryScreenHandler {
    fun addValue(newValue: RomanValue)
    fun deleteLast()
}
