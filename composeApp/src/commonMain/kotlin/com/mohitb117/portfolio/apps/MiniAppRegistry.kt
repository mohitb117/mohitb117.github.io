package com.mohitb117.portfolio.apps

import androidx.compose.runtime.Composable

data class PortfolioMiniApp(
    val id: String,
    val title: String,
    val subtitle: String,
    val badge: String,
    val companyLogoUrl: String,
    val content: @Composable () -> Unit
)

/**
 * Single-file registry for all 6 Compose Multiplatform portfolio mini-apps.
 */
object MiniAppRegistry {
    val apps = listOf(
        PortfolioMiniApp(
            id = "career-explorer",
            title = "Career & Skill Explorer",
            subtitle = "Interactive Material 3 timeline with company logos & skill filtering",
            badge = "All Roles",
            companyLogoUrl = "/images/DoorDash_Logo.svg.png",
            content = { CareerExplorerApp() }
        ),
        PortfolioMiniApp(
            id = "sdui-playground",
            title = "SDUI & Hardware Studio",
            subtitle = "DoorDash Order Confirmation UI, Dynamic Delivery & Hardware Peripherals",
            badge = "DoorDash",
            companyLogoUrl = "/images/DoorDash_Logo.svg.png",
            content = { SduiPlaygroundApp() }
        ),
        PortfolioMiniApp(
            id = "webrtc-telemetry",
            title = "WebRTC Telemetry Simulator",
            subtitle = "Amazon Care Telehealth MOS scoring & adaptive bitrate (US11038933B1)",
            badge = "Amazon Care",
            companyLogoUrl = "/images/amazon-care.webp",
            content = { WebRtcSimulatorApp() }
        ),
        PortfolioMiniApp(
            id = "silk-firetv",
            title = "Silk Fire TV Virtual Cursor",
            subtitle = "10-Foot Fire TV browser viewport & heuristic D-Pad remote (20M+ devices)",
            badge = "Amazon Silk",
            companyLogoUrl = "/images/Amazon_Silk_Logo.webp",
            content = { SilkFireTvApp() }
        ),
        PortfolioMiniApp(
            id = "flex-jvm",
            title = "Flex JVM Memory Profiler",
            subtitle = "Android Runtime heap telemetry, GC pause latency & OOM mitigation",
            badge = "Amazon Flex",
            companyLogoUrl = "/images/Amazon_icon.svg.png",
            content = { FlexJvmProfilerApp() }
        ),
        PortfolioMiniApp(
            id = "foodfeed-inrix",
            title = "FoodFeed & Connected Car SDK",
            subtitle = "PNNL 1st Place DOE FoodFeed bio-surveillance & INRIX vehicle telemetry",
            badge = "PNNL & INRIX",
            companyLogoUrl = "/images/PNNL_CENTER_FullColorSMALL.jpg",
            content = { FoodFeedCarApp() }
        )
    )
}
