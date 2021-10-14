package com.example.primaldroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.primaldroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{

    //TODO check this out
    private lateinit var binding: ActivityMainBinding
    private lateinit var dollarAmntEDTX: EditText
    private lateinit var convertBtn: Button
    private lateinit var displayTxt: TextView
    private var euroRate: Float = 0.86f

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //get instance of the binding class
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        dollarAmntEDTX = binding.editText;
        convertBtn = binding.convertBtn;
        displayTxt = binding.textView;
        setContentView(view)
    }

    fun convertCurrency(view: View)
    {
        //safety check
        if (dollarAmntEDTX.text.isNotEmpty())
        {
            var amountTyped = dollarAmntEDTX.text.toString()
            var dollarAmnt = amountTyped.toFloat()
            //convert to dollars using a rate
            dollarAmnt *= euroRate

            displayTxt.text = dollarAmnt.toString()
        }
        else
        {
            displayTxt.text = getString(R.string.no_value_string);
        }


    }

    override fun onStop()
    {
        super.onStop()
        
    }
}