package com.example.newsfetcher.feature.main_screen.presentation

import com.example.newsfetcher.feature.main_screen.domian.ArticleModel

typealias UsersListener = (users: List<ArticleModel>) -> Unit

//class UsersService {
//
////    private var users = mutableListOf<ArticleModel>()
////
////    private val listeners = mutableSetOf<UsersListener>()
//
////
////    fun getUsers(): List<ArticleModel> {
////        return users
////    }
////
////    fun addListener(listener: UsersListener) {
////        listeners.add(listener)
////        listener.invoke(users)
////    }
////
////    fun removeListener(listener: UsersListener) {
////        listeners.remove(listener)
////    }
////
////    private fun notifyChanges() {
////        listeners.forEach { it.invoke(users) }
////    }
//
//
//}