package com.example.newsfetcher.base

import android.content.Context
import android.content.res.Configuration
import android.widget.TextView
import androidx.annotation.StyleRes
import androidx.core.widget.TextViewCompat
import com.example.newsfetcher.base.Either.*
import org.w3c.dom.Text

inline fun <reified T> attempt(func: () -> T): Either<Throwable, T> = try {
    Right(func.invoke())
} catch (e: Throwable) {
    Left(e)
}

fun TextView.setTextAppearanceCompat(@StyleRes styleRes: Int) {
    TextViewCompat.setTextAppearance(this, styleRes)
}

fun Context.isDarkModeEnabled(): Boolean {
    return resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
}