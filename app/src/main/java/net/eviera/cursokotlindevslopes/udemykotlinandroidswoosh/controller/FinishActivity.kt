package net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finish.*
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.R
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.model.Player
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.utilities.EXTRA_PLAYER

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchLeagueTxt.text = "Looking for ${player.league} ${player.skill} league near you..."
    }
}
