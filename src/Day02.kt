fun main() {
    fun isIncreasing(input: List<Int>): Boolean {
        return input.windowed(2).map { (first, second) -> first - second }.all { x -> x in 1..3 }
    }

    fun isDecreasing(input: List<Int>): Boolean {
        return input.windowed(2).map { (first, second) -> first - second }.all { x -> x in -3..-1 }
    }

    fun part1(input: List<List<Int>>): Int {
        return input.filter { isIncreasing(it) || isDecreasing(it) }.size
    }

    fun part2(input: List<List<Int>>): Int {
        val unsafe = input.filter { !isIncreasing(it) && !isDecreasing(it) }
        var res = 0
        for (i in unsafe.indices) {
            for (j in unsafe[i].indices) {
                val mutableList = unsafe[i].toMutableList()
                mutableList.removeAt(j)
                if (isIncreasing(mutableList) || isDecreasing(mutableList)) {
                    res += 1
                    break
                }
            }
        }
        return part1(input) + res
    }

    fun parseInput(input: List<String>): List<List<Int>> {
        return input
            .map { it.split(" ").map(String::toInt) }
    }

    val testInput = parseInput(readInput("Day02_test"))
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = parseInput(readInput("Day02"))
    part1(input).println()
    part2(input).println()
}
