package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import androidx.core.view.get
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var premiumModel: PremiumModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        premiumModel = ViewModelProviders.of(this).get(PremiumModel::class.java)

        display()



        buttonCalculate.setOnClickListener(){
            textViewPremium.text = getPremium().toString()
        }

        buttonReset.setOnClickListener(){
            spinnerAge.setSelection(0)
            radioGroupGender.clearCheck()
            checkBox.setChecked(false)

        }
    }

    fun display(){
        textViewPremium.text = premiumModel.premium.toString()
    }


    fun getPremium():Double{
        return when(spinnerAge.selectedItemPosition){
            0 -> 60.00
            1 -> 70.00 +
                    (if(radioButtonMale.isChecked) 50.00 else 0.0) +
                    (if(checkBox.isChecked) 100.00 else 0.0)
            2 ->90.00 +
                    (if(radioButtonMale.isChecked) 100.00 else 0.0) +
                    (if(checkBox.isChecked) 150.00 else 0.0)
            3 ->120.00 +
                    (if(radioButtonMale.isChecked) 150.00 else 0.0) +
                    (if(checkBox.isChecked) 200.00 else 0.0)
            4 ->150.00 +
                    (if(radioButtonMale.isChecked) 200.00 else 0.0) +
                    (if(checkBox.isChecked) 250.00 else 0.0)
            5 ->150.00 +
                    (if(radioButtonMale.isChecked) 200.00 else 0.0) +
                    (if(checkBox.isChecked) 300.00 else 0.0)
            else -> 0.0
        }
    }
}
