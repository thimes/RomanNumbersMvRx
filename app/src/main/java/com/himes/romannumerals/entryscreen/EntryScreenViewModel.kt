package com.himes.romannumerals.entryscreen

import android.view.View
import com.himes.romannumerals.models.RomanNumeral
import com.himes.romannumerals.models.RomanValue

class EntryScreenViewModel(
    var romanNumeral: RomanNumeral
) {
    constructor(string: String) : this(RomanNumeral(string))

    fun addValueClicked(newValue: RomanValue) = View.OnClickListener {
        add(newValue)
    }

    fun deleteLast() = View.OnClickListener {
        romanNumeral = RomanNumeral(romanNumeral.numeral.dropLast(1))
    }

    fun add(newValue: RomanValue) {
        romanNumeral = romanNumeral.addValue(newValue)
    }

    fun canAdd(value: RomanValue) : Boolean {
        try {
            RomanNumeral(romanNumeral.numeral + value.name.toUpperCase())
        } catch (exception: Exception) {
            return false
        }
        return true
    }
}
