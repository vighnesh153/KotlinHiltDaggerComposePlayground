package com.example.playground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.fragment.app.Fragment
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
@HiltAndroidTest
class SampleTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val rule = createComposeRule()

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun sampleTest() {
        launchFragmentInHiltContainer<BlaFragment>()

        rule.waitForIdle()

//        rule.onNodeWithTag("button").performSemanticsAction(SemanticsActions.RequestFocus)
//
//        rule.waitForIdle()

        rule.onNodeWithTag("button").assertIsFocused()
    }
}

class BlaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
//                SampleScreen()
                Buttons()
            }
        }
    }
}
