package za.ac.iie.bursaryapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    enum class Programme {
        IT,
        EDUCATION,
        ENGINEERING,
        NURSING,
        BUSINESS
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNumber1 = findViewById<EditText>(R.id.etNumber1)
        val etNumber2 = findViewById<EditText>(R.id.etNumber2)
        val etNumber3 = findViewById<EditText>(R.id.etNumber3)
        val switch1   = findViewById<Switch>(R.id.switch1)
        val checkbox  = findViewById<CheckBox>(R.id.checkBox)

        val spinner   = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = ArrayAdapter<MainActivity.Programme>(this, android.R.layout.simple_list_item_activated_1,
            Programme.values())

        val btn1      = findViewById<Button>(R.id.btn1)
        val tvResult  = findViewById<TextView>(R.id.textView2)

        val name = etNumber1.text.toString()
        val age  = etNumber2.text.toString()
        val mark = etNumber3.text.toString()
        val empty = ""

        btn1.setOnClickListener {
            var message = ""
            if (name.isEmpty() || age.isEmpty() || mark.isEmpty()) {
                tvResult = "Fill in all Fields"


            }else {
                val ageValue = age.toInt()
                val avgValue = mark.toInt()
                val returning = switch1.isChecked
                val terms = checkbox.isChecked
                val prog = spinner.selectedItem as Programme

                if (!terms){
                    tvResult.text = "You need to accept bursary terms"
                }else {
                    if (ageValue >= 18 &&
                        (avgValue >= 70 || (avgValue >= 65.0 && returning)))


                    }



                }
            }
        }
    }
}