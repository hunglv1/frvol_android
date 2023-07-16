package epita.exam.frvol.activities

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import epita.exam.frvol.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class RegistrationPersonalInfor : AppCompatActivity() {

    private lateinit var imgDob: ImageView
    private lateinit var txtDob: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_first)

        val autotextView = findViewById<AutoCompleteTextView>(R.id.genders)
        val languages = resources.getStringArray(R.array.genders)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)
        autotextView.setAdapter(adapter)

        imgDob = findViewById<ImageView>(R.id.img_dob)
        txtDob = findViewById<EditText>(R.id.edt_dob)
        val myCalendar = Calendar.getInstance()
        val currentYear = myCalendar.get(Calendar.YEAR)
        val startYear = currentYear - 100

        val datePicker = DatePickerDialog.OnDateSetListener { _, i, i2, i3 ->
            myCalendar.set(Calendar.YEAR, i)
            myCalendar.set(Calendar.MONDAY, i2)
            myCalendar.set(Calendar.DAY_OF_MONTH, i3)
            updateLabel(myCalendar)
        }

        imgDob.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this, datePicker, myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            )

            // Set the minimum date to startYear
            datePickerDialog.datePicker.minDate = getMillisFromYearMonthDay(startYear, 0, 1)
            datePickerDialog.show()
        }

        val btnNext = findViewById<Button>(R.id.btn_pi_next)
        btnNext.setOnClickListener {
            val intent = Intent(this, RegistrationSituation::class.java)
            startActivity(intent)
        }
    }

    private fun updateLabel(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        txtDob.setText(sdf.format(myCalendar.time))
    }

    private fun getMillisFromYearMonthDay(year: Int, month: Int, dayOfMonth: Int): Long {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth, 0, 0, 0)
        return calendar.timeInMillis
    }
}