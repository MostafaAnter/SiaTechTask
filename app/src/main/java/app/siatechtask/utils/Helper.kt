package app.siatechtask.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import app.siatechtask.R
import com.bumptech.glide.Glide.with
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions


class Helper {
    companion object{
        @JvmStatic
        @BindingAdapter(value = ["imageUrl", "error"], requireAll = false)
        fun loadImage(view: ImageView, imageUrl: String?, error: Int) {
            if (!imageUrl.isNullOrEmpty()) {
                with(view.context)
                    .setDefaultRequestOptions(
                        RequestOptions()
                            .placeholder(R.drawable.white_background)
                            .error(R.drawable.white_background))
                    .load(imageUrl)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(view)
            }
        }


        fun hideSoftKeyboard(mContext: Context, editText: EditText) {
            if ((mContext as Activity).currentFocus != null && (mContext as Activity).currentFocus is EditText) {
                val imm: InputMethodManager =
                    mContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(editText.windowToken, 0)
            }
        }
    }
}