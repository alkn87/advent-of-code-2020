package aoc5

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Aoc5Test {

    // Part 1

    @Test
    fun shouldParseIndicators() {
        assertEquals(44, convertIndicatorsToRowInteger("FBFBBFFRLR"))
        assertEquals(5, convertIndicatorsToColumnInteger("FBFBBFFRLR"))
        assertEquals(357, calculateSeatId("FBFBBFFRLR"))
    }

    @Test
    fun shouldConvertToSeatIdList() {
        val boardingPasses = listOf("FBFBBFFRLR", "BBFBBFFRLR")
        assertEquals(listOf(357, 108*8+5), createSeatIdList(boardingPasses))
    }

    @Test
    fun shouldGetHighestSeatId() {
        val boardingPasses = listOf("FBFBBFFRLR", "BBFBBFFRLR")
        assertEquals(108*8+5, getMaxSeatId(boardingPasses))
    }

    // Part 2
    @Test
    fun shouldGetFreeSeat() {
        val seatIds = listOf(1,2,5,245,247,300)
        assertEquals(246, getEmptySeatId(seatIds))
    }
}
