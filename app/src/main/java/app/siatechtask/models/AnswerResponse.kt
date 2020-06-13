package app.siatechtask.models


import com.google.gson.annotations.SerializedName

data class AnswerResponse(
    @SerializedName("answer")
    val answer: String = "",
    @SerializedName("image")
    val image: String = "",
    @SerializedName("type")
    val type: String = ""
)