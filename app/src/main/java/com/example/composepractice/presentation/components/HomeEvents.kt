package com.example.composepractice.presentation.components

import androidx.compose.ui.focus.FocusState

sealed class HomeEvents {
    data class EnterText(val value: String): HomeEvents()
    data class FocusText(val focusState: FocusState): HomeEvents()
}