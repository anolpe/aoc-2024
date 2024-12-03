fun main() {
    fun part1(input: List<String>): Int {
        val regex = Regex("mul\\((\\d+),(\\d+)\\)")
        return input.flatMap { line -> regex.findAll(line).map { it.groupValues } }
            .sumOf { it[1].toInt() * it[2].toInt() }
    }

    fun part2(input: List<String>): Int {
        var res = 0
        var isEnabled = true
        val regex = Regex("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)")
        val matched = input.flatMap { line -> regex.findAll(line).map { it.groupValues } }
        for (match in matched) {
            if (match[0] == "do()") isEnabled = true
            else if (match[0] == "don't()") isEnabled = false
            else if (isEnabled) res += match[1].toInt() * match[2].toInt()
        }
        return res
    }

    fun parseInput(input: List<String>): List<String> {
        return input
    }

    check(part1(listOf("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))")) == 161)
    check(part2(listOf("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))")) == 48)

    val input = parseInput(readInput("Day03"))
    part1(input).println()
    part2(input).println()
}
