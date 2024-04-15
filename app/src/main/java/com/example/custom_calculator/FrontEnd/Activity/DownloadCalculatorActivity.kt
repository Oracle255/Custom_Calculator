package com.example.custom_calculator.FrontEnd.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.custom_calculator.FrontEnd.viewmodel.DownloadCalculatorViewModel
import com.example.custom_calculator.R
import com.example.custom_calculator.databinding.ActivityDownloadCalculatorBinding

//TODO : Implemetasi listView untuk selector format File
//TODO : Implementasi RoundValue
class DownloadCalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDownloadCalculatorBinding
    private lateinit var viewModel: DownloadCalculatorViewModel

    // initialize variable
    private var baseInputDownload: Double = 1024.0
    private var baseInputSize: Double = 512.0
    private var etaHrs = ""
    private var etaMin = ""
    private var etaSec = ""
    private var downloadSpeedType = "kb"
    private var fileSizeType = "mb"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDownloadCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root) // Use binding.root to set the content view

        viewModel = ViewModelProvider(this)[DownloadCalculatorViewModel::class.java]

        // calculate ETA and bind to result
        binding.btnConfirm.setOnClickListener {
            setETA()
            binding.apply {
                lbValueSecond.text = etaSec
                lbValueMinute.text = etaMin
                lbValueHour.text = etaHrs
            }
        }
    }


    private fun setETA() {
        // get input
        var inputDownloadSpeed = binding.inpDownloadSpeed.text
        var inputFileSize = binding.inpFileSize.text
        // convert to base value : downloadSpeed=kb FileSize=mb
        baseInputDownload = viewModel.convertToBaseValueDS(inputDownloadSpeed, downloadSpeedType)
        baseInputSize = viewModel.convertToBaseValueFS(inputFileSize, fileSizeType)

        etaSec = viewModel.calcEtaSecond(baseInputDownload, baseInputSize)
        etaMin = viewModel.calcEtaMinute(baseInputDownload, baseInputSize)
        etaHrs = viewModel.calcEtaHour(baseInputDownload, baseInputSize)

    }


}