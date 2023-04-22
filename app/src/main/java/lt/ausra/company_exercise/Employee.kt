package lt.ausra.company_exercise

import java.time.LocalDate
import java.time.Period

class Employee(
    val firstName: String,
    val lastName: String,
    val personalId: String,
) {

    var age: Int = 0
        private set

    var position: String = ""

    var experience: Int = 0

    lateinit var birthDate: String

    fun getBirthDateFromPersonalId() {

        val birthYearEnding = personalId.substring(1, 3)
        val monthOfBirth = personalId.substring(3, 5)
        val dayOfBirth = personalId.substring(5, 7)

        val birthDateWithoutCentury = "$birthYearEnding-$monthOfBirth-$dayOfBirth"

        if (personalId[0] == '3' || personalId[0] == '4') {
            birthDate = "19$birthDateWithoutCentury"
        } else if (personalId[0] == '5' || personalId[0] == '6') {
            birthDate = "20$birthDateWithoutCentury"
        }
    }

    private fun countAge(): Int {

        val birthDay = LocalDate.parse(birthDate)
        return Period.between(
            birthDay,
            LocalDate.now()
        ).years
    }
}