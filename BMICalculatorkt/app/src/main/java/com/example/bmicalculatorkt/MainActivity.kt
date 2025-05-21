package com.example.bmicalculatorkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculator.setOnClickListener {
            when {
                edtWeight.text.toString() != "" && edtHeightFt.text.toString() != "" && edtHeightIn.text.toString() != "" -> {

                    val wt = (edtWeight.text.toString()).toDouble()
                    val htFeet = (edtHeightFt.text.toString()).toDouble()
                    val htInch = (edtHeightIn.text.toString()).toDouble()

                    val totalInch = (htFeet*12) + htInch
                    val totalCM= totalInch*2.54
                    val totalM = totalCM/100

                    val bmi = wt/(totalM*totalM)
                    txtResult.text="${bmi.toInt()}"
                    txtTitle.text="Your BMI"
                    txtTitle.setTextColor(resources.getColor(R.color.white))
                    txtMsg.setTextColor(resources.getColor(R.color.white))

                    when {
                        bmi>25 -> {
                            Toast.makeText(this@MainActivity, R.string.strOverWt, Toast.LENGTH_LONG).show()
                            txtMsg.text = resources.getString(R.string.strOverWt)
                            llMain.setBackgroundColor(resources.getColor(R.color.cRed))
                        }
                        bmi<18 -> {
                            Toast.makeText(this@MainActivity, R.string.strUnderWt, Toast.LENGTH_LONG).show()
                            txtMsg.text = resources.getString(R.string.strUnderWt)
                            llMain.setBackgroundColor(resources.getColor(R.color.cYellow))
                        }
                        else -> {
                            Toast.makeText(this@MainActivity, R.string.strHealthy, Toast.LENGTH_LONG).show()
                            txtMsg.text = resources.getString(R.string.strHealthy)
                            llMain.setBackgroundColor(resources.getColor(R.color.cGreen))
                        }
                    }


                }
                else -> {
                    Toast.makeText(this@MainActivity, "Please fill all the entities", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}