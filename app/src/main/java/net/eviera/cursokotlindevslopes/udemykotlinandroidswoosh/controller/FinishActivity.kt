package net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finish.*
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.R
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.utilities.EXTRA_LEAGUE
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.utilities.EXTRA_SKILL

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val league = intent.getStringExtra(EXTRA_LEAGUE)
        val skill = intent.getStringExtra(EXTRA_SKILL)

        searchLeagueTxt.text = "Looking for $league $skill league near you..."
    }
}
