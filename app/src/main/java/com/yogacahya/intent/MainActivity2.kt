package com.yogacahya.intent

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*

@SuppressLint("Registered")
class MainActivity2: AppCompatActivity() {

    private lateinit var nim  : TextView
    private lateinit var nama : TextView
    private lateinit var nilai: TextView
    private lateinit var keterangan: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        nim = findViewById(R.id.nim)
        nama = findViewById(R.id.nama)
        nilai= findViewById(R.id.nilai)
        keterangan= findViewById(R.id.ket)

        supportActionBar?.title="Hasil Output"

        nim.text = intent.getStringExtra("data_nim")
        nama.text = intent.getStringExtra("data_nama")
        nilai.text = intent.getStringExtra("data_nilai")
        if (nilai.text.toString().toInt()>=80){
            ket.text = "A"
        }else if (nilai.text.toString().toInt()>=60){
            ket.text = "B"
        }else if(nilai.text.toString().toInt()>=40){
            ket.text = "C"
        }else if(nilai.text.toString().toInt()>=20){
            ket.text = "D"
        }else if(nilai.text.toString().toInt()>=0){
            ket.text = "E"
        }
        back.setOnClickListener(){
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
