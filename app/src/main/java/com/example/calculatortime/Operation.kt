package com.example.calculatortime

class Operation(private var first: String, private var second: String) {
    fun hourIndex(): Int {
        val charArray = first.toCharArray()
        var hour = 0
        var hourFound = false
        for (i in charArray.indices) {
            if (charArray[i] == 'h') {
                hour = i
                hourFound = true
            }
        }
        return if (hourFound) hour else 0
    }

    fun hourIndex2(): Int {
        val charArray = second.toCharArray()
        var hour = 0
        var hourFound = false
        for (i in charArray.indices) {
            if (charArray[i] == 'h') {
                hour = i
                hourFound = true
            }
        }
        return if (hourFound) hour else 0
    }

    fun minuteIndex(): Int {
        val charArray = first.toCharArray()
        var minute = 0
        var minuteFound = false
        for (i in charArray.indices) {
            if (charArray[i] == 'm') {
                minute = i
                minuteFound = true
            }
        }
        return if (minuteFound) minute else 0
    }

    fun minuteIndex2(): Int {
        val charArray = second.toCharArray()
        var minute = 0
        var minuteFound = false
        for (i in charArray.indices) {
            if (charArray[i] == 'm') {
                minute = i
                minuteFound = true
            }
        }
        return if (minuteFound) minute else 0
    }

    fun secondIndex(): Int {
        val charArray = first.toCharArray()
        var second = 0
        var secondFound = false
        for (i in charArray.indices) {
            if (charArray[i] == 's') {
                second = i
                secondFound = true
            }
        }
        return if (secondFound) second else 0
    }

    fun secondIndex2(): Int {
        val charArray = second.toCharArray()
        var second = 0
        var secondFound = false
        for (i in charArray.indices) {
            if (charArray[i] == 's') {
                second = i
                secondFound = true
            }
        }
        return if (secondFound) second else 0
    }

    fun convertToSecond(): Int {
        val charArray = first.toCharArray()
        val hourIndex = hourIndex()
        val minuteIndex = minuteIndex()
        val secondIndex = secondIndex()
        var hour: String = ""
        var minute: String = ""
        var second: String = ""

        if (hourIndex != 0 && hourIndex > 0) {
            for (i in 0..<hourIndex) {
                hour += charArray[i]
            }
        } else hour = "0"

        if (minuteIndex != 0 && minuteIndex > 0) {
            if (charArray.contains('h')) {
                for (i in hourIndex + 1..<minuteIndex) {
                    minute += charArray[i]
                }
            } else {
                for (i in 0..<minuteIndex) {
                    minute += charArray[i]
                }
            }
        } else minute = "0"

        if (secondIndex != 0 && secondIndex > 0) {
            if (charArray.contains('m')) {
                for (i in minuteIndex + 1..<secondIndex) {
                    second += charArray[i]
                }
            } else {
                for (i in 0..<secondIndex) {
                    second += charArray[i]
                }
            }
        } else second = "0"
        val sumHMS = (hour.toInt() * 60 * 60) + (minute.toInt() * 60) + second.toInt()
        return sumHMS
    }

    fun convertToSecond2(): Int {
        val charArray = second.toCharArray()
        val hourIndex = hourIndex2()
        val minuteIndex = minuteIndex2()
        val secondIndex = secondIndex2()
        var hour: String = ""
        var minute: String = ""
        var second: String = ""

        if (hourIndex != 0 && hourIndex > 0) {
            for (i in 0..<hourIndex) {
                hour += charArray[i]
            }
        } else hour = "0"

        if (minuteIndex != 0 && minuteIndex > 0) {
            if (charArray.contains('h')) {
                for (i in hourIndex + 1..<minuteIndex) {
                    minute += charArray[i]
                }
            } else {
                for (i in 0..<minuteIndex) {
                    minute += charArray[i]
                }
            }
        } else minute = "0"

        if (secondIndex != 0 && secondIndex > 0) {
            if (charArray.contains('m')) {
                for (i in minuteIndex + 1..<secondIndex) {
                    second += charArray[i]
                }
            } else {
                for (i in 0..<secondIndex) {
                    second += charArray[i]
                }
            }
        } else second = "0"
        val sumHMS = (hour.toInt() * 60 * 60) + (minute.toInt() * 60) + second.toInt()
        return sumHMS
    }

    fun sumFirstSecond(): String {
        val firstValue = convertToSecond()
        val secondValue = convertToSecond2()
        val sum = firstValue + secondValue
        var hour = 0
        var minute = 0
        var seconds = 0
        var sumTime = "Время: "

        if (sum > 60) {
            if (sum > 3600) {
                hour = (sum / 3600)
                minute = ((sum - hour * 3600) / 60)
                seconds = (sum - hour * 3600 - minute * 60)
                sumTime = hour.toString() + "h" + minute.toString() + "m" + seconds.toString() + "s"
            } else {
                seconds = sum % 60
                minute = ((sum - seconds) / 60)
                sumTime = minute.toString() + "m" + seconds.toString() + "s"
            }
        } else {
            seconds = sum
            sumTime = sum.toString() + "s"
        }

        return sumTime
    }

    fun diffFirstSecond(): String {
        val firstValue = convertToSecond()
        val secondValue = convertToSecond2()
        val diff = firstValue - secondValue
        var hour = 0
        var minute = 0
        var seconds = 0
        var sumTime = ""

        if (diff > 60) {
            if (diff > 3600) {
                hour = (diff / 3600)
                minute = ((diff - hour * 3600) / 60)
                seconds = (diff - hour * 3600 - minute * 60)
                sumTime = hour.toString() + "h" + minute.toString() + "m" + seconds.toString() + "s"
            } else {
                seconds = diff % 60
                minute = ((diff - seconds) / 60)
                sumTime = minute.toString() + "m" + seconds.toString() + "s"
            }
        } else {
            seconds = diff
            sumTime = diff.toString() + "s"
        }
        return if (diff < 0) "Ошибка вычисления! Данные введены некорректно" else sumTime
    }
}