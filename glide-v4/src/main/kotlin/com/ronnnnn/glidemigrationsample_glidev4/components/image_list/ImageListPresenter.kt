package com.ronnnnn.glidemigrationsample_glidev4.components.image_list

import com.ronnnnn.glidemigrationsample_glidev4.models.Gif
import com.ronnnnn.glidemigrationsample_glidev4.models.Photo
import com.ronnnnn.glidemigrationsample_glidev4.use_case.LoadImageUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by kokushiseiya on 2017/06/18.
 */
class ImageListPresenter(private val imageListView: ImageListView) {

    private val useCase = LoadImageUseCase()

    fun getRecentPhotos() {
        useCase.getRecentPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { imageListView.toggleProgressVisibility(true) }
                .doOnSuccess { imageListView.toggleProgressVisibility(false) }
                .doOnError { imageListView.toggleProgressVisibility(false) }
                .subscribe({ photos ->
                    imageListView.setPhotos(photos)
                }, { throwable ->
                    Timber.e(throwable)
                })
    }

    fun getTrendingGifs() {
        useCase.getTrendingGifs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { imageListView.toggleProgressVisibility(true) }
                .doOnSuccess { imageListView.toggleProgressVisibility(false) }
                .doOnError { imageListView.toggleProgressVisibility(false) }
                .subscribe({ gifs ->
                    imageListView.setGifs(gifs)
                }, { throwable ->
                    Timber.e(throwable)
                })
    }

    interface ImageListView {
        fun toggleProgressVisibility(isVisible: Boolean)

        fun setPhotos(photoList: List<Photo>)

        fun setGifs(gifList: List<Gif>)
    }
}