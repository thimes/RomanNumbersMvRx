package com.himes.romannumerals.entryscreen

import com.himes.romannumerals.models.RomanValue

class EntryScreenViewModel(
    val romanNumeral: String = ""
) {

    fun add(newValue: RomanValue) {
        TODO("Implement this")
    }

    fun canAdd(value: RomanValue) : Boolean {
        return true
    }

}

