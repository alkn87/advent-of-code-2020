package aoc1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Aoc1test {
    @Test
    fun twoNumbersShouldEqual2020() {
        assertEquals(equals2020(2010, 10), true)
    }

    @Test
    fun sumOfTwoExistsTest() {
        assertEquals(sumsToTarget(intArrayOf(1,3,7), 8), intArrayOf(1,7).asList())
        assertEquals(sumsToTarget(intArrayOf(1,3,7), 9), intArrayOf().asList())
    }

    @Test
    fun multiplyListTest() {
        assertEquals(multiplyList(listOf(1,2,3,4)), 24)
    }

    @Test
    fun sumOfThreeExistsTest() {
        assertEquals(sums3ToTarget(intArrayOf(1,3,4,7),8), intArrayOf(1,3,4).asList())
        assertEquals(sums3ToTarget(intArrayOf(1,5,7,13,20),13), intArrayOf(1,5,7).asList())
        assertEquals(sums3ToTarget(intArrayOf(1,3,4,5,6),15), intArrayOf(4,5,6).asList())
        assertEquals(sums3ToTarget(intArrayOf(1,3,4,8),8), intArrayOf(1,3,4).asList())
        assertEquals(sums3ToTarget(intArrayOf(1,2,4,8),8), intArrayOf().asList())
    }
}
