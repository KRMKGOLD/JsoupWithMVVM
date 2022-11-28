package kr.co.cotton.myapplication

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String) {
    if (url.isNotBlank()) {
        Glide.with(this).load(url).into(this);
    }
}