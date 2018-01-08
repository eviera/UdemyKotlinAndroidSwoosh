package net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.R
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.model.Player
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.utilities.EXTRA_PLAYER

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    /**
     * Cuando se rota se salva el estado
     */
    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    /**
     * Cuando se recrea la actividad, levanta el estado grabado
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun mensClicked(view: View) {
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false
        if (mensLeagueBtn.isChecked) {
            player.league = "mens"
        } else {
            player.league = ""
        }
    }

    fun womensClicked(view: View) {
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false
        if (womensLeagueBtn.isChecked) {
            player.league = "womens"
        } else {
            player.league = ""
        }

    }

    fun coedClicked(view: View) {
        womensLeagueBtn.isChecked = false
        mensLeagueBtn.isChecked = false
        if (coedLeagueBtn.isChecked) {
            player.league = "co-ed"
        } else {
            player.league = ""
        }

    }


    fun leagueNextClicked(view: View) {
        if (player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }
    }

}
