package com.android.truelogic.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterResponse(
    @Json(name = "char_id")
    val id: Long?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "nickname")
    val nickname: String?,
    @Json(name = "img")
    val imageUrl: String?
)