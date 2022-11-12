package com.example.composepractice.presentation.components

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextStyle


@Composable
fun EditedTextField(
    value: String,
    onValueChange: (String)-> Unit,
    singleLine: Boolean= true,
    onFocusChange: (FocusState)-> Unit,
    style: TextStyle
){
    TextField(
        value = value ,
        onValueChange = onValueChange,
        textStyle = style,
        singleLine= singleLine,
        modifier = Modifier
            .onFocusChanged {
                onFocusChange(it)
            }
    )
}