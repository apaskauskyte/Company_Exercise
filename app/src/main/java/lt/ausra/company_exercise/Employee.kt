package lt.ausra.company_exercise

import android.util.Log
import java.time.LocalDate
import java.time.Period

class Employee(
    val firstName: String,
    val lastName: String,
    val personalId: String,
) {

    init {
        getBirthDateFromPersonalId()
        countAge()
    }

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

    private fun countAge() {
        val birthDay = LocalDate.parse(birthDate)
        age = Period.between(
            birthDay,
            LocalDate.now()
        ).years
    }

    fun display(TAG: String) {
        Log.i(
            TAG,
            "Employee: %s %s, birth day: %s, age: %s, position: %s, experience: %s".format(
                this.firstName,
                this.lastName,
                this.birthDate,
                this.age,
                this.position,
                this.experience
            )
        )
    }

    override fun toString(): String {
        return "Employee: $firstName $lastName \nBirth date: $birthDate \nAge: $age " +
                " \nPosition: $position \nExperience: $experience years"
    }
}