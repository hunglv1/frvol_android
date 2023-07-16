package epita.exam.frvol.common

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import epita.exam.frvol.R

class MultiChoiceDialog(private val context: Context, private val items: Array<String>) {
    private val checkedItems = BooleanArray(items.size)
    private val selectedItems = mutableListOf<String>(*items)

    fun showSelectionDialog(selectedItemsPreview: TextView) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Choose Items")
        builder.setMultiChoiceItems(items, checkedItems) { _, which, isChecked ->
            checkedItems[which] = isChecked
        }
        builder.setCancelable(false)
        builder.setPositiveButton("Done") { dialog, which ->
            val selectedItemsText = selectedItems
                .filterIndexed { index, _ -> checkedItems[index] }
                .joinToString(", ")
            selectedItemsPreview.text = selectedItemsText
        }
        builder.setNegativeButton("CANCEL", null)
        builder.setNeutralButton("CLEAR ALL") { dialog: DialogInterface?, which: Int ->
            checkedItems.fill(false)
        }
        builder.create().show()
    }
}