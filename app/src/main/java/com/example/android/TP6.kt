package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.*
import androidx.room.Room

class TP6 : AppCompatActivity() {

    private lateinit var liste: LinearLayout
    private lateinit var db: TodoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t_p6)
        liste = findViewById(R.id.list_todos)
        db = Room.databaseBuilder(applicationContext, TodoDatabase::class.java, "TODO_DB").allowMainThreadQueries().build()

        var data = db.todoDAO()
        data.retrieveAll()?.forEach {
            createCheckbox(it.label, it.id, it.checked)
        }


         val editText: EditText = findViewById(R.id.editText3)
         editText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
             if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                 var rowId: java.util.List<java.lang.Long> =  db.todoDAO().insertTodo(TodoEntity(id = 0, label = editText.text.toString(), checked = false))
                 createCheckbox(editText.text.toString(), rowId[0].toLong(), false)

                editText.setText("")
                return@OnKeyListener true
             }
             false
         })


    }

    private fun createCheckbox(label: String, id: Long, checked: Boolean) {
        val checkbox = CheckBox(this)
        checkbox.text = label
        checkbox.isChecked = checked
        checkbox.id = id.toInt()
        liste.addView(checkbox)
        checkbox.setOnCheckedChangeListener(object: CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if (checkbox.isChecked) {
                    db.todoDAO().updateTodo(TodoEntity(id = id, label = label, checked = true))
                } else {
                    db.todoDAO().updateTodo(TodoEntity(id = id, label = label, checked = false))
                }
            }
        })
    }
}
