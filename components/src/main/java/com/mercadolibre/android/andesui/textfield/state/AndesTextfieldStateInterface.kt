package com.mercadolibre.android.andesui.textfield.state

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.support.v4.content.ContextCompat
import com.mercadolibre.android.andesui.R

/**
 * Defines all style related properties that an [AndesTexfield] needs to be drawn properly.
 * Those properties change depending on the style of the message.
 *
 */
internal sealed class AndesTextfieldStateInterface {
    abstract fun backgroundColor(context: Context): Drawable

}

internal object AndesEnabledTexfieldState : AndesTextfieldStateInterface() {
    override fun backgroundColor(context: Context): Drawable {
        return StateListDrawable().apply {
            addState(intArrayOf(android.R.attr.state_focused), createGradientDrawable(context, context.resources.getDimension(R.dimen.andes_textfield_focused_stroke).toInt(), ContextCompat.getColor(context, R.color.andes_accent_color_500)))
            addState(intArrayOf(android.R.attr.state_enabled), createGradientDrawable(context, context.resources.getDimension(R.dimen.andes_textfield_simple_stroke).toInt(), ContextCompat.getColor(context, R.color.andes_gray_200)))
            addState(intArrayOf(-android.R.attr.state_enabled), createGradientDrawableWithDash(context, context.resources.getDimension(R.dimen.andes_textfield_simple_stroke).toInt(), ContextCompat.getColor(context, R.color.andes_gray_200), context.resources.getDimension(R.dimen.andes_textfield_dash)))

        }
    }

}


internal object AndesErrorTexfieldState : AndesTextfieldStateInterface() {
    override fun backgroundColor(context: Context): Drawable {
        return StateListDrawable().apply {
            addState(intArrayOf(android.R.attr.state_focused), createGradientDrawable(context, context.resources.getDimension(R.dimen.andes_textfield_focused_stroke).toInt(), ContextCompat.getColor(context, R.color.andes_red_500)))
            addState(intArrayOf(android.R.attr.state_enabled), createGradientDrawable(context, context.resources.getDimension(R.dimen.andes_textfield_simple_stroke).toInt(), ContextCompat.getColor(context, R.color.andes_red_500)))
        }
    }

}


internal object AndesDisabledTexfieldState : AndesTextfieldStateInterface() {
    override fun backgroundColor(context: Context): Drawable {
        return createGradientDrawableWithDash(context, context.resources.getDimension(R.dimen.andes_textfield_simple_stroke).toInt(), ContextCompat.getColor(context, R.color.andes_gray_200), context.resources.getDimension(R.dimen.andes_textfield_dash))
    }
}


private fun createGradientDrawable(context: Context, stroke: Int, color: Int): Drawable {
    val drawable = GradientDrawable()
    drawable.cornerRadius = context.resources.getDimension(R.dimen.andes_button_border_radius_large)
    drawable.setStroke(stroke, color)
    return drawable
}

private fun createGradientDrawableWithDash(context: Context, stroke: Int, color: Int, dash: Float): Drawable {
    val drawable = GradientDrawable()
    drawable.cornerRadius = context.resources.getDimension(R.dimen.andes_button_border_radius_large)
    drawable.setStroke(stroke, ContextCompat.getColor(context, R.color.andes_gray_250), dash, dash)
    drawable.setColor(ContextCompat.getColor(context, R.color.andes_gray_040))
    return drawable
}