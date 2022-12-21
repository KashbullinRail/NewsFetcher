package com.example.newsfetcher.feature.detailscreen.domain

import com.example.newsfetcher.base.Either
import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.detailscreen.data.DetailRepository
import com.example.newsfetcher.feature.main_screen.domian.ArticleModel


class DetailInteractor(private val detailRepository: DetailRepository) {

    suspend fun create(model: ArticleModel) {
        attempt { detailRepository.create(model) }
    }

    suspend fun read(): Either<Throwable, List<ArticleModel>> {
        return attempt { detailRepository.read() }
    }

    suspend fun update(model: ArticleModel) {
        attempt { detailRepository.update(model) }
    }

    suspend fun delete(model: ArticleModel) {
        attempt { detailRepository.delete(model) }
    }

}