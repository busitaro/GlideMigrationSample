package com.ronnnnn.glidemigrationsample_glidev42.models

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.graphics.Palette
import android.widget.ImageView
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.bumptech.glide.request.transition.ViewPropertyTransition
import com.ronnnnn.glidemigrationsample_glidev42.GlideApp
import com.ronnnnn.glidemigrationsample_glidev42.R
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.GrayscaleTransformation
import java.io.Serializable

/**
 * Created by kokushiseiya on 2017/06/17.
 */
enum class UsageType(val contentType: ContentType, val title: String, val subTitle: String, val mdFileName: String) : Serializable {
    BasicUsage(
            ContentType.Photo,
            "Basic Usage",
            "Basic usage for Glide V4",
            "v42_basic_usage.md"
    ),
    Placeholder(
            ContentType.Photo,
            "Placeholder",
            "How to set placeholder when loading an image",
            "v42_placeholder.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .into(imageView)
        }
    },
    Error(
            ContentType.Photo,
            "Error",
            "How to set an error image when loading is failed",
            "v42_error.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .error(R.drawable.image_error)
                    .into(imageView)
        }
    },
    CrossFade(
            ContentType.Photo,
            "Cross Fade",
            "How to set cross fade between a loaded image and placeholder",
            "v42_cross_fade.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(imageView)
        }
    },
    CrossFadeWithDuration(
            ContentType.Photo,
            "Cross Fade",
            "How to customize cross fade duration",
            "v42_cross_fade_with_duration.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .transition(DrawableTransitionOptions.withCrossFade(1000)) // default duration is 300
                    .into(imageView)
        }
    },
    NoTransition(
            ContentType.Photo,
            "No Transition",
            "How to reject any transitions",
            "v42_no_transition.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .transition(GenericTransitionOptions.withNoTransition())
                    .into(imageView)
        }
    },
    Resize(
            ContentType.Photo,
            "Resize",
            "How to resize a loading image resource",
            "v42_resize.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .override(200, 200) // resize image (in pixel) not ImageView before displaying in the target
                    .into(imageView)
        }
    },
    CenterCrop(
            ContentType.Photo,
            "Center Crop",
            "How to crop an image with CenterCrop",
            "v42_center_crop.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .centerCrop()
                    .into(imageView)
        }
    },
    FitCenter(
            ContentType.Photo,
            "Fit Center",
            "How to crop an image with FitCenter",
            "v42_fit_center.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .fitCenter()
                    .into(imageView)
        }
    },
    CircleCrop(
            ContentType.Photo,
            "Circle Crop",
            "How to crop an image with CircleCrop",
            "v42_circle_crop.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .circleCrop()
                    .into(imageView)
        }
    },
    Gif(
            ContentType.Gif,
            "Gif",
            "How to set gif",
            "v42_gif.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .into(imageView)
        }
    },
    GifOnly(
            ContentType.Gif,
            "Gif Only",
            "How to show only gif",
            "v42_gif_only.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .asGif()
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .error(R.drawable.image_error) // this error will be called the source is not gif
                    .into(imageView)
        }
    },
    FastLoadGif(
            ContentType.Gif,
            "Fast Load Gif",
            "How to load gif faster",
            "v42_fast_load_gif.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(imageView)
        }
    },
    GifAsBitmap(
            ContentType.Gif,
            "Gif as Bitmap",
            "How to load gif as Bitmap",
            "v42_gif_as_bitmap.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .asBitmap() // gif will show as a regular image even if the url ends with .gif
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .into(imageView)
        }
    },
    NotAnimateGif(
            ContentType.Gif,
            "Not Animate Gif",
            "How to load gif with no animate",
            "v42_not_animate.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .dontAnimate()
                    .into(imageView)
        }
    },
    NoMemoryCache(
            ContentType.Photo,
            "No Memory Cache",
            "How to store only disk cache",
            "v42_no_memory_cache.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .skipMemoryCache(true) // default is false
                    .into(imageView)
        }
    },
    NoDiskCache(
            ContentType.Photo,
            "No Disk Cache",
            "How to store only memory cache",
            "v42_no_disk_cache.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.NONE) // default is RESULT
                    .into(imageView)
        }
    },
    NoCache(
            ContentType.Photo,
            "No Cache",
            "How to reject storing cache",
            "v42_no_cache.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(imageView)
        }
    },
    CacheOriginalImage(
            ContentType.Photo,
            "Cache Original Image",
            "How to cache original image resource",
            "v42_cache_original_image.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(imageView)
        }
    },
    ImageRequestPriority(
            ContentType.Photo,
            "Image Request Priority",
            "How to set priority of requesting images",
            "v42_image_request_priority.md"
    ),
    BitmapTarget(
            ContentType.Photo,
            "Bitmap Target",
            "How to process an image loaded as Bitmap",
            "v42_bitmap_target.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            val target = object : SimpleTarget<Bitmap>() {
                override fun onLoadStarted(placeholder: Drawable?) {
                    imageView.setImageDrawable(placeholder)
                }

                override fun onResourceReady(resource: Bitmap?, transition: Transition<in Bitmap>?) {
                    Palette.from(resource).generate { palette ->
                        val color = palette?.getVibrantColor(ContextCompat.getColor(context, R.color.color_primary))
                                ?: ContextCompat.getColor(context, R.color.color_primary)
                        imageView.setImageBitmap(resource)
                        imageView.setColorFilter(color)
                    }
                }
            }

            GlideApp.with(context)
                    .asBitmap()
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .into(target)
        }
    },
    SpecificSizeTarget(
            ContentType.Photo,
            "Specific Size Target",
            "How to process an image in specific size",
            "v42_specific_size_target.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            val target = object : SimpleTarget<Bitmap>(200, 200) {
                override fun onLoadStarted(placeholder: Drawable?) {
                    imageView.setImageDrawable(placeholder)
                }

                override fun onResourceReady(resource: Bitmap?, transition: Transition<in Bitmap>?) {
                    imageView.setImageBitmap(resource)
                }
            }

            GlideApp.with(context)
                    .asBitmap()
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .into(target)
        }
    },
    CustomTransformation(
            ContentType.Photo,
            "Custom Transformation",
            "How to customize transformation of a loaded image",
            "v42_custom_transformation.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .transform(BlurTransformation(10))
                    .into(imageView)
        }
    },
    MultiTransformations(
            ContentType.Photo,
            "Multiple Transformations",
            "How to set multiple transformations",
            "v42_multi_transformations.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .transforms(GrayscaleTransformation(), BlurTransformation(10))
                    .into(imageView)
        }
    },
    SlideInAnimation(
            ContentType.Photo,
            "Animation",
            "How to show an image with slide in animation",
            "v42_slide_in_animation.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .transition(DrawableTransitionOptions().transition(android.R.anim.slide_in_left))
                    .into(imageView)
        }
    },
    ZoomInAnimation(
            ContentType.Photo,
            "Animation",
            "How to show an image with zoom in animation",
            "v42_zoom_in_animation.md") {
        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .transition(DrawableTransitionOptions().transition(R.anim.zoom_in))
                    .into(imageView)
        }
    },
    CustomClassAnimation(
            ContentType.Photo,
            "Animation",
            "How to show an image with custom animation class",
            "v42_custom_class_animation.md") {
        val animationObject = ViewPropertyTransition.Animator { view ->
            view.alpha = 0f

            ObjectAnimator.ofFloat(view, "alpha", 0f, 1f).apply {
                duration = 300
            }.start()
        }

        override fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
            GlideApp.with(context)
                    .load(imageString)
                    .placeholder(R.drawable.image_placeholder)
                    .transition(DrawableTransitionOptions().transition(animationObject)) // this animation affect not only ImageView but also whole View
                    .into(imageView)
        }
    },
    ShapeImageViewWithBadPractice(
            ContentType.Photo,
            "Shape ImageView",
            "A bad practice of showing an image in shaped ImageView",
            "v42_shape_image_view_with_bad_practice.md"
    ),
    ShapeImageViewWithGoodPractice(
            ContentType.Photo,
            "Shape ImageView",
            "A good practice of showing an image in shaped ImageView",
            "v42_shape_image_view_with_good_practice.md"
    ),
    TransparentImageWithBadPractice(
            ContentType.Photo,
            "Transparent Image",
            "A bad practice of showing a particle transparent image",
            "v42_transparent_image_with_bad_practice.md"
    ),
    TransparentImageWithGoodPractice(
            ContentType.Photo,
            "Transparent Image",
            "A good practice of showing a particle transparent image",
            "v42_transparent_image_with_good_practice.md"
    )
    ;

    open fun loadWithGlide(context: Context, imageView: ImageView, imageString: String) {
        GlideApp.with(context)
                .load(imageString)
                .into(imageView)
    }
}