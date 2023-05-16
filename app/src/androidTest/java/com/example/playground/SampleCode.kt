package com.example.playground

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.testTag
import androidx.tv.material3.Button
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import kotlinx.coroutines.delay

@Composable
fun ErrorScreen() {
    Row {
        val focusRequester = remember { FocusRequester() }
        val focusRequester2 = remember { FocusRequester() }

        FocusableButton(
            modifier = Modifier
                .focusRequester(focusRequester)
                .testTag("button")
        )
        FocusableButton(modifier = Modifier.focusRequester(focusRequester2))

        LaunchedEffect(Unit) {
            delay(300)
            focusRequester.requestFocus()
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun FocusableButton(modifier: Modifier) {
    Button(modifier = modifier, onClick = { }) {
        Text(text = "RIGHT")
    }
}