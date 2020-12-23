package aoc6

import java.io.File

fun main(){
    val content = readFileAsString("src/main/resources/dataInput_6.txt")
    val groups = content.split("\n\n")
    println(countTotalAnswers(groups))

    // Part 2

    println(countTotalUniqueAnswers(groups))
}

// Part 1

fun readFileAsString(fileName: String): String {
    return File(fileName).readText()
}

fun createSetFromGroup(group: String): Set<Char> {
    val answerSet = mutableSetOf<Char>()
    answerSet.addAll(group.replace("\\s".toRegex(),"").toSortedSet())
    return answerSet.toSet()
}

fun countAnswersPerGroup(groupSet: Set<Char>): Int {
    return groupSet.size
}

fun countTotalAnswers(groups: List<String>): Int {
    return groups
        .map { countAnswersPerGroup(createSetFromGroup(it)) }
        .reduce { acc, i -> acc+i }
}

// Part 2

fun countUniqueAnswersPerGroup(group: String): Int {
    return createSetFromGroup(group).filter {
            value -> group.split("\\s".toRegex()).map { it.contains(value) || it.isEmpty()}.reduce { acc, b -> acc && b }
    }.count()
}

fun countTotalUniqueAnswers(groups: List<String>): Int {
    return groups
        .map { countUniqueAnswersPerGroup(it) }
        .reduce { acc, i -> acc+i }
}
