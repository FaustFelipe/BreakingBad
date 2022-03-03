package com.android.truelogic.data

import com.android.truelogic.data.api.BreakingBadApi
import com.android.truelogic.data.model.CharacterResponse
import com.android.truelogic.data.repository.BreakingBadRepositoryImpl
import com.android.truelogic.domain.models.Character
import com.android.truelogic.domain.utils.ErrorEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.times
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever
import retrofit2.Response
import kotlin.test.assertEquals
import com.android.truelogic.domain.utils.Result
import kotlinx.coroutines.flow.first
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class BreakingBadRepositoryImplTest {

    @Mock
    private lateinit var doAppApi: BreakingBadApi

    private lateinit var repository: BreakingBadRepositoryImpl
    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun `before each test`() {
        repository = BreakingBadRepositoryImpl(
            api = doAppApi,
            coroutineContext = dispatcher
        )
    }

    /* region signUpUser */
    @Test
    fun `calling signUpUser should return a valid Result User flow`() =
        dispatcher.runBlockingTest {
            val user = Character(id = 1L, name = "Felipe", imageUrl = "", nickname = "Felipe")
            val expected = Result.Success(listOf(user))

            whenever(doAppApi.getCharacters(10))
                .thenReturn(
                    Response.success(
                        listOf(CharacterResponse(id = 1L, name = "Felipe", imageUrl = "", nickname = "Felipe"))
                    )
                )

            val result = repository.getCharacters().first()

            verify(doAppApi, times(1)).getCharacters(10)
            verifyNoMoreInteractions(doAppApi)
            assertEquals(expected, result)
        }


    companion object {
        val ID = 1L
        val NAME = "Felipe"
        val IMAGEURL = ""
        val NICKINAME = "Felipe"
    }

}