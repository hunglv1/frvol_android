package epita.exam.frvol.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import epita.exam.frvol.R
import epita.exam.frvol.common.ItemsProvider
import epita.exam.frvol.common.MultiChoiceDialog

class RegistrationSituation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_situation)

        val bOpenAlertDialog = findViewById<ImageView>(R.id.img_edit_actionarea2)
        val tvSelectedItemsPreview = findViewById<EditText>(R.id.txt_action_areas)
        val items = ItemsProvider.actionAreas
        val multiChoiceDialog = MultiChoiceDialog(this, items)
        bOpenAlertDialog.setOnClickListener {
            multiChoiceDialog.showSelectionDialog(tvSelectedItemsPreview)
        }

        val btnNext = findViewById<Button>(R.id.btn_situation_next)
        btnNext.setOnClickListener {
            val intent = Intent(this, RegistrationIdentifier::class.java)
            startActivity(intent)
        }

    }
}