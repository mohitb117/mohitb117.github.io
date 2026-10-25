package com.mohitb117.portfolio.apps

import androidx.compose.runtime.Composable

data class PortfolioMiniApp(
    val id: String,
    val title: String,
    val subtitle: String,
    val badge: String,
    val content: @Composable () -> Unit
)

/**
 * Single-file registry for adding new Compose Multiplatform mini-apps to the portfolio.
 * To add a new app, create a @Composable function and register an entry in [apps].
 */
object MiniAppRegistry {
    val apps = listOf(
        PortfolioMiniApp(
            id = "career-explorer",
            title = "Career & Skill Explorer",
            subtitle = "Interactive Material 3 timeline with live skill & deliverable filtering",
            badge = "CMP Flagship",
            content = { CareerExplorerApp() }
        ),
        PortfolioMiniApp(
            id = "sdui-playground",
            title = "Server-Driven UI (SDUI) Studio",
            subtitle = "Toggle backend JSON schema nodes & preview live Compose rendering",
            badge = "DoorDash Architecture",
            content = { SduiPlaygroundApp() }
        ),
        PortfolioMiniApp(
            id = "webrtc-telemetry",
            title = "WebRTC Telemetry Simulator",
            subtitle = "Real-time MOS quality scoring & adaptive media controller (US11038933B1)",
            badge = "US Patent",
            content = { WebRtcSimulatorApp() }
        )
    )
}
