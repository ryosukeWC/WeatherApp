package com.example.settings

import android.content.Context
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu

class PopMenuInstance(
    private val context : Context
) {

    fun showPopUpMenu(view : View) {

        val popUpMenu = PopupMenu(context,view)
        popUpMenu.menuInflater.inflate(R.menu.settings_menu,popUpMenu.menu)

        popUpMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                return when (item?.itemId) {
                    R.id.city_option -> {
                        Toast.makeText(context, "Выбраны города", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.update_rate -> {
                        Toast.makeText(context, "Выбрана частота обновления", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.unit_of_measurement_option -> {
                        Toast.makeText(context, "Выбраны еденицы измерения", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        })

        popUpMenu.show()

    }
}