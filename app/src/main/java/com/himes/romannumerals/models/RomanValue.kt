package com.himes.romannumerals.models

enum class RomanValue(val arabicValue: Int) {
    ZERO(0),
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000)
}