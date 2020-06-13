package app.siatechtask.utils

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import app.siatechtask.R

class ViewBounceAnimation {
    companion object{
        fun bounceAnimation(mContext: Context): Animation {
            val anim = AnimationUtils.loadAnimation(mContext, R.anim.bounce_animation)
            anim.interpolator = BounceInterpolator(0.2, 20.0)
            return anim
        }
    }

}