package aoc3

import org.junit.jupiter.api.Test
import java.math.BigInteger
import kotlin.test.assertEquals

class Aoc3Test {

    val dataList = listOf(  "...#",
                            "..#.",
                            "...#",
                            "##.#",
                            "...#",
                            "###.")

    @Test
    fun shouldStripEndOfLine() {
        assertEquals('#', readFileAsLinesUsingUseLines("src/main/resources/dataInput_3.txt").first().last())
    }

    @Test
    fun shouldHaveTheRightAmountOfChars() {
        assertEquals(31, readFileAsLinesUsingUseLines("src/main/resources/dataInput_3.txt").first().length)
    }

    @Test
    fun stepShouldReturnCorrectElement() {
        assertEquals(1, performStep(3, 1, 0, 0, 0, dataList))
    }

    // Puzzle 2

    @Test
    fun shouldMultiplyAllPathResults() {
        val paths = listOf( Pair(1, 1),
                            Pair(3, 1))

        assertEquals(2, reduceResultsByMultiply(paths).toInt())
    }

    fun reduceResultsByMultiply(paths: List<Pair<Int, Int>>): BigInteger {
        return paths.map { performStep(it.first, it.second, 0, 0, 0, dataList).toBigInteger() }
            .reduce {acc, i -> acc*i}
    }

    @Test
    fun stepShouldReturnCorrectElementFor7_1() {
        assertEquals(1, performStep(7, 1, 0, 0, 0, dataList))
    }
}
