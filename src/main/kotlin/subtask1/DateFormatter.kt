package subtask1

import java.lang.IllegalArgumentException
import java.text.SimpleDateFormat
import java.util.*


class DateFormatter {
    private val message = "Такого дня не существует"
    private val mapNumberToMonth = mapOf<Int, String>(
        1 to "января",
        2 to "февраля",
        3 to "марта",
        4 to "апреля",
        5 to "мая",
        6 to "июня",
        7 to "июля",
        8 to "августа",
        9 to "сентября",
        10 to "октября",
        11 to "ноября",
        12 to "декабря"
    )

    private val mapNumberToWeekDay = mapOf<Int, String>(
        0 to "суббота",
        1 to "воскресенье",
        2 to "понедельник",
        3 to "вторник",
        4 to "среда",
        5 to "четверг",
        6 to "пятница"
    )

    private fun isValidDate(day: Int, month: Int, year: Int): Boolean {
        return when {
            day < 0 || day > 31 -> false
            month < 0 || month > 12 -> false
            year < 0 -> false
            month == 2 && day > 28 -> false
            else -> true
        }
    }

    fun toTextDay(day: String, month: String, year: String): String {
        if (!isValidDate(day.toInt(), month.toInt(), year.toInt())) {
            return message
        }

        val calendar = Calendar.getInstance()
        val date  = try {
            SimpleDateFormat("yyyy-MM-dd").parse("$year-$month-$day");
        } catch (e: IllegalArgumentException) {
            return message
        }
        calendar.time = date
        val dayOfWeek = calendar[Calendar.DAY_OF_WEEK]

        return "$day ${mapNumberToMonth[month.toInt()]}, ${mapNumberToWeekDay[dayOfWeek]}"
    }
}
