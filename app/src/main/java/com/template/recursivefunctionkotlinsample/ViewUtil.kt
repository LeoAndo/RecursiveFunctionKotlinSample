package com.template.recursivefunctionkotlinsample

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.ToggleButton
import androidx.constraintlayout.widget.ConstraintLayout

object ViewUtil {
    private fun getViewsTree(view: View?, parentView: ViewGroup?): List<View> {
        val views = mutableListOf<View>()
        if (view is LinearLayout
            || view is FrameLayout
            || (view is RelativeLayout
                    || view is ConstraintLayout)
        ) {
            val childNum = (view as ViewGroup).childCount
            var count = childNum
            while (0 <= count) {
                val child = view.getChildAt(count - 1)
                views.addAll(getViewsTree(child, view as ViewGroup?))
                count--
            }
        }
        if (view != null) {
            views.add(view)
        }
        return views
    }

    fun setOnClickListenerForToggleButton(vg: View, l: View.OnClickListener?) {
        val viewTree = getViewsTree(vg, null)
        viewTree.filterIsInstance<ToggleButton>().forEach { toggleButton ->
            toggleButton.setOnClickListener(l)
        }
    }
}