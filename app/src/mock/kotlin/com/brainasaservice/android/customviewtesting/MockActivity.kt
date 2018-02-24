package com.brainasaservice.android.customviewtesting

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MockActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
    }

    companion object {
        var layout: Int = 0
    }
}
