package com.mohitb117.portfolio

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val rootElement = document.getElementById("compose-wasm-viewport") ?: document.body!!
    ComposeViewport(rootElement) {
        PortfolioApp()
    }
}
