package com.example.ch07_dialog_login

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "사용자 정보 입력"

        var edtName = findViewById<EditText>(R.id.edtName)
        var edtEmail = findViewById<EditText>(R.id.edtEmail)
        var button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener {

            var dialogView = View.inflate(this, R.layout.dialog1, null)
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("사용자 정보 입력")
            dlg.setIcon(R.drawable.ic_menu_allfriends)
//            dlg.setMessage("ASDFA")
            dlg.setView(dialogView)

            var dlgEdt1 = dialogView.findViewById<EditText>(R.id.dlgEdt1)
            var dlgEdt2 = dialogView.findViewById<EditText>(R.id.dlgEdt2)
            dlgEdt1.setText(edtName.text.toString())
            dlgEdt2.setText(edtEmail.text.toString())

            dlg.setPositiveButton("확인") { dialog, which ->

//                var dlgEdt1 = dialogView.findViewById<EditText>(R.id.dlgEdt1)
//                var dlgEdt2 = dialogView.findViewById<EditText>(R.id.dlgEdt2)

                edtName.setText(dlgEdt1.text.toString())
                edtEmail.setText(dlgEdt2.text.toString())

            }


            dlg.setNegativeButton("취소") { dialog, which ->
                var toast = Toast(this@MainActivity)

//                var toast = Toast.makeText(applicationContext, "fsdasfd", Toast.LENGTH_SHORT)

                val display = (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
                val xOffset = (Math.random() * display.width).toInt()
                val yOffset = (Math.random() * display.height).toInt()

                toast.setGravity(Gravity.TOP or Gravity.LEFT, xOffset, yOffset)

                var toastView = View.inflate(this, R.layout.toast1, null)
//                toast.setView(toastView)
                toast.view = toastView

                var toastText = toastView.findViewById<TextView>(R.id.toastText1)
                toastText.text = "취소했습니다~"

                toast.show()
            }
            dlg.show()
        }
    }
}
