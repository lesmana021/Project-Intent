package com.yogacahya.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var ip_nim: EditText
    lateinit var ip_nama: EditText
    lateinit var ip_nilai: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ip_nim = findViewById(R.id.edt_nim)
        ip_nama = findViewById(R.id.edt_nama)
        ip_nilai = findViewById(R.id.edt_nilai)

        supportActionBar?.title = ("Input Data")
        proses.setOnClickListener {
            if (ip_nim.text.isEmpty()) {
                toast("Nim harus diisi", Toast.LENGTH_LONG)
            } else if (ip_nama.text.isEmpty()) {
                toast("Nama harus diisi", Toast.LENGTH_LONG)
            }
            else if (ip_nilai.text.toString().toInt() > 100) {
                toast("Nilai harus diisi", Toast.LENGTH_LONG)
            }
            else if (ip_nilai.text.isEmpty()) {
                toast("Nilai tidak boleh lebih dari 100", Toast.LENGTH_LONG)
            } else  {
                toast("Sukses Input Data", Toast.LENGTH_LONG)

                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("data_nim", ip_nim.text.toString())
                intent.putExtra("data_nama", ip_nama.text.toString())
                intent.putExtra("data_nilai", ip_nilai.text.toString())

                startActivity(intent)


            }
        }
    }
    private fun toast(message: String, length: Int = Toast.LENGTH_LONG){
        Toast.makeText(this,message,length).show()
    }
}