package com.enigmacamp.mipdevpwebinarbasickotlinandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOnClickListener()
    }

    private fun appendOnClick(clear: Boolean, string: String) {

        if (clear) {
            tv_output.text = ""
            tv_input.append(string)
        } else {
            tv_input.append(tv_output.text)
            tv_input.append(string)
            tv_output.text = ""
        }
    }

    private fun clear() {
        tv_input.text = ""
        tv_output.text = ""
    }

    private fun calculate() {

        try {
            val input = ExpressionBuilder(tv_input.text.toString()).build()
            val output = input.evaluate()
            val longOutput = output.toLong()
            if (output == longOutput.toDouble()) {
                tv_output.text = longOutput.toString()
            } else {
                tv_output.text = output.toString()
            }
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
        }
    }

    private fun btnOnClickListener() {
        btn_0.setOnClickListener { appendOnClick(true, "0") }
        btn_1.setOnClickListener { appendOnClick(true, "1") }
        btn_2.setOnClickListener { appendOnClick(true, "2") }
        btn_3.setOnClickListener { appendOnClick(true, "3") }
        btn_4.setOnClickListener { appendOnClick(true, "4") }
        btn_5.setOnClickListener { appendOnClick(true, "5") }
        btn_6.setOnClickListener { appendOnClick(true, "6") }
        btn_7.setOnClickListener { appendOnClick(true, "7") }
        btn_8.setOnClickListener { appendOnClick(true, "8") }
        btn_9.setOnClickListener { appendOnClick(true, "9") }
        btn_dot.setOnClickListener { appendOnClick(true, ".") }

        btn_plus.setOnClickListener { appendOnClick(false, "+") }
        btn_minus.setOnClickListener { appendOnClick(false, "-") }
        btn_multiply.setOnClickListener { appendOnClick(false, "*") }
        btn_divide.setOnClickListener { appendOnClick(false, "/") }
        btn_left_b.setOnClickListener { appendOnClick(false, "(") }
        btn_right_b.setOnClickListener { appendOnClick(false, ")") }

        btn_ac.setOnClickListener {
            clear()
        }

        btn_equal.setOnClickListener {
            calculate()
        }
    }
}