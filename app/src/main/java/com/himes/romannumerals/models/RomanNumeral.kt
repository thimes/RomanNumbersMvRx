package com.himes.romannumerals.models

class RomanNumeral(val numeral: String) {

    fun intValue(): Int = numeral.fold(RomanSum.Initial) { roman, char ->
        with(RomanValue.valueOf(char.toString())) {
            roman.copy(
                last = this, total = if (roman.last.ordinal < ordinal) {
                    roman.total - (2 * roman.last.arabicValue) + arabicValue
                } else {
                    roman.total + arabicValue
                }
            )
        }
    }.total

    private data class RomanSum(
        val last: RomanValue,
        val total: Int
    ) {
        companion object {
            val Initial = RomanSum(RomanValue.ZERO, 0)
        }
    }
}