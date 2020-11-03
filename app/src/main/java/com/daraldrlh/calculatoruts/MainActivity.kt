package com.daraldrlh.calculatoruts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Numbers
        tvSatu.setOnClickListener { appendOnExpresstion("1", true) }
        tvDua.setOnClickListener { appendOnExpresstion("2", true) }
        tvTiga.setOnClickListener { appendOnExpresstion("3", true) }
        tvEmpat.setOnClickListener { appendOnExpresstion("4", true) }
        tvLima.setOnClickListener { appendOnExpresstion("5", true) }
        tvEnam.setOnClickListener { appendOnExpresstion("6", true) }
        tvTujuh.setOnClickListener { appendOnExpresstion("7", true) }
        tvDelapan.setOnClickListener { appendOnExpresstion("8", true) }
        tvSembilan.setOnClickListener { appendOnExpresstion("9", true) }
        tvNol.setOnClickListener { appendOnExpresstion("0", true) }
        tvDot.setOnClickListener { appendOnExpresstion(".", true) }

        //Operators
        tvTambah.setOnClickListener { appendOnExpresstion("+", false) }
        tvKurang.setOnClickListener { appendOnExpresstion("-", false) }
        tvKali.setOnClickListener { appendOnExpresstion("*", false) }
        tvDivide.setOnClickListener { appendOnExpresstion("/", false) }
        tvKuadrat2.setOnClickListener { appendOnExpresstion("^2", false) }

        tvClear.setOnClickListener {
            tvResult2.text = ""
            tvResult.text = ""
        }

        tvBack.setOnClickListener {
            val string = tvResult2.text.toString()
            if(string.isNotEmpty()){
                tvResult2.text = string.substring(0,string.length-1)
            }
            tvResult.text = ""
        }

        tvSamaDgn.setOnClickListener {
            try {

                val expression = ExpressionBuilder(tvResult2.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()

            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }
        }

    }

    fun appendOnExpresstion(string: String, canClear: Boolean) {

        if(tvResult.text.isNotEmpty()){
            tvResult2.text = ""
        }

        if (canClear) {
            tvResult.text = ""
            tvResult2.append(string)
        } else {
            tvResult2.append(tvResult.text)
            tvResult2.append(string)
            tvResult.text = ""
        }
    }
}