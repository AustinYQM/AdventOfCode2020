import java.util.*
fun main(){
    val expenses: MutableList<Int> = Helper.returnInts("day1")
    val runner = DayOne()
    runner.partOne(expenses)
    runner.partTwo(expenses)
    runner.partOneAdvanced(expenses)
    runner.partTwoAdvanced(expenses)
}

class DayOne {

    fun partTwo(expenses: MutableList<Int>) {
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

    fun partOne(expenses: MutableList<Int>) {
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

    fun partOneAdvanced(expenses: MutableList<Int>) {
        println("::::: Part One Adv. :::::")
        for (a in expenses) {
            if ((2020-a) in expenses) {
                val b = 2020 - a
                println("Number 1: $a")
                println("Number 2: $b")
                println("Answer: " + a * b)
                println()
                return
            }
        }
    }

    fun partTwoAdvanced(expenses: MutableList<Int>) {
        println("::::: Part Two Adv. :::::")
        for (a in expenses) {
            for (b in expenses) {
                if ((2020-a-b) in expenses) {
                    val c = 2020 - (a + b)
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
}