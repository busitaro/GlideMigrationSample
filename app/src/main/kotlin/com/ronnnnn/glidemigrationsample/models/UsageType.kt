package com.ronnnnn.glidemigrationsample.models

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ronnnnn.glidemigrationsample.R
import java.io.Serializable

/**
 * Created by kokushiseiya on 2017/06/17.
 */
enum class UsageType(val contentType: ContentType) : Serializable {
    BasicUsage(ContentType.Photo),
    Placeholder(ContentType.Photo) {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .into(imageView)
        }
    },
    Error(ContentType.Photo) {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .error(R.drawable.image_error)
                    .into(imageView)
        }
    },
    CrossFade(ContentType.Photo) {
        // same behavior with "Placeholder" section
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .crossFade()
                    .into(imageView)
        }
    },
    CrossFadeWithDuration(ContentType.Photo) {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .crossFade(1000) // default duration is 300
                    .into(imageView)
        }
    },
    NotAnimate(ContentType.Photo) {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .dontAnimate()
                    .into(imageView)
        }
    },
    Resize(ContentType.Photo) {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .override(200, 200) // resize image (in pixel) not ImageView before displaying in the target
                    .into(imageView)
        }
    },
    CenterCrop(ContentType.Photo) {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .centerCrop()
                    .into(imageView)
        }
    },
    FitCenter(ContentType.Photo) {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .fitCenter()
                    .into(imageView)
        }
    },
    Gif(ContentType.Gif) {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .into(imageView)
        }
    },
    GifOnly(ContentType.Gif) {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .asGif()
                    .placeholder(R.drawable.image_placeholder)
                    .error(R.drawable.image_error) // this error will be called the source is not gif
                    .into(imageView)
        }
    },
    FastLoadGif(ContentType.Gif) {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(imageView)
        }
    },
    GifAsBitmap(ContentType.Gif) {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            Glide.with(context)
                    .load(imageString)
                    .asBitmap() // gif will show as a regular image even if the url ends with .gif
                    .placeholder(R.drawable.image_placeholder)
                    .into(imageView)
        }
    }
    ;

    open fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
        Glide.with(context)
                .load(imageString)
                .into(imageView)
    }
}