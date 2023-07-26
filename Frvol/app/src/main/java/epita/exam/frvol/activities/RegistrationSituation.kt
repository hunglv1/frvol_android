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

        val imgActionAreas = findViewById<ImageView>(R.id.img_edit_actionarea2)
        val tvActionAreas = findViewById<EditText>(R.id.txt_action_areas)
        val actionAreasItems = ItemsProvider.actionAreas
        val actionAreasMultiChoiceDialog = MultiChoiceDialog(this, actionAreasItems)
        imgActionAreas.setOnClickListener {
            actionAreasMultiChoiceDialog.showSelectionDialog(tvActionAreas)
        }

        val imgMissions = findViewById<ImageView>(R.id.img_edit_missions)
        val tvMissions = findViewById<EditText>(R.id.txt_mission_type)
        val missionTypesItems = ItemsProvider.missionTypes
        val missionsMultiChoiceDialog = MultiChoiceDialog(this, missionTypesItems)
        imgMissions.setOnClickListener {
            missionsMultiChoiceDialog.showSelectionDialog(tvMissions)
        }

        val imgAvailabilities = findViewById<ImageView>(R.id.img_edit_availabilities)
        val tvAvailabilities = findViewById<EditText>(R.id.txt_availabilities)
        val availabilitiesItems = ItemsProvider.availabilities
        val availabilitiesMultiChoiceDialog = MultiChoiceDialog(this, availabilitiesItems)
        imgAvailabilities.setOnClickListener {
            availabilitiesMultiChoiceDialog.showSelectionDialog(tvAvailabilities)
        }

        val imgSituation = findViewById<ImageView>(R.id.img_edit_skill)
        val tvSituation = findViewById<EditText>(R.id.txt_skills)
        val situationsItems = ItemsProvider.professionalSituations
        val situationsMultiChoiceDialog = MultiChoiceDialog(this, situationsItems)
        imgSituation.setOnClickListener {
            situationsMultiChoiceDialog.showSelectionDialog(tvSituation)
        }

        val imgDisplacement = findViewById<ImageView>(R.id.img_edit_displacement)
        val tvDisplacement = findViewById<EditText>(R.id.txt_displacement)
        val displacementItems = ItemsProvider.possibleDisplacement
        val displacementMultiChoiceDialog = MultiChoiceDialog(this, displacementItems)
        imgDisplacement.setOnClickListener {
            displacementMultiChoiceDialog.showSelectionDialog(tvDisplacement)
        }

        val imgTravelType = findViewById<ImageView>(R.id.img_edit_traveltype)
        val tvTravelType = findViewById<EditText>(R.id.txt_traveltype)
        val travelTypeItems = ItemsProvider.travelTypes
        val travelTypeMultiChoiceDialog = MultiChoiceDialog(this, travelTypeItems)
        imgTravelType.setOnClickListener {
            travelTypeMultiChoiceDialog.showSelectionDialog(tvTravelType)
        }

        val btnNext = findViewById<Button>(R.id.btn_situation_next)
        btnNext.setOnClickListener {
            val intent = Intent(this, RegistrationIdentifier::class.java)
            startActivity(intent)
        }

    }
}