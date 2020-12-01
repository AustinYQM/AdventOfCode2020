import java.util.*
fun main(){
    val expenses: MutableList<Int> = Helper.returnInts("day1")
    val runner = DayOne()
    runner.PartOne(expenses)
    runner.PartTwo(expenses)
}

class DayOne {

    fun PartTwo(expenses: MutableList<Int>) {
        println("::::: Part Two :::::")
        for (a in expenses) {
            for (b in expenses) {
                for (c in expenses) {
                    if (a + b + c == 2020) {
                        println("Number 1: $a")
                        println("Number 2: $b")
                        println("Number 3: $c")
                        println("Answer: " + a * b * c)
                        println("")
                        return
                    }
                }
            }
        }
    }

    fun PartOne(expenses: MutableList<Int>) {
        println("::::: Part One :::::")
        for (a in expenses) {
            for (b in expenses) {
                if (a + b == 2020) {
                    println("Number 1: $a")
                    println("Number 2: $b")
                    println("Answer: " + a * b)
                    println()
                    return
                }
            }
        }
    }
}