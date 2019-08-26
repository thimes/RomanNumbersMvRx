package com.himes.romannumerals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.himes.romannumerals.databinding.ActivityMainBinding
import com.himes.romannumerals.entryscreen.EntryScreenViewModel
import com.himes.romannumerals.models.RomanNumeral

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding.viewModel = EntryScreenViewModel(RomanNumeral("IV"))
    }
}
