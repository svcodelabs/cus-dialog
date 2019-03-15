package com.svcodelabs.cusdialog

import android.app.Dialog

interface CallbackDialog {

    fun onPositiveClick(dialog: Dialog)

    fun onNegativeClick(dialog: Dialog)

}