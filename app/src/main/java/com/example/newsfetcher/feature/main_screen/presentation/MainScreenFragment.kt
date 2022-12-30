package com.example.newsfetcher.feature.main_screen.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsfetcher.App
import com.example.newsfetcher.R
import com.example.newsfetcher.databinding.FragmentMainScreenBinding
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {

    private val binding by viewBinding(FragmentMainScreenBinding::bind)

    private val viewModel: MainScreenViewModel by viewModel()

    private lateinit var adapter: UsersAdapter

//    private val adapter: ArticlesAdapter by lazy {
//        ArticlesAdapter { index ->
//            viewModel.processUIEvent(UIEvent.OnArticleClicked(index))
//        }
//    }

    private val usersService: UsersService
        get() = (requireActivity().applicationContext as App).usersService



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        with(binding) {


            adapter = UsersAdapter(object : UserActionListener {
                override fun onUserMove(user: ArticleModel, moveBy: Int) {

                }

                override fun onUserDelete(user: ArticleModel) {
                    Log.d("TAGG", "${user.name} delete")
                }

                override fun onUserDetails(user: ArticleModel) {
                    Log.d("TAGG", "${user.title}")
                }
            })

            rvArticlesMain.adapter = adapter



            usersService.addListener(usersListener)

            bnvBarMain.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.itemBookmarks -> {
                        findNavController().navigate(R.id.bookmarksFragment)
                    }
                    R.id.itemSearch -> {
                        findNavController().navigate(R.id.searchScreenFragment)
                    }
                    else -> {}
                }
                true
            }
            bnvBarMain.selectedItemId = R.id.itemMain
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(R.id.bookmarksFragment)
        }

    }

    private fun render(viewState: ViewState) {
        when (viewState.state) {
            State.Load -> {
            }
            State.Content -> {
//                adapter.setData(viewState.articlesShown)
            }
            State.Error -> {
            }
            State.DetailLoad -> {
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        usersService.removeListener(usersListener)
    }

    private val usersListener: UsersListener = {
        adapter.users = it
    }

}