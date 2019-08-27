package com.himes.romannumerals.models

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test

class RomanNumeralTest {

    @Test
    fun `test one, two, and three`() {
        assertEquals(1, RomanNumeral("I").intValue())
        assertEquals(2, RomanNumeral("II").intValue())
        assertEquals(3, RomanNumeral("III").intValue())
    }

    @Test
    fun `test subtraction of higher values`() {
        assertEquals(4, RomanNumeral("IV").intValue())
        assertEquals(9, RomanNumeral("IX").intValue())
    }

    @Test
    fun `test addition to lower values`() {
        assertEquals(6, RomanNumeral("VI").intValue())
        assertEquals(11, RomanNumeral("XI").intValue())
    }

    @Test
    fun `test simple addition`() {
        //XX = 20 (both 10 values are added to the sum)
        assertEquals(20, RomanNumeral("XX").intValue())
    }

    @Test
    fun `test simple subtraction of smaller`() {
        //XL = 40 (since X is smaller, 10 is subtracted, then 50 is added for L)
        assertEquals(40, RomanNumeral("XL").intValue())
    }

    @Test
    fun `test simple addition of smaller`() {
        //LX = 60 (the values are in descending order, so both the 50 and the 10 are added)
        assertEquals(60, RomanNumeral("LX").intValue())
    }

    @Test
    fun `test tougher`() {
        //CXL = 140(since X is smaller than L, 10 is subtracted; 100 is added for C and 50 for L)
        assertEquals(140, RomanNumeral("CXL").intValue())
    }

    @Test
    fun `test invalid is rejected`() {
        var potentialException : Exception? = null
        try {
            RomanNumeral("BBQ")
        } catch (exception: Exception) {
            potentialException = exception
        }
        assertNotNull(potentialException)
    }

    @Test
    fun `test adding a value to the numeral doesnt change original`() {
        val original = RomanNumeral("X")
        val unoriginal = original.addValue(RomanValue.V)
        assertEquals(10, original.intValue())
        assertEquals(15, unoriginal.intValue())
    }

    @Test
    fun `test delete removes last value`() {
        val original = RomanNumeral("XI")
        assertEquals("X", original.delete())
    }
}