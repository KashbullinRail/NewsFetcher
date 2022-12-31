package com.example.newsfetcher.base

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.view.View
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.annotation.StyleRes
import androidx.core.widget.TextViewCompat
import com.example.newsfetcher.base.Either.*


inline fun <reified T> attempt(func: () -> T): Either<Throwable, T> = try {
    Right(func.invoke())
} catch (e: Throwable) {
    Left(e)
}

fun TextView.setTextAppearanceCompat(@StyleRes styleRes: Int) {
    TextViewCompat.setTextAppearance(this, styleRes)
}

fun Context.isDarkModeEnabled(): Boolean {
    val themeNight =  resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    return themeNight
}




// Using focus on the input field and calling the keyboard
fun Activity.hideKeyboard() {
    inputMethodManager.hideSoftInputFromWindow(window.decorView.windowToken, 0)
}

val Context.inputMethodManager: InputMethodManager
    get() = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

fun View.focusAndShowKeyboard() {
    fun View.showTheKeyboardNow() {
        if (isFocused){
            post {
                context.inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
            }
        }
    }

    requestFocus()
    if (hasWindowFocus()){
        showTheKeyboardNow()
    } else {
        viewTreeObserver.addOnWindowFocusChangeListener(
            object : ViewTreeObserver.OnWindowFocusChangeListener {
                override fun onWindowFocusChanged(hasFocus: Boolean) {
                    if (hasFocus){
                        this@focusAndShowKeyboard.showTheKeyboardNow()
                        viewTreeObserver.removeOnWindowFocusChangeListener(this)
                    }
                }
            }
        )
    }
}