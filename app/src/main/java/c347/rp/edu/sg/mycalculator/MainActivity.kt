package c347.rp.edu.sg.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    var operand1 = ""
    var operator = ""
    var operand2 = ""
    var total = 0.0
    var dotExist = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun btnOnClick(view:View) {
        val btnSelected = view as Button

        if(operator.equals("")){
            when(btnSelected.id){
                button0.id -> {
                    operand1 += "0"
                }
                button1.id -> operand1 += "1"
                button2.id -> operand1 += "2"
                button3.id -> operand1 += "3"
                button4.id -> operand1 += "4"
                button5.id -> operand1 += "5"
                button6.id -> operand1 += "6"
                button7.id -> operand1 += "7"
                button8.id -> operand1 += "8"
                button9.id -> operand1 += "9"
                buttonAC.id -> {
                    operand1 = ""
                    operand2 = ""
                    operator = ""
                    tvCal.text = ""
                    tvResult.text = "0"
                    dotExist = false
                }
                buttonAdd.id -> {
                    if (operand1.equals("")){
                        operand1 = tvResult.text.toString()
                        tvResult.text = ""
                    }
                    operator = "+"
                    dotExist = false
                }
                buttonMinus.id -> {
                    if (operand1.equals("")){
                        operand1 = tvResult.text.toString()
                        tvResult.text = ""
                    }
                    operator = "-"
                    dotExist = false
                }
                buttonTimes.id -> {
                    if (operand1.equals("")){
                        operand1 = tvResult.text.toString()
                        tvResult.text = ""
                    }
                    operator = "*"
                    dotExist = false
                }
                buttonDivide.id -> {
                    if (operand1.equals("")){
                        operand1 = tvResult.text.toString()
                        tvResult.text = ""
                    }
                    operator = "/"
                    dotExist = false
                }
                buttonDot.id -> {
                    if (operand1.equals("") || operand1.contains(".")){
                        dotExist = true
                    }
                    if (!dotExist){
                        operand1 += "."
                    }
                }
                buttonEqual.id -> {
                    if (!operand1.equals("")){
                        tvResult.text = "$operand1"
                        tvCal.text = ""
                        operand1 = ""
                        dotExist = false
                    }
                }
                buttonQuit.id -> exitProcess(0)
            }
            tvCal.text = operand1 + operator
        }else{
            tvCal.text = operand1 + operator
            when(btnSelected.id){
                button0.id -> operand2 += "0"
                button1.id -> operand2 += "1"
                button2.id -> operand2 += "2"
                button3.id -> operand2 += "3"
                button4.id -> operand2 += "4"
                button5.id -> operand2 += "5"
                button6.id -> operand2 += "6"
                button7.id -> operand2 += "7"
                button8.id -> operand2 += "8"
                button9.id -> operand2 += "9"
                buttonAC.id -> {
                    operand1 = ""
                    operand2 = ""
                    operator = ""
                    tvResult.text = "0"
                    dotExist = false
                }
                buttonAdd.id -> ""
                buttonMinus.id -> ""
                buttonTimes.id -> ""
                buttonDivide.id -> ""
                buttonDot.id -> {
                    if (operand2.contains(".")){
                        dotExist = true
                    }
                    if (dotExist == false){
                        operand2 += "."
                    }
                }
                buttonEqual.id -> {
                    if (!operand2.equals("")) {
                        when (operator) {
                            "+" -> total = operand1.toDouble() + operand2.toDouble()
                            "-" -> total = operand1.toDouble() - operand2.toDouble()
                            "*" -> total = operand1.toDouble() * operand2.toDouble()
                            "/" -> total = operand1.toDouble() / operand2.toDouble()
                        }
                        tvResult.text = "$total"
                        tvCal.text = ""
                        operand1 = ""
                        operand2 = ""
                        operator = ""
                        dotExist = false
                    }
                }
                buttonQuit.id -> exitProcess(0)
            }
            tvCal.text = operand1 + operator + operand2
        }
    }
}
