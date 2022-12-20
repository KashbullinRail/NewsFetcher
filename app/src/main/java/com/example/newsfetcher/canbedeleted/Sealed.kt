package com.example.newsfetcher.feature.main_screen.mainscreen

import android.util.Log


class Sealed {

    val clas: Hierarchy = Hierarchy.Two("Hi", 1)
    val enum: Enum = Enum.Two

    init {
        when (clas) {
            is Hierarchy.Four -> Log.d("TAG", clas.text)
            is Hierarchy.One -> Log.d("TAG", clas.text)
            is Hierarchy.Three -> Log.d("TAG", clas.text)
            is Hierarchy.Two -> Log.d("TAG", clas.text + clas.index)
            else -> {}
        }
        when (enum) {
            Enum.One -> TODO()
            Enum.Two -> TODO()
            Enum.Three -> TODO()
            Enum.Four -> TODO()
        }
    }

}

sealed class Hierarchy() {
    data class One(val text: String) : Hierarchy()
    data class Two(val text: String, val index: Int) : Hierarchy()
    data class Three(val text: String) : Hierarchy()
    data class Four(val text: String) : Hierarchy()
}

enum class Enum(val text: String) {
    One("1"),
    Two("2"),
    Three("3"),
    Four("4");
}