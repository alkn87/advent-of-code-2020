package aoc5

import java.io.File
import kotlin.math.pow

fun main() {
    val dataList = readFileAsLinesUsingUseLines("src/main/resources/dataInput_5.txt")

    // Part 1
    println(getMaxSeatId(dataList))

    // Part 2
    println(getEmptySeatId(createSeatIdList(dataList)))

}

fun readFileAsLinesUsingUseLines(fileName: String): List<String> {
    return File(fileName).useLines { it.toList() }
}

// Part 1

fun convertIndicatorsToRowInteger(seatLocation: String): Int {
    val row = seatLocation.substring(0,7).reversed()
    var rowValue = 0
    row.forEachIndexed { index, element ->
        run {
            if (element == 'B') {
                rowValue += 2.toDouble().pow(index).toInt()
            }
        }
    }
    return rowValue
}

fun convertIndicatorsToColumnInteger(seatLocation: String): Int {
    val column = seatLocation.substring(7).reversed()
    var columnValue = 0
    column.forEachIndexed { index, element ->
        run {
            if (element == 'R') {
                columnValue += 2.toDouble().pow(index).toInt()
            }
        }
    }
    return columnValue
}

fun calculateSeatId(seatLocation: String): Int {
    return convertIndicatorsToColumnInteger(seatLocation) +
            (8 * convertIndicatorsToRowInteger(seatLocation))
}

fun createSeatIdList(boardingPasses: List<String>): List<Int> {
    return boardingPasses.map { calculateSeatId(it) }
}

fun getMaxSeatId(boardingPasses: List<String>): Int? {
    return createSeatIdList(boardingPasses).maxOrNull()
}

// Part 2

fun getEmptySeatId(seatIds: List<Int>): Int {
    val seatIdHashSet: HashSet<Int> = HashSet()
    seatIdHashSet.addAll(seatIds)
    for (element in seatIds) {
        if (seatIdHashSet.contains(element) &&
            seatIdHashSet.contains(element+2) &&
            !seatIdHashSet.contains(element+1)) {
            return element+1
        }
    }
    return 0
}
