package com.xp.samplegenericadapterforrecyclerview.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xp.samplegenericadapterforrecyclerview.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.frame_layout
                , SampleListViewNotMapped.newInstance(1)
                , SampleListViewNotMapped.getTag0()
            ).commit()

    }
}
