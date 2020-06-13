package app.siatechtask.utils

class BounceInterpolator(val mAmplitude: Double = 1.0, val mFrequency: Double = 10.0): android.view.animation.Interpolator {
    override fun getInterpolation(time: Float): Float {
        return (-1 * Math.pow(Math.E, -time/ mAmplitude) * Math.cos(mFrequency * time) + 1).toFloat()
    }
}