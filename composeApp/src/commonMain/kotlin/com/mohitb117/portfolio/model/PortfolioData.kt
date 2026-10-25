package com.mohitb117.portfolio.model

data class DeliverableItem(
    val title: String,
    val subtitle: String,
    val architectureNotes: String,
    val skills: List<String>,
    val badge: String? = null
)

data class CareerStage(
    val stepNumber: Int,
    val stageTitle: String,
    val organization: String,
    val roleTitle: String,
    val period: String,
    val brandHex: Long,
    val deliverables: List<DeliverableItem>
)

object PortfolioRepository {
    val allSkills = listOf(
        "All Skills",
        "Android & Jetpack Compose",
        "Kotlin & Coroutines",
        "Server-Driven UI (SDUI)",
        "WebRTC & Real-Time Media",
        "AWS & Cloud",
        "Hardware Peripherals",
        "CI & Visual Regression",
        "Mobile Technical Leadership"
    )

    val careerStages = listOf(
        CareerStage(
            stepNumber = 4,
            stageTitle = "CURRENT ROLE: DOORDASH",
            organization = "DoorDash",
            roleTitle = "Senior Software Engineer | Mobile Technical Lead",
            period = "Nov 2021 – Present (5 yrs)",
            brandHex = 0xFFFF3008,
            deliverables = listOf(
                DeliverableItem(
                    title = "Order Confirmation UI",
                    subtitle = "Built from scratch with full Android & iOS parity",
                    architectureNotes = "Architected reactive state machine and extensible surface for real-time ETA updates, multi-store order tracking, and promotional placements across millions of daily orders.",
                    skills = listOf("Android & Jetpack Compose", "Kotlin & Coroutines", "Mobile Technical Leadership"),
                    badge = "Millions Daily Orders"
                ),
                DeliverableItem(
                    title = "Dynamic Delivery Options",
                    subtitle = "Backend-driven zero-release delivery window experimentation",
                    architectureNotes = "Orchestrated backend configuration schemas with reactive Android UI logic and led cross-platform iOS adoption.",
                    skills = listOf("Server-Driven UI (SDUI)", "Kotlin & Coroutines", "Mobile Technical Leadership"),
                    badge = "Zero-Release Experimentation"
                ),
                DeliverableItem(
                    title = "Hardware Integration (Hardware Peripherals)",
                    subtitle = "Connected external hardware peripherals & fulfillment devices",
                    architectureNotes = "Engineered low-latency peripheral discovery, connection resilience, and hardware telemetry pipelines.",
                    skills = listOf("Hardware Peripherals", "Android & Jetpack Compose", "Kotlin & Coroutines"),
                    badge = "Hardware Peripherals"
                ),
                DeliverableItem(
                    title = "CI Build Time & Visual Regression Testing",
                    subtitle = "Automated Jetpack Compose screenshot testing & build velocity",
                    architectureNotes = "Instituted automated Compose visual regression testing pipelines and modular build optimizations to cut PR turnaround times.",
                    skills = listOf("CI & Visual Regression", "Android & Jetpack Compose", "Mobile Technical Leadership"),
                    badge = "Developer Velocity"
                )
            )
        ),
        CareerStage(
            stepNumber = 3,
            stageTitle = "AMAZON",
            organization = "Amazon (Care, Silk, Flex)",
            roleTitle = "Senior Software Engineer",
            period = "Dec 2015 – Nov 2021 (6 yrs)",
            brandHex = 0xFFFF9900,
            deliverables = listOf(
                DeliverableItem(
                    title = "Amazon Care: Telehealth Audio/Video Engine",
                    subtitle = "Video / Audio & App Platform Engineer",
                    architectureNotes = "Built low-latency WebRTC telehealth conferencing engine with real-time packet-loss/jitter telemetry and dynamic bitrate adaptation.",
                    skills = listOf("WebRTC & Real-Time Media", "Kotlin & Coroutines", "AWS & Cloud", "Mobile Technical Leadership"),
                    badge = "Patent US11038933B1"
                ),
                DeliverableItem(
                    title = "Amazon Silk: Fire TV Browser Lead",
                    subtitle = "10-Foot TV Web Browser & Virtual Cursor (20M+ Devices)",
                    architectureNotes = "Engineered Chromium-backed Leanback UI, HomeMenu launcher, and heuristic D-pad virtual cursor navigation across 20M+ Fire TV devices.",
                    skills = listOf("Android & Jetpack Compose", "Mobile Technical Leadership"),
                    badge = "20M+ Devices"
                ),
                DeliverableItem(
                    title = "Amazon Flex: JVM Performance Optimization",
                    subtitle = "Memory profiling & garbage collection tuning at scale",
                    architectureNotes = "Built in-app memory telemetry profiler and eliminated systemic OOM crashes across delivery driver fleet devices.",
                    skills = listOf("Kotlin & Coroutines", "Android & Jetpack Compose"),
                    badge = "JVM & GC Tuning"
                )
            )
        ),
        CareerStage(
            stepNumber = 2,
            stageTitle = "RESEARCH & EARLY CAREER",
            organization = "PNNL (US Dept. of Energy) & INRIX",
            roleTitle = "Software Dev Engineer",
            period = "2013 – 2015",
            brandHex = 0xFF0D9488,
            deliverables = listOf(
                DeliverableItem(
                    title = "PNNL: FoodFeed Food Health App",
                    subtitle = "1st Place Winner – DOE Mobile Challenge",
                    architectureNotes = "Primary developer for the FoodFeed food health & bio-surveillance Android platform with real-time Java EE backend push sync.",
                    skills = listOf("Android & Jetpack Compose", "AWS & Cloud"),
                    badge = "1st Place DOE Winner"
                ),
                DeliverableItem(
                    title = "INRIX: Connected Car Mobility SDK",
                    subtitle = "Real-time traffic & connected vehicle navigation SDK",
                    architectureNotes = "Engineered mobile telemetry and route intelligence SDKs powering automotive OEM head-units and consumer navigation apps.",
                    skills = listOf("Android & Jetpack Compose", "Hardware Peripherals"),
                    badge = "Connected Car SDK"
                )
            )
        ),
        CareerStage(
            stepNumber = 1,
            stageTitle = "EDUCATION",
            organization = "Syracuse University & GGSIU",
            roleTitle = "M.S. Computer Engineering • B.Tech Computer Science",
            period = "2008 – 2014",
            brandHex = 0xFFEA580C,
            deliverables = listOf(
                DeliverableItem(
                    title = "Syracuse University — M.S. Computer Engineering",
                    subtitle = "Focus: Software Engineering & Mobile Systems (GPA: 3.55/4.0)",
                    architectureNotes = "Awarded 50% Graduate Merit Scholarship for academic excellence in mobile systems and software architecture.",
                    skills = listOf("Android & Jetpack Compose", "Kotlin & Coroutines"),
                    badge = "Merit Scholar"
                ),
                DeliverableItem(
                    title = "GGSIU — B.Tech Computer Science",
                    subtitle = "First Division with Distinction (GPA: 3.97/4.0)",
                    architectureNotes = "2nd Place Winner in IEEE India INNOVISION Linux Systems Challenge.",
                    skills = listOf("Android & Jetpack Compose"),
                    badge = "GPA 3.97/4.0"
                )
            )
        )
    )
}
