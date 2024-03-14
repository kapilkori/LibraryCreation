package com.test.mytoastlibrary

import android.content.Context
import android.widget.Toast

class CustomToaster {
    companion object {
        fun showMessage(contest: Context, msg: String, time: Int) {
            Toast.makeText(contest, msg, time).show()
        }
    }
}