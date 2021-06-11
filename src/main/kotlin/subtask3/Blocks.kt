package subtask3

import java.lang.IllegalArgumentException
import java.lang.StringBuilder
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.reflect.KClass

class Blocks {

    private fun getLastDate(blockA: Array<*>): String {
        val maxDate = blockA.filterIsInstance<LocalDate>().max()
        return (maxDate!!).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
    }

    // TODO: Complete the following function
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        return when (blockB) {
            String::class -> blockA.filterIsInstance<String>().joinToString("")
            Int::class -> blockA.filterIsInstance<Int>().sum()
            LocalDate::class -> getLastDate(blockA)
            else -> throw IllegalArgumentException("there is no such class")
        }
    }
}
