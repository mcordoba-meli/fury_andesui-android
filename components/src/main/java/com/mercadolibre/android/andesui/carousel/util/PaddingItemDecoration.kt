package com.mercadolibre.android.andesui.carousel.util

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class PaddingItemDecoration(private val padding: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {

        with(outRect) {
            left =  padding
            right = padding
        }
    }
}