package com.android.truelogic.data.model.mappers

import com.android.truelogic.data.model.CharacterResponse
import com.android.truelogic.domain.models.Character

object CharacterMapper {

    fun map(characterResponse: CharacterResponse?) = Character(
        id = characterResponse?.id ?: -1L,
        name = characterResponse?.name ?: "",
        imageUrl = characterResponse?.imageUrl ?: "",
        nickname = characterResponse?.nickname ?: ""
    )

}