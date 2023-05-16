package com.example.playground

import android.util.Log
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.platform.testTag
import kotlinx.coroutines.delay
import androidx.tv.material3.Button
import androidx.tv.material3.Text
import androidx.tv.material3.ExperimentalTvMaterial3Api

@Composable
fun SampleScreen() {
    var show by remember { mutableStateOf(false) }

    if (show) {
        Buttons()
    }

    LaunchedEffect(Unit) {
        show = true
    }
}

@Composable
fun Buttons() {
    Row {
        val focusRequester = remember { FocusRequester() }
        val focusRequester2 = remember { FocusRequester() }

        FocusableButton(
            modifier = Modifier
                .onGloballyPositioned {
                    focusRequester.requestFocus()
                }
                .focusRequester(focusRequester)
                .testTag("button")
        )
        FocusableButton(modifier = Modifier.focusRequester(focusRequester2))

        LaunchedEffect(Unit) {
            Log.d("Pikachu", "Buttons: Inside LaunchedEffect")
            focusRequester.requestFocus()
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun FocusableButton(modifier: Modifier) {
//    Box(modifier = modifier.focusable()) {
//        Text(text = "RIGHT")
//    }
    Button(modifier = modifier, onClick = { }) {
        Text(text = "RIGHT")
    }
}