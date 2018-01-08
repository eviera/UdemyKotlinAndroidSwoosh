package net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skill.*
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.R
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.utilities.EXTRA_LEAGUE
import net.eviera.cursokotlindevslopes.udemykotlinandroidswoosh.utilities.EXTRA_SKILL

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    fun onBallerClicked(view: View) {
        begginerSkillBtn.isChecked = false
        if (ballerSkillBtn.isChecked) {
            skill = "baller"
        } else {
            skill = ""
        }
    }

    fun onBegginerClicked(view: View) {
        ballerSkillBtn.isChecked = false
        if (begginerSkillBtn.isChecked) {
            skill = "begginer"
        } else {
            skill = ""
        }
    }

    fun onFinishClicked(view: View) {
        if (skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }

}
