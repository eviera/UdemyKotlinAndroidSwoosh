package net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skill.*
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.R
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.model.Player
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.utilities.EXTRA_PLAYER

class SkillActivity : BaseActivity() {

    lateinit var player: Player

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
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    fun onBallerClicked(view: View) {
        begginerSkillBtn.isChecked = false
        if (ballerSkillBtn.isChecked) {
            player.skill = "baller"
        } else {
            player.skill = ""
        }
    }

    fun onBegginerClicked(view: View) {
        ballerSkillBtn.isChecked = false
        if (begginerSkillBtn.isChecked) {
            player.skill = "begginer"
        } else {
            player.skill = ""
        }
    }

    fun onFinishClicked(view: View) {
        if (player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }

}
