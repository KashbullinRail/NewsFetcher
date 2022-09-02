package com.example.newsfetcher.base

import com.example.newsfetcher.base.Either.*

inline fun <reified T> attempt(func: () -> T): Either<Throwable, T> = try {
    Right(func.invoke())
} catch (e: Throwable) {
    Left(e)
}