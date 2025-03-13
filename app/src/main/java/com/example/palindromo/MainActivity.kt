package com.example.palindromo

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.palindromo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
    }

    fun init(){
        binding.Button.setOnClickListener(this)

    }
    override fun onClick(view: View?) {
        when(view){

            binding.Button -> palindromoYReversa()
        }
    }

    fun palindromoYReversa(){

        val imput = binding.EditText.text.toString()
        var palabrareves = rever(imput)

        binding.screen.text = "$palabrareves"
        if (imput == palabrareves) {
            binding.screen2.text = "si, es un palindromo"
        }else{
            binding.screen2.text = "no, es un palindromo"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("palindromo",  binding.screen2.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        binding.screen2.text = savedInstanceState.getString("palindromo", "")
    }

    fun rever(palabra: String): String {

        var pal = ""

        for(i in palabra.length-1 downTo 0 ){
            pal += palabra[i]
        }
        return pal
    }



}