package com.igorwojda.matrix.spiralmatrixgenerator

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun generateSpiralMatrix(n: Int): List<MutableList<Int?>> {
    var top = 0
    var right = n - 1
    var bottom = n - 1
    var left = 0

    // Initialize matrix with 0 values
    val matrix = MutableList(n) {
        MutableList<Int?>(n) { 0 }
    }

    var count = 0

    // run this until matrix size is reached
    while (count < n * n) {
        // left to right traversing
        for (value in left .. right) {
            count ++
            matrix[top][value] = count
        }
        top ++

        // top to bottom traversing
        for (value in top .. bottom) {
            count ++
            matrix[value][right] = count
        }
        right --

        // right to left traversing
        for (value in right downTo left) {
            count ++
            matrix[bottom][value] = count
        }
        bottom --

        // returning from bottom to top and then check if count less than matrix size
        for (value in bottom downTo top) {
            count ++
            matrix[value][left] = count
        }
        left ++
    }

    return matrix
}

private class Test {
    @Test
    fun `generateSpiralMatrix generates a 2x2 matrix`() {
        val matrix = generateSpiralMatrix(2)
        matrix.size shouldBeEqualTo 2
        matrix[0] shouldBeEqualTo listOf(1, 2)
        matrix[1] shouldBeEqualTo listOf(4, 3)
    }

    @Test
    fun `generateSpiralMatrix generates a 3x3 matrix`() {
        val matrix = generateSpiralMatrix(3)
        matrix.size shouldBeEqualTo 3
        matrix[0] shouldBeEqualTo listOf(1, 2, 3)
        matrix[1] shouldBeEqualTo listOf(8, 9, 4)
        matrix[2] shouldBeEqualTo listOf(7, 6, 5)
    }

    @Test
    fun `generateSpiralMatrix generates a 4x4 matrix`() {
        val matrix = generateSpiralMatrix(4)
        matrix.size shouldBeEqualTo 4
        matrix[0] shouldBeEqualTo listOf(1, 2, 3, 4)
        matrix[1] shouldBeEqualTo listOf(12, 13, 14, 5)
        matrix[2] shouldBeEqualTo listOf(11, 16, 15, 6)
        matrix[3] shouldBeEqualTo listOf(10, 9, 8, 7)
    }
}
