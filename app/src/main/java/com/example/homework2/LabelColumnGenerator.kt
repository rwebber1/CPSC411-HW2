package com.example.homework2

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class LabelColumnGenerator(val ctx: Context) {

    fun generate() : LinearLayout{
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL    //Vertical linear layouts mean weight affects height
        layoutObj.setBackgroundColor(Color.WHITE)
        val lbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lbParams.weight = 1.0F
        lbParams.topMargin = 5
        var lbl = TextView(ctx)
        lbl.text = "Claim Title:"
        lbl.setBackgroundColor(Color.WHITE)
        lbl.gravity = Gravity.CENTER
        lbl.textSize = 18F
        layoutObj.addView(lbl, lbParams)
        lbl = TextView(ctx)
        lbl.text = "Date:"
        lbl.setBackgroundColor(Color.WHITE)
        lbl.gravity = Gravity.CENTER
        lbl.textSize = 18F
        layoutObj.addView(lbl, lbParams)

        return layoutObj
    }
}