package com.android.truelogic.data.api

import com.android.truelogic.data.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BreakingBadApi {

    @GET("api/characters")
    fun getCharacters(@Query("limit") limit: Int): Response<List<CharacterResponse>>

}