package com.example.composepractice.presentation

import androidx.compose.animation.Animatable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import  androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composepractice.presentation.components.HomeEvents
import com.example.composepractice.presentation.components.EditedTextField
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(viewModel: HomeViewModel =viewModel()) {

    val scope= rememberCoroutineScope()

    val animateColor= remember {Animatable(
        Color(0xFFFFFFFF)
    )}
    val target={
        when(viewModel.state.value.text){
            "black" -> {Color.Black}
            "blue" -> {Color.Blue}
            "red" -> {Color.Red}
            "gray" -> {Color.Gray}
            "white" -> {Color.White}
            "green" -> {Color.Green}
            "yellow" -> {Color.Yellow}
            else-> Color.White
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(animateColor.value),
        contentAlignment = Alignment.Center
    ) {
        Column {

            EditedTextField(
                value =  if (!viewModel.state.value.isHintVisible){
                    viewModel.state.value.text.lowercase()
                }else {
                    viewModel.state.value.hint
                },
                onValueChange = {
                    viewModel.onEvent(HomeEvents.EnterText(it))
                },
                onFocusChange = {
                    viewModel.onEvent(HomeEvents.FocusText(it))
                },
                style = TextStyle(
                    color = if (animateColor.value == Color.Black) Color.White
                            else Color.Black)
            )
            Spacer(modifier = Modifier.height(8.dp))

            AnimatedVisibility(visible = viewModel.state.value.text.length>2) {
                Button(
                    onClick = {
                        scope.launch {
                            animateColor.animateTo(
                                animationSpec = tween(500),
                                targetValue = target.invoke()
                            )
                        }
                    }
                ) {
                    Text(
                        text = "Run",
                        fontSize = 30.sp)
                }
            }
        }
    }
}
