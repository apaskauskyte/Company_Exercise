package lt.ausra.company_exercise

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    val TAG = "company_tag"

    lateinit var company: Company
    lateinit var textListView: ListView
    lateinit var adapter: ArrayAdapter<Employee>
    lateinit var filteredListAdapter: ArrayAdapter<Employee>
    lateinit var editText: EditText
    lateinit var filterButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        company = Company()
        doAllEmployeesActions()
        setUpListView()
        setButtonCLickListener()
    }

    fun doAllEmployeesActions() {
        val employee01 = Employee("Arianna", "Huffington", "45007150001")
        company.addEmployee(employee01, "Chief Executive Officer", 15)
        employee01.display(TAG)

        val employee02 = Employee("Warren", "Buffett", "33008300002")
        company.addEmployee(employee02, "Finance Director", 12)
        employee02.display(TAG)

        val employee03 = Employee("Anna", "Wintour", "44911030003")
        company.addEmployee(employee03, "Marketing Director", 11)
        employee03.display(TAG)

        val employee04 = Employee("Bill", "Gates", "35510280004")
        company.addEmployee(employee04, "IT Director", 10)
        employee04.display(TAG)

        val employee05 = Employee("Jane", "Doe", "60012250005")
        company.addEmployee(employee05, "Analyst", 4)
        employee05.display(TAG)

        val employee06 = Employee("John", "Smith", "50201090006")
        company.addEmployee(employee06, "Office Manager", 3)
        employee06.display(TAG)
    }

    private fun setUpListView() {
        textListView = findViewById(R.id.textListView)
        adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, company.employeeList
        )
        textListView.adapter = adapter
    }

    private fun setButtonCLickListener() {
        editText = findViewById(R.id.editText)
        filterButton = findViewById(R.id.filterButton)

        filterButton.setOnClickListener {

            val yearsOfExperienceEntered = editText.text.toString().toInt()
            val filteredEmployeeList: MutableList<Employee> = mutableListOf()

            for (i in 0 until company.employeeList.size) {
                if (company.employeeList[i].experience >= yearsOfExperienceEntered) {
                    filteredEmployeeList.add(company.employeeList[i])
                }
            }

            filteredListAdapter = ArrayAdapter(
                this, android.R.layout.simple_list_item_1, filteredEmployeeList
            )

            textListView.adapter = filteredListAdapter
            filteredListAdapter.notifyDataSetChanged()
        }
    }
}