package aoc6

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Aoc6Test {

    // Part 1

    @Test
    fun shouldCreateGroups() {
        assertEquals(5, readFileAsString("src/test/kotlin/aoc6/dataInput6Test.txt").split("\n\n").count())
    }

    @Test
    fun shouldCreateSumOfAnswersPerGroup() {
        val groups = readFileAsString("src/test/kotlin/aoc6/dataInput6Test.txt").split("\n\n")
        assertEquals(setOf('a','b','c'), createSetFromGroup(groups[0]))
        assertEquals(setOf('a','b','c'), createSetFromGroup(groups[1]))
        assertEquals(setOf('a','b','c'), createSetFromGroup(groups[2]))
        assertEquals(setOf('a'), createSetFromGroup(groups[3]))
        assertEquals(setOf('b'), createSetFromGroup(groups[4]))
    }

    @Test
    fun shouldCountNumberOfGroupAnswers() {
        val groups = readFileAsString("src/test/kotlin/aoc6/dataInput6Test.txt").split("\n\n")
        assertEquals(3, countAnswersPerGroup(createSetFromGroup(groups[0])))
        assertEquals(3, countAnswersPerGroup(createSetFromGroup(groups[1])))
        assertEquals(3, countAnswersPerGroup(createSetFromGroup(groups[2])))
        assertEquals(1, countAnswersPerGroup(createSetFromGroup(groups[3])))
        assertEquals(1, countAnswersPerGroup(createSetFromGroup(groups[4])))
    }

    @Test
    fun shouldCountTotalNumberOfAnswers() {
        val groups = readFileAsString("src/test/kotlin/aoc6/dataInput6Test.txt").split("\n\n")
        assertEquals(11, countTotalAnswers(groups))
    }

    // Part 2

    @Test
    fun shouldCountUniqueAnswersPerGroup() {
        val groups = readFileAsString("src/test/kotlin/aoc6/dataInput6Test.txt").split("\n\n")
        assertEquals(3, countUniqueAnswersPerGroup(groups[0]))
        assertEquals(1, countUniqueAnswersPerGroup(groups[2]))
        assertEquals(1, countUniqueAnswersPerGroup(groups[4]))
    }

    @Test
    fun shouldCountTotalUniqueAnswers() {
        val groups = readFileAsString("src/test/kotlin/aoc6/dataInput6Test.txt").split("\n\n")
        assertEquals(6, countTotalUniqueAnswers(groups))
    }
}
