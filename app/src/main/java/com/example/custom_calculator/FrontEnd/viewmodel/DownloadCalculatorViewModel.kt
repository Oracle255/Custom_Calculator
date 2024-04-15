package com.example.custom_calculator.FrontEnd.viewmodel

import android.text.Editable
import androidx.lifecycle.ViewModel

class DownloadCalculatorViewModel : ViewModel() {
    val type = arrayOf(
        "kb",
        "mb",
        "gb"
    )

    // base value : downloadSpeed=kb FileSize=mb
    fun convertToBaseValueDS(ds: Editable, dsType: String): Double {
        val input = ds.toString().takeIf { it.isNotBlank() }?.toInt() ?: 99444
        var inputDS = when (dsType) {
            type[0] -> input
            type[1] -> input / 1024
            type[2] -> input / 1024 / 1024
            else -> 66932737294888
        }
        return inputDS.toDouble()
    }


    fun convertToBaseValueFS(fs: Editable, fsType: String): Double {
        val input = fs.toString().takeIf { it.isNotBlank() }?.toInt() ?: 99444
        var inputFS = when (fsType) {
            type[0] -> input * 1024
            type[1] -> input
            type[2] -> input / 1024
            else -> {
                66932737294888
            }
        }
        return inputFS.toDouble()
    }

    // baseETA=Min
    fun calcEtaSecond(ds: Double, fs: Double): String {
        val result = "${fs * 1024 / ds}"
        return result
    }

    fun calcEtaMinute(ds: Double, fs: Double): String {
        val result = "${fs * 1024 / ds / 60}"
        return result
    }

    fun calcEtaHour(ds: Double, fs: Double): String {
        val result = "${fs * 1024 / ds / 60 / 60}"
        return result
    }

    fun formatETA(input: Int, extra: String):String {

        return "$input $extra"
    }

    fun roundValue(input: String): String {
        val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
        var inputValue = input.toInt()
        var index = 0
        if (input.toInt() >= 1000 && index < suffix.size - 1) {
            inputValue /= 1000
            index++
        }
        return String.format("%.2f", inputValue)
    }

}