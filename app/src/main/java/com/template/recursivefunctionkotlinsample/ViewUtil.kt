package com.template.recursivefunctionkotlinsample

import android.view.View
import android.view.ViewGroup
import android.widget.ToggleButton

object ViewUtil {
    private fun getViewTree(view: View?): List<View> {
        val views = mutableListOf<View>()
        if (view is ViewGroup) {
            var count = view.childCount
            while (0 <= count) {
                val child = view.getChildAt(count - 1)
                views.addAll(getViewTree(child))
                count--
            }
        }
        view?.let { views.add(it) }
        return views
    }

    fun setOnClickListenerForToggleButton(vg: View, l: View.OnClickListener?) {
        val viewTree = getViewTree(vg)
        viewTree.filterIsInstance<ToggleButton>().forEach { toggleButton ->
            toggleButton.setOnClickListener(l)
        }
    }
}