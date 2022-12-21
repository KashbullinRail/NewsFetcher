package com.example.newsfetcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.newsfetcher.feature.bookmarks.presentation.BookmarksFragment
import com.example.newsfetcher.feature.detailscreen.presentation.DetailFragment
import com.example.newsfetcher.feature.main_screen.presentation.MainScreenFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private val bottomNavigationMenu: BottomNavigationView by lazy { findViewById(R.id.bnvBar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itemMain -> {
                    selectTab(MainScreenFragment())
                }
                R.id.itemBookmarks -> {
                    selectTab(BookmarksFragment())
                }
                R.id.itemDetail -> {
                    selectTab(DetailFragment())
                }
                else -> {}
            }
            true
        }
        bottomNavigationMenu.selectedItemId = R.id.itemMain

    }

    private fun selectTab(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

}