package br.edu.ifsp.scl.sdm.fastcalculation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView
import br.edu.ifsp.scl.sdm.fastcalculation.Extras.EXTRA_SETTINGS
import br.edu.ifsp.scl.sdm.fastcalculation.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private val activitySettingsBinding: ActivitySettingsBinding by lazy {
        ActivitySettingsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activitySettingsBinding.root)

        setSupportActionBar(activitySettingsBinding.gameTbIn.gameTb)
        supportActionBar?.apply {
            title = getString(R.string.app_name)
            subtitle = getString(R.string.settings)
        }

        activitySettingsBinding.apply {
            this.letsGoBt.setOnClickListener {
                val settings = Settings(
                    playerName = playerNameEt.text.toString(),
                    rounds = (roundsSp.selectedView as TextView).text.toString().toInt(),
                    roundInterval = roundIntervalRg.run {
                        findViewById<RadioButton>(checkedRadioButtonId).text.toString().toLong() * 1000L
                    }
                )
                val gameActivityIntent = Intent(this@SettingsActivity, GameActivity::class.java)
                gameActivityIntent.putExtra(EXTRA_SETTINGS, settings)
                startActivity(gameActivityIntent)
                finish()
            }
        }
    }
}