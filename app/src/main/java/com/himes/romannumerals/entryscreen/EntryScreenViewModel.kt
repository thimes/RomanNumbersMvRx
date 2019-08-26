package com.himes.romannumerals.entryscreen

import com.himes.romannumerals.models.RomanNumeral
import com.himes.romannumerals.models.RomanValue

class EntryScreenViewModel(
    var romanNumeral: RomanNumeral
) {
    constructor(string: String) : this(RomanNumeral(string))

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
