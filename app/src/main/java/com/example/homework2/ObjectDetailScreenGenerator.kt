package com.example.homework2

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class ObjDetailScreenGenerator(val ctx : Context) {
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {
        // 1. Create a linearLayout object
        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.WHITE)

        // 2. Add title
        val tParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        tParams.topMargin = 20
        tParams.bottomMargin = 20

        var title = TextView(ctx)
        title.text = "Please Enter Claim Information"
        title.setTypeface(Typeface.DEFAULT_BOLD)
        title.setTextSize(20F)
        title.gravity = Gravity.CENTER
        title.setBackgroundColor(Color.WHITE)

        layoutObj.addView(title, tParams)

        // 2. Add ObjDetailSection
        val fldRowGenerator = ObjDetailSectionGenerator(ctx)
        val colView = fldRowGenerator.generate()
        layoutObj.addView(colView)

        // 3. Create Add Button LinearLayout
        val buttonLayout = LinearLayout(ctx)
        val buttonParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        // only applied to height now
        buttonParams.gravity = Gravity.RIGHT
        buttonParams.setMargins(0,100,100,0)
        buttonLayout.layoutParams = buttonParams
        buttonLayout.orientation = LinearLayout.HORIZONTAL
        buttonLayout.setBackgroundColor(Color.CYAN)
        //
        val addButton = Button(ctx)
        addButton.text = "Add"
        addButton.setId(R.id.add_btn)
        addButton.setBackgroundColor(Color.WHITE)
        val nbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        nbParams.gravity = Gravity.CENTER
        nbParams.setMargins(5,5,5,5)
        buttonLayout.addView(addButton, nbParams)
        //
        layoutObj.addView(buttonLayout, buttonParams)

        //Add Status Message
        val statusGenerator = StatusMessageGenerator(ctx)
        val status = statusGenerator.generate()
        layoutObj.addView(status)

        return layoutObj
    }
}