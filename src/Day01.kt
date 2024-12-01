import kotlin.math.abs

fun main() {
    fun part1(input: Pair<List<Int>, List<Int>>): Int {
        return input.first.zip(input.second).sumOf { abs(it.first - it.second) }
    }

    fun part2(input: Pair<List<Int>, List<Int>>): Int {
        return input.first.fold(0) { sum, element -> sum + element * input.second.count { it == element } }
    }

    fun parseInput(input: List<String>): Pair<List<Int>, List<Int>> {
        val list1 = input.map { it.split("   ") }
            .map { it[0].toInt() }
            .sorted()
        val list2 = input.map { it.split("   ") }
            .map { it[1].toInt() }
            .sorted()
        return Pair(list1, list2)
    }

    val testInput = parseInput(readInput("Day01_test"))
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    val input = parseInput(readInput("Day01"))
    part1(input).println()
    part2(input).println()
}
