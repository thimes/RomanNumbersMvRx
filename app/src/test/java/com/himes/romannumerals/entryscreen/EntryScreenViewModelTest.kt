package com.himes.romannumerals.entryscreen

import com.himes.romannumerals.models.RomanNumeral
import com.himes.romannumerals.models.RomanValue
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

class EntryScreenViewModelTest {
    @Test
    fun `test can add valid numeral`() {
        assertTrue(EntryScreenViewModel("X").canAdd(RomanValue.X))
    }

//    @Test
//    fun `test cannot add invalid numeral`() {
//        assertFalse(EntryScreenViewModel("II").canAdd(RomanValue.X))
//    }

    @Test
    fun `test adding changes the value`() {
        val model = EntryScreenViewModel("I")
        assertEquals(1, RomanNumeral(model.romanNumeral.numeral).intValue())
        model.add(RomanValue.I)
        assertEquals(2, RomanNumeral(model.romanNumeral.numeral).intValue())
    }
}