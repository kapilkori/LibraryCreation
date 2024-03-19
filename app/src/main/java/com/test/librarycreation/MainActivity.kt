package com.test.librarycreation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

//    private val viewModel: com.test.room_crud.NoteViewModel by viewModels {
//        com.test.room_crud.WordViewModelFactory((application as com.test.room_crud.MyApplication).repository)
//    }

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()

        if (!sharedPreferences.getBoolean("FIRST_TIME", false)) {
            myEdit.putBoolean("FIRST_TIME", true)

            CoroutineScope(Dispatchers.IO).launch {
                for (i in 0..10) {
//                    viewModel.insert(
//                        com.test.room_crud.Note(
//                            title = "Yes, $i",
//                            content = "Cheers to yes"
//                        )
//                    )
                }
            }
        }

        myEdit.apply()

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

//        viewModel.getAllNotes().observe(this) { notes ->
//            Log.e("TAG", "onCreate: $notes")
//        }
    }
}