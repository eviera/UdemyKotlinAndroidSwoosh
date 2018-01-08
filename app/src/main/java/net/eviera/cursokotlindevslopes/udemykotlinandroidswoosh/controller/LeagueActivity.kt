package net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.utilities.EXTRA_LEAGUE
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.R

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun mensClicked(view: View) {
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false
        if (mensLeagueBtn.isChecked) {
            selectedLeague = "mens"
        } else {
            selectedLeague = ""
        }
    }

    fun womensClicked(view: View) {
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false
        if (womensLeagueBtn.isChecked) {
            selectedLeague = "womens"
        } else {
            selectedLeague = ""
        }

    }

    fun coedClicked(view: View) {
        womensLeagueBtn.isChecked = false
        mensLeagueBtn.isChecked = false
        if (coedLeagueBtn.isChecked) {
            selectedLeague = "co-ed"
        } else {
            selectedLeague = ""
        }

    }


    fun leagueNextClicked(view: View) {
        if (selectedLeague != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }
    }

}
