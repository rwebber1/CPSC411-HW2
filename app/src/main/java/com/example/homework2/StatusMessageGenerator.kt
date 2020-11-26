package com.example.homework2

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class StatusMessageGenerator(val ctx : Context) {
    fun generate() : LinearLayout {
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.HORIZONTAL   //Vertical linear layouts mean weight affects height
        layoutObj.setBackgroundColor(Color.WHITE)

        val lbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lbParams.topMargin = 50
        lbParams.weight = 1.0F
        var lbl = TextView(ctx)
        lbl.text = "Status:"
        lbl.textSize = 18F
        lbl.gravity = Gravity.CENTER
        lbl.setBackgroundColor(Color.WHITE)
        layoutObj.addView(lbl, lbParams)

        val message = TextView(ctx)
        message.id = R.id.message
        message.setBackgroundColor(Color.WHITE)
        message.gravity = Gravity.LEFT
        message.text = "<Status Message>"
        message.textSize = 18F
        layoutObj.addView(message, lbParams)

        return layoutObj
    }
}