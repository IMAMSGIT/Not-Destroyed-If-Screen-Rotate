package com.example.notdestroyedifscreenrotate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var count=0
    private lateinit var zeroTV:TextView
    private lateinit var pressBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        zeroTV=findViewById(R.id.zeroTV)
        pressBtn=findViewById(R.id.pressBtn)
        if(savedInstanceState!=null) // to check if the new bundle(rotate), not null
        {
            count= savedInstanceState.getInt("Count") // passing the newInstanceState to count
            zeroTV.text= count.toString() // set it to the zeroTV TextView
        }
       // set a built in setOnClickListener to this Button

        pressBtn.setOnClickListener {
            count++
            zeroTV.text=count.toString()
        }
    }
    // call this function to pass the bundle to the operating system
    override fun onSaveInstanceState(outState: Bundle)
    {
        outState.putInt("Count",count) // tag name(any), actual variable
        super.onSaveInstanceState(outState)
    }
}