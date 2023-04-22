package lt.ausra.company_exercise

class Company(
    val companyName: String = "Ausra & Partners",
    val companyStartDate: String = "2010-03-08",
    var employeeList: MutableList<Employee> = mutableListOf()
) {

    fun addEmployee(employee: Employee, position: String, experience: Int) {
        employeeList.add(employee)
        employee.position = position
        employee.experience = experience
    }

}