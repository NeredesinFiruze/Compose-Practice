package com.example.composepractice.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composepractice.presentation.components.HomeEvents
import com.example.composepractice.presentation.components.HomeStateField


class HomeViewModel:ViewModel() {

    private val _state= mutableStateOf(HomeStateField(hint = "choose a color... etc: green"))
    val state: State<HomeStateField> = _state

    fun onEvent(events: HomeEvents){
        when(events){
            is HomeEvents.EnterText -> {
                _state.value= state.value.copy(
                    text = events.value
                )
            }
            is HomeEvents.FocusText -> {
                _state.value=state.value.copy(
                    isHintVisible = state.value.text.isBlank() && !events.focusState.isFocused
                )
            }
        }
    }
}