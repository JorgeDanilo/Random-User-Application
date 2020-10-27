package com.example.randomuserapplication.app.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.randomuserapplication.R
import com.example.randomuserapplication.extensions.convertDpToPx
import com.example.randomuserapplication.utils.RoundedCornersTransformation

@BindingAdapter(
    "bind:imageUrl",
    "bind:cornerSize",
    requireAll = false
)
fun ImageView.imageFromUrl(
    imageUrl: String?,
    cornerSize: Int?
) {
    if (cornerSize != null) {
        loadRoundedImageView(
            this,
            imageUrl,
            cornerSize,
            RoundedCornersTransformation.CornerType.ALL
        )
    } else {
        loadImageView(this, imageUrl)
    }
}

fun loadImageView(imageView: ImageView, imageUrl: String?) {
    Glide.with(imageView.context)
        .load(imageUrl)
        .placeholder(R.drawable.placeholder)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .apply(RequestOptions().dontTransform())
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(imageView)
}

fun loadRoundedImageView(
    imageView: ImageView,
    imageUrl: String?,
    round: Int,
    cornerType: RoundedCornersTransformation.CornerType?
) {
    Glide.with(imageView.context)
        .load(imageUrl)
        .placeholder(R.drawable.placeholder)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .apply(RequestOptions().dontTransform())
        .transform(
            CenterCrop(), RoundedCornersTransformation(
                round.convertDpToPx(imageView.resources.displayMetrics).toFloat(),
                0f, cornerType
            )
        )
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(imageView)
}
