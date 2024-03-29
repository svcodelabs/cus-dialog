package com.svcodelabs.cusdialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

class CusDialog(private val context: Context) {

    private fun buildDialogView(@LayoutRes layout: Int): Dialog {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(layout)
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return dialog
    }

    fun InfoDialog(@StringRes title: Int, @StringRes content: Int, @StringRes bt_text_pos: Int,
                   @DrawableRes icon: Int, callback: CallbackDialog): Dialog {
        return InfoDialog(context.getString(title), context.getString(content),
            context.getString(bt_text_pos), icon, callback)
    }

    // dialog info
    fun InfoDialog(title: String, content: String, bt_text_pos: String,
                   @DrawableRes icon: Int, callback: CallbackDialog): Dialog {
        val dialog = buildDialogView(R.layout.dialog_info)

        (dialog.findViewById<View>(R.id.title) as TextView).text = title
        (dialog.findViewById<View>(R.id.content) as TextView).text = content
        (dialog.findViewById<View>(R.id.bt_positive) as Button).text = bt_text_pos
        (dialog.findViewById<View>(R.id.icon) as ImageView).setImageResource(icon)

        (dialog.findViewById<View>(R.id.bt_positive) as Button).setOnClickListener {
            callback.onPositiveClick(dialog)
        }
        return dialog
    }

    fun WarningDialog(@StringRes title: Int, @StringRes content: Int, @StringRes bt_text_pos: Int,
                      @StringRes bt_text_neg: Int, @DrawableRes icon: Int, callback: CallbackDialog): Dialog {
        var _title: String? = null
        var _content: String? = null
        var _bt_text_neg: String? = null

        if (title != -1) _title = context.getString(title)
        if (content != -1) _content = context.getString(content)
        if (bt_text_neg != -1) _bt_text_neg = context.getString(bt_text_neg)

        return WarningDialog(_title, _content, context.getString(bt_text_pos), _bt_text_neg, icon, callback)
    }

    fun WarningDialog(@StringRes title: Int, @StringRes content: Int, @StringRes bt_text_pos: Int,
                      @DrawableRes icon: Int, callback: CallbackDialog): Dialog {
        var _title: String? = null
        var _content: String? = null

        if (title != -1) _title = context.getString(title)
        if (content != -1) _content = context.getString(content)

        return WarningDialog(_title, _content, context.getString(bt_text_pos), null,
            icon, callback)
    }

    // dialog warning
    fun WarningDialog(title: String?, content: String?, bt_text_pos: String, bt_text_neg: String?,
                      @DrawableRes icon: Int, callback: CallbackDialog): Dialog {
        val dialog = buildDialogView(R.layout.dialog_warning)

        // if id = -1 view will gone
        if (title != null) {
            (dialog.findViewById<View>(R.id.title) as TextView).text = title
        } else {
            (dialog.findViewById<View>(R.id.title) as TextView).visibility = View.GONE
        }

        // if id = -1 view will gone
        if (content != null) {
            (dialog.findViewById<View>(R.id.content) as TextView).text = content
        } else {
            (dialog.findViewById<View>(R.id.content) as TextView).visibility = View.GONE
        }
        (dialog.findViewById<View>(R.id.bt_positive) as Button).text = bt_text_pos
        if (bt_text_neg != null) {
            (dialog.findViewById<View>(R.id.bt_negative) as Button).text = bt_text_neg
        } else {
            (dialog.findViewById<View>(R.id.bt_negative) as Button).visibility = View.GONE
        }
        (dialog.findViewById<View>(R.id.icon) as ImageView).setImageResource(icon)

        (dialog.findViewById<View>(R.id.bt_positive) as Button).setOnClickListener {
            callback.onPositiveClick(dialog)
        }

        (dialog.findViewById<View>(R.id.bt_negative) as Button).setOnClickListener {
            callback.onNegativeClick(dialog)
        }
        return dialog
    }

}