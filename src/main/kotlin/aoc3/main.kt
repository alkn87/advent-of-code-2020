package aoc3

import java.io.File

fun main () {
    val dataList = readFileAsLinesUsingUseLines("src/main/resources/dataInput_3.txt")

    // Puzzle 1
    val result = performStep(3, 1, 0, 0, 0, dataList)
    println(result)

    // Puzzle 2
    val paths = listOf( Pair(1, 1),
                        Pair(3, 1),
                        Pair(5, 1),
                        Pair(7, 1),
                        Pair(1, 2))

    // Danger! Take care of integer overflows!
    val result2 = paths
        .map { performStep(it.first, it.second, 0, 0, 0, dataList).toBigInteger() }
        .reduce {acc, i -> acc*i}
    println(result2)
}

fun readFileAsLinesUsingUseLines(fileName: String): List<String> {
    return File(fileName).useLines { it.toList() }
}

fun performStep(xStep: Int, yStep: Int, x: Int, y: Int, count: Int, dataList: List<String>): Int {
    if (y+yStep > dataList.size - 1) return count
    val lineLenght = dataList.first().length
    val field = dataList[y+yStep][(x+xStep) % lineLenght]
    var found = 0
    if (field == '#') {
        found = 1
    }
    return performStep(xStep, yStep, x+xStep, y+yStep, count+found, dataList)
}
