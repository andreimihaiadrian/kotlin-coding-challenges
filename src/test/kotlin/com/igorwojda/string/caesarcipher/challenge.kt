package com.igorwojda.string.caesarcipher

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun encodeCaesarCipher(str: String, shift: Int): String {

    // Convert temporary from char to int to perform operations (shifting)
    val aInt = 'a'.toInt()
    val zInt = 'z'.toInt()

    var result = mutableListOf<Char>()

    str.forEach {
        var code = it.toInt()
        // shifting number to the right
        code += (shift % (zInt - aInt + 1))

        // if char exceeds the final char, 'z', we add the remainder from the beggining
        if (code > zInt ) {
            code = (code % zInt ) + aInt - 1
        }
        // convert back to char and insert into a new list
        result.add(code.toChar())
    }

    return result.joinToString(separator = "")
}

private class Test {
    @Test
    fun `"abc" with shift 1 return "bcd"`() {
        encodeCaesarCipher("abc", 1) shouldBeEqualTo "bcd"
    }

    @Test
    fun `"abcdefghijklmnopqrstuvwxyz" shift 1 returns "bcdefghijklmnopqrstuvwxyza"`() {
        encodeCaesarCipher(
            "abcdefghijklmnopqrstuvwxyz",
            1
        ) shouldBeEqualTo "bcdefghijklmnopqrstuvwxyza"
    }

    @Test
    fun `"abcdefghijklmnopqrstuvwxyz" shift 7 returns "hijklmnopqrstuvwxyzabcdefg"`() {
        encodeCaesarCipher(
            "abcdefghijklmnopqrstuvwxyz",
            7
        ) shouldBeEqualTo "hijklmnopqrstuvwxyzabcdefg"
    }

    @Test
    fun `"abcdefghijklmnopqrstuvwxyz" shift 50 returns "yzabcdefghijklmnopqrstuvwx"`() {
        encodeCaesarCipher(
            "abcdefghijklmnopqrstuvwxyz",
            50
        ) shouldBeEqualTo "yzabcdefghijklmnopqrstuvwx"
    }
}
