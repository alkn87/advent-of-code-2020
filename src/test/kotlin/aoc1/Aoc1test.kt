package aoc1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Aoc1test {

    // Test solution with nested loop:

    val testList = listOf(1,3,7,9) // find sum of pair for 8 -> 1,7

    @Test
    fun sumOfTwoExists_LoopTest(){
        assertEquals(listOf(1,7), getSumsToTarget(testList, 8))
    }

    private fun getSumsToTarget(testList: List<Int>, sum: Int): List<Int> {
        for (i in testList.indices) {
            for (j in testList.indices) {
                if (testList[i]+testList[j] == sum) return listOf(testList[i], testList[j])
            }
        }
        return listOf()
    }


    // Test solution with HashSet:

    @Test
    fun sumOfTwoExistsTest() {
        assertEquals(sumsToTarget(intArrayOf(1,3,7), 8), listOf(1,7))
        assertEquals(sumsToTarget(intArrayOf(1,3,7), 9), listOf<Int>())
    }

    @Test
    fun multiplyListTest() {
        assertEquals(multiplyList(listOf(1,2,3,4)), 24)
    }

    @Test
    fun sumOfThreeExistsTest() {
        assertEquals(sums3ToTarget(intArrayOf(1,3,4,7),8), listOf(1,3,4))
        assertEquals(sums3ToTarget(intArrayOf(1,5,7,13,20),13), listOf(1,5,7))
        assertEquals(sums3ToTarget(intArrayOf(1,3,4,5,6),15), listOf(4,5,6))
        assertEquals(sums3ToTarget(intArrayOf(1,3,4,8),8),listOf(1,3,4))
        assertEquals(sums3ToTarget(intArrayOf(1,2,4,8),8), listOf<Int>())
    }
}
