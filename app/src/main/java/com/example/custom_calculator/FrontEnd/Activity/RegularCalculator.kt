package com.example.custom_calculator.FrontEnd.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.custom_calculator.FrontEnd.viewmodel.RegularCalculatorViewModel
import com.example.custom_calculator.R
import com.example.custom_calculator.databinding.ActivityRegularCalculatorBinding

class RegularCalculator : AppCompatActivity() {
    private lateinit var viewModel: RegularCalculatorViewModel
    private lateinit var binding: ActivityRegularCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegularCalculatorBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_regular_calculator)
        viewModel = ViewModelProvider(this)[RegularCalculatorViewModel::class.java]
        var result = "Waiting for input"
//        var input1 = viewModel.castFloat(binding.input1)
//        var input2 = viewModel.castFloat(binding.input2)
        val opr = viewModel.operator

        binding.apply {
            fun setResult() {
                binding.result.text = result
            }
            btnAdd.setOnClickListener {
                //viewModel.calculate(input1, input2, opr[0])
                result = calc(opr[0]).toString()
                setResult()
            }
            btnSubstract.setOnClickListener {
                //viewModel.calculate(input1, input2, opr[1])
                result = calc(opr[1]).toString()
                setResult()
            }
            btnMultiply.setOnClickListener {
                //viewModel.calculate(input1, input2, opr[2])
                result = calc(opr[2]).toString()
                setResult()
            }
            btnDivide.setOnClickListener {
                //viewModel.calculate(input1, input2, opr[3])
                result = calc(opr[3]).toString()
                setResult()
            }
        }

    }

    private fun calc(operator: String) {
        val input1 = viewModel.castFloat(binding.input1)
        val input2 = viewModel.castFloat(binding.input2)
        val opr = viewModel.operator
        viewModel.calculate(input1, input2, opr[0])
    }
}