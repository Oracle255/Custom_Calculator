package com.example.custom_calculator.FrontEnd.viewmodel

import android.text.Editable
import android.widget.EditText
import androidx.lifecycle.ViewModel

class RegularCalculatorViewModel : ViewModel() {
    var input1: Float = 0f
    var input2: Float = 0f

    var msgError = "Cannot divide by zero"

    val operator = arrayOf(
        "add",
        "substract",
        "multiply",
        "divide"
    )

    // TODO : tambah function roundvalue
    fun round(): Float {
        val result: Float = 0f
        return result
    }

    fun castFloat(inp1: EditText): Float {
        return inp1.toString().toFloat()
    }

    // logical operator taruh sini
    fun calculate(inp1: Float, inp2: Float, operand: String): Float {
        val result: Float
        // add
        when (operand) {
            operator[0] -> {
                result = add(inp1, inp2)
            }
            // substract
            operator[1] -> {
                result = substract(inp1, inp2)
            }
            // multiply
            operator[2] -> {
                result = multiply(inp1, inp2)
            }
            // divide
            operator[3] -> {
                result = divide(inp1, inp2)
            }
            else -> {
                result = 4000f
            }
        }
        return result
    }

    private fun add(inp1: Float, inp2: Float): Float {
        return inp1 + inp2
    }

    private fun substract(inp1: Float, inp2: Float): Float {
        return inp1 - inp2
    }

    private fun multiply(inp1: Float, inp2: Float): Float {
        return inp1 * inp2
    }

    private fun divide(inp1: Float, inp2: Float): Float {
        var result = 0f
        try {
            val result = inp1 / inp2
        } catch (e: ArithmeticException) {
            msgError = e.toString()
            result = 404f
        }

        return result
    }

}