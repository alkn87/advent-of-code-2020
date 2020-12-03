package aoc2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Aoc2test {
    private val testString = "1-3 a: abcde"
    private val testString2 = "4-5 b: dbbbl"


    @Test
    fun shouldParseWithRegex() {
        assertEquals(1, regGetMin(testString))
        assertEquals(3, regGetMax(testString))
        assertEquals('a', regGetChar(testString))
        assertEquals("abcde", regGetPass(testString))

        assertEquals(4, regGetMin(testString2))
        assertEquals(3, getCharacterOccurrence("dbbbl", 'b'))

        // Puzzle 2
        assertEquals(true, validateCharPositions(testString, 'a'))
        assertEquals(true, validateCharPositions(testString2, 'b'))
        assertEquals(false, validateCharPositions("2-9 c: ccccccccc", 'c'))
        assertEquals(false, validateCharPositions("1-3 b: cdefg", 'b'))
    }
}
