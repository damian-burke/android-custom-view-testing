package com.brainasaservice.android.customviewtesting.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.brainasaservice.android.customviewtesting.R

/**
 * Nobody needs this, nobody wants to start the app anyway. It's all about the tests.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
