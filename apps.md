---
layout: default
title: CMP Apps & Playground
description: Interactive Compose Multiplatform (Kotlin/Wasm) Portfolio Shell, Server-Driven UI (SDUI) Studio, and WebRTC Telemetry Simulator.
permalink: /apps/
---

<style>
  .cmp-hero-banner {
    background: var(--surface-container);
    border: 1px solid var(--outline-variant);
    border-radius: var(--shape-lg);
    padding: 1.35rem 1.5rem;
    margin-bottom: 1.25rem;
    box-shadow: var(--elevation-1);
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    justify-content: space-between;
    gap: 1rem;
  }

  .cmp-hero-left {
    flex: 1;
    min-width: 280px;
  }

  .cmp-badge-row {
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    gap: 0.5rem;
    margin-bottom: 0.5rem;
  }

  .cmp-pill {
    display: inline-flex;
    align-items: center;
    gap: 0.35rem;
    padding: 0.25rem 0.7rem;
    border-radius: 999px;
    font-size: 0.75rem;
    font-weight: 700;
    background: var(--primary-bg);
    color: var(--primary);
    border: 1px solid var(--outline);
  }

  .cmp-hero-title {
    font-size: 1.45rem;
    font-weight: 800;
    color: var(--on-surface);
    line-height: 1.2;
    margin-bottom: 0.35rem;
  }

  .cmp-hero-sub {
    font-size: 0.92rem;
    color: var(--on-surface-variant);
    margin-bottom: 0.65rem;
  }

  .cmp-cli-bar {
    display: inline-flex;
    align-items: center;
    gap: 0.5rem;
    font-family: var(--font-mono);
    font-size: 0.76rem;
    background: var(--surface-container-low);
    color: var(--on-surface);
    padding: 0.4rem 0.8rem;
    border-radius: 10px;
    border: 1px solid var(--outline-variant);
  }

  /* App Switcher Tabs */
  .cmp-shell-card {
    background: var(--surface-container);
    border: 1.5px solid var(--outline);
    border-radius: var(--shape-lg);
    overflow: hidden;
    box-shadow: var(--elevation-2);
    margin-bottom: 1.5rem;
  }

  .cmp-shell-topbar {
    background: var(--surface-container-low);
    border-bottom: 1px solid var(--outline-variant);
    padding: 0.85rem 1.25rem;
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    justify-content: space-between;
    gap: 0.75rem;
  }

  .cmp-app-tabs {
    display: flex;
    flex-wrap: wrap;
    gap: 0.5rem;
  }

  .cmp-tab-btn {
    display: inline-flex;
    align-items: center;
    gap: 0.45rem;
    padding: 0.5rem 0.95rem;
    border-radius: 999px;
    border: 1px solid var(--outline);
    background: var(--surface-container);
    color: var(--on-surface-variant);
    font-size: 0.84rem;
    font-weight: 600;
    cursor: pointer;
    transition: all 0.18s ease;
  }

  .cmp-tab-btn:hover {
    border-color: var(--primary);
    color: var(--on-surface);
  }

  .cmp-tab-btn.active {
    background: var(--primary);
    color: var(--on-primary);
    border-color: var(--primary);
    font-weight: 700;
  }

  .cmp-tab-badge {
    font-size: 0.68rem;
    padding: 0.1rem 0.45rem;
    border-radius: 999px;
    background: rgba(0, 0, 0, 0.18);
    color: inherit;
  }

  .cmp-viewport-body {
    padding: 1.35rem;
  }

  /* Skill Filter Chips */
  .cmp-filter-label {
    font-size: 0.74rem;
    font-weight: 800;
    letter-spacing: 0.06em;
    text-transform: uppercase;
    color: var(--primary);
    margin-bottom: 0.55rem;
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  .cmp-skill-strip {
    display: flex;
    flex-wrap: wrap;
    gap: 0.45rem;
    margin-bottom: 1.25rem;
  }

  .cmp-skill-chip {
    padding: 0.38rem 0.82rem;
    border-radius: 999px;
    border: 1px solid var(--outline);
    background: var(--surface-container-low);
    color: var(--on-surface);
    font-size: 0.8rem;
    font-weight: 600;
    cursor: pointer;
    transition: all 0.15s ease;
  }

  .cmp-skill-chip:hover {
    border-color: var(--primary);
  }

  .cmp-skill-chip.active {
    background: var(--primary-bg);
    color: var(--primary);
    border-color: var(--primary);
    font-weight: 700;
  }

  /* Stage Cards in Career Explorer */
  .cmp-stages-grid {
    display: flex;
    flex-direction: column;
    gap: 1rem;
  }

  .cmp-stage-card {
    background: var(--surface-container-low);
    border: 1px solid var(--outline-variant);
    border-radius: 16px;
    padding: 1.15rem 1.25rem;
    transition: border-color 0.2s ease;
  }

  .cmp-stage-header {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
    align-items: flex-start;
    gap: 0.5rem;
    margin-bottom: 0.85rem;
    padding-bottom: 0.65rem;
    border-bottom: 1px solid var(--outline-variant);
  }

  .cmp-stage-step {
    font-size: 0.72rem;
    font-weight: 800;
    letter-spacing: 0.05em;
    text-transform: uppercase;
  }

  .cmp-stage-org {
    font-size: 1.18rem;
    font-weight: 800;
    color: var(--on-surface);
    line-height: 1.2;
  }

  .cmp-stage-role {
    font-size: 0.86rem;
    font-weight: 600;
    color: var(--on-surface-variant);
  }

  .cmp-stage-period {
    font-size: 0.75rem;
    font-weight: 700;
    padding: 0.25rem 0.7rem;
    border-radius: 999px;
    background: var(--surface-container);
    border: 1px solid var(--outline);
    color: var(--on-surface);
  }

  .cmp-deliverables-list {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
    gap: 0.75rem;
  }

  .cmp-deliverable-card {
    background: var(--surface-container);
    border: 1px solid var(--outline-variant);
    border-radius: 12px;
    padding: 0.9rem 1rem;
    cursor: pointer;
    transition: all 0.16s ease;
  }

  .cmp-deliverable-card:hover {
    border-color: var(--primary);
    transform: translateY(-1px);
  }

  .cmp-deliverable-top {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    gap: 0.5rem;
  }

  .cmp-deliverable-title {
    font-size: 0.94rem;
    font-weight: 700;
    color: var(--on-surface);
  }

  .cmp-deliverable-sub {
    font-size: 0.8rem;
    color: var(--on-surface-variant);
    margin-top: 0.15rem;
  }

  .cmp-deliverable-badge {
    font-size: 0.68rem;
    font-weight: 700;
    padding: 0.15rem 0.5rem;
    border-radius: 6px;
    background: var(--primary-bg);
    color: var(--primary);
    white-space: nowrap;
  }

  .cmp-deliverable-details {
    margin-top: 0.65rem;
    padding-top: 0.65rem;
    border-top: 1px dashed var(--outline-variant);
    font-size: 0.81rem;
    color: var(--on-surface);
    line-height: 1.45;
  }

  .cmp-mini-tags {
    display: flex;
    flex-wrap: wrap;
    gap: 0.35rem;
    margin-top: 0.5rem;
  }

  .cmp-mini-tag {
    font-size: 0.7rem;
    font-weight: 600;
    padding: 0.12rem 0.5rem;
    border-radius: 999px;
    background: var(--surface-container-low);
    border: 1px solid var(--outline);
    color: var(--on-surface-variant);
  }

  /* SDUI Playground Split View */
  .cmp-sdui-grid {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(310px, 1fr));
    gap: 1.25rem;
    align-items: start;
  }

  .cmp-panel-box {
    background: var(--surface-container-low);
    border: 1px solid var(--outline-variant);
    border-radius: 16px;
    padding: 1.15rem;
  }

  .cmp-json-pre {
    font-family: var(--font-mono);
    font-size: 0.76rem;
    background: #0d1117;
    color: #7ee787;
    padding: 0.9rem;
    border-radius: 12px;
    overflow-x: auto;
    line-height: 1.45;
    margin-top: 0.85rem;
    border: 1px solid #30363d;
  }

  .cmp-phone-preview {
    background: var(--phone-bezel);
    border: 3px solid var(--phone-frame-border);
    border-radius: 28px;
    padding: 1rem;
    color: #f0f6fc;
    box-shadow: var(--elevation-2);
  }

  .cmp-phone-screen {
    background: #0e1117;
    border-radius: 20px;
    padding: 1rem;
    min-height: 340px;
    display: flex;
    flex-direction: column;
    gap: 0.75rem;
  }

  /* Source Code Inspector */
  .cmp-source-card {
    background: var(--surface-container);
    border: 1px solid var(--outline-variant);
    border-radius: var(--shape-lg);
    padding: 1.25rem;
  }

  .cmp-code-block {
    font-family: var(--font-mono);
    font-size: 0.78rem;
    background: #0d1117;
    color: #e6edf3;
    padding: 1rem;
    border-radius: 12px;
    overflow-x: auto;
    line-height: 1.5;
    border: 1px solid #30363d;
    margin-top: 0.75rem;
  }
</style>

<!-- CMP Hero Header -->
<section class="cmp-hero-banner">
  <div class="cmp-hero-left">
    <div class="cmp-badge-row">
      <span class="cmp-pill">
        <span class="material-symbols-outlined" style="font-size:15px;">deployed_code</span>
        <span>Compose Multiplatform (Kotlin/Wasm)</span>
      </span>
      <span class="cmp-pill">
        <span class="material-symbols-outlined" style="font-size:15px;">widgets</span>
        <span>Material 3 Interactive Shell</span>
      </span>
    </div>
    <h1 class="cmp-hero-title">Compose Multiplatform App Playground</h1>
    <p class="cmp-hero-sub">Interactive portfolio mini-apps powered by a modular Kotlin <code>commonMain</code> architecture (<code>composeApp/</code>). Add new portfolio apps in a single entry via <code>MiniAppRegistry.kt</code>.</p>
    <div class="cmp-cli-bar">
      <span style="color:var(--primary); font-weight:700;">$</span>
      <span>./gradlew :composeApp:wasmJsBrowserDevelopmentRun</span>
    </div>
  </div>
</section>

<!-- Interactive CMP Multi-App Shell -->
<section class="cmp-shell-card">
  <div class="cmp-shell-topbar">
    <div class="cmp-app-tabs" role="tablist">
      <button type="button" class="cmp-tab-btn active" onclick="switchCmpApp('career-explorer', this)">
        <span class="material-symbols-outlined" style="font-size:18px;">timeline</span>
        <span>Career &amp; Skill Explorer</span>
        <span class="cmp-tab-badge">CMP Flagship</span>
      </button>
      <button type="button" class="cmp-tab-btn" onclick="switchCmpApp('sdui-playground', this)">
        <span class="material-symbols-outlined" style="font-size:18px;">schema</span>
        <span>SDUI Live Studio</span>
        <span class="cmp-tab-badge">DoorDash Arch</span>
      </button>
      <button type="button" class="cmp-tab-btn" onclick="switchCmpApp('webrtc-telemetry', this)">
        <span class="material-symbols-outlined" style="font-size:18px;">podcasts</span>
        <span>WebRTC Telemetry Sim</span>
        <span class="cmp-tab-badge">Patent US11038933B1</span>
      </button>
    </div>

    <a href="#cmp-kotlin-source" class="cmp-pill" style="text-decoration:none;">
      <span class="material-symbols-outlined" style="font-size:15px;">code</span>
      <span>View Kotlin Source</span>
    </a>
  </div>

  <!-- Optional Native Kotlin/Wasm Canvas Mount (auto-populates when assets/cmp/composeApp.js is built) -->
  <div id="compose-wasm-viewport" style="display:none; width:100%; height:640px;"></div>

  <!-- Interactive Material 3 Runtime Viewport -->
  <div class="cmp-viewport-body" id="cmp-interactive-host">

    <!-- ==================== APP 1: CAREER & SKILL EXPLORER ==================== -->
    <div id="cmp-app-career-explorer" class="cmp-app-pane">
      <div class="cmp-filter-label">
        <span>Filter Career Milestones &amp; Architecture by Technical Skill</span>
        <span id="cmp-match-count">Showing all 4 stages (11 deliverables)</span>
      </div>
      <div class="cmp-skill-strip" id="cmp-skill-strip"></div>
      <div class="cmp-stages-grid" id="cmp-stages-container"></div>
    </div>

    <!-- ==================== APP 2: SERVER-DRIVEN UI (SDUI) STUDIO ==================== -->
    <div id="cmp-app-sdui-playground" class="cmp-app-pane" style="display:none;">
      <div class="cmp-sdui-grid">
        <div class="cmp-panel-box">
          <div class="cmp-filter-label">
            <span>Backend SDUI Schema Controls (Zero-Release Experimentation)</span>
          </div>
          <p style="font-size:0.83rem; color:var(--on-surface-variant); margin-bottom:0.85rem;">
            Mutate backend response nodes below and watch the Compose UI tree re-render live without an app store release:
          </p>

          <label style="display:flex; align-items:center; gap:0.5rem; font-weight:600; font-size:0.88rem; margin-bottom:0.5rem; cursor:pointer;">
            <input type="checkbox" id="sdui-chk-order" checked onchange="renderSduiStudio()">
            <span>Node 1: <code>OrderConfirmationHeader</code></span>
          </label>

          <div style="margin: 0.4rem 0 0.9rem 1.5rem;">
            <label style="font-size:0.78rem; color:var(--on-surface-variant); display:block;">
              Dynamic ETA Estimate: <strong id="sdui-eta-val">26 mins</strong>
            </label>
            <input type="range" id="sdui-eta-slider" min="12" max="60" value="26" style="width:100%; accent-color:var(--primary);" oninput="renderSduiStudio()">
          </div>

          <label style="display:flex; align-items:center; gap:0.5rem; font-weight:600; font-size:0.88rem; margin-bottom:0.5rem; cursor:pointer;">
            <input type="checkbox" id="sdui-chk-delivery" checked onchange="renderSduiStudio()">
            <span>Node 2: <code>DynamicDeliveryWindowSelector</code></span>
          </label>

          <label style="display:flex; align-items:center; gap:0.5rem; font-weight:600; font-size:0.88rem; margin-bottom:0.5rem; cursor:pointer;">
            <input type="checkbox" id="sdui-chk-hardware" checked onchange="renderSduiStudio()">
            <span>Node 3: <code>HardwarePeripheralStatusBanner</code></span>
          </label>

          <pre class="cmp-json-pre" id="sdui-json-output"></pre>
        </div>

        <div class="cmp-phone-preview">
          <div style="display:flex; justify-content:space-between; align-items:center; font-size:0.72rem; color:#9aa0a6; padding:0 0.4rem 0.5rem;">
            <span>Compose Multiplatform Renderer</span>
            <span>SDUI Schema v2.4</span>
          </div>
          <div class="cmp-phone-screen" id="sdui-phone-screen"></div>
        </div>
      </div>
    </div>

    <!-- ==================== APP 3: WEBRTC TELEMETRY SIMULATOR ==================== -->
    <div id="cmp-app-webrtc-telemetry" class="cmp-app-pane" style="display:none;">
      <div class="cmp-sdui-grid">
        <div class="cmp-panel-box">
          <div class="cmp-filter-label">
            <span>WebRTC Network Impairment Controls (Patent US11038933B1)</span>
          </div>
          <p style="font-size:0.83rem; color:var(--on-surface-variant); margin-bottom:1rem;">
            Simulate real-time packet loss, jitter, and round-trip latency during an Amazon Care telehealth video call:
          </p>

          <div style="margin-bottom:0.85rem;">
            <label style="font-size:0.84rem; font-weight:700; display:flex; justify-content:space-between;">
              <span>Packet Loss (%)</span>
              <span id="webrtc-loss-val" style="color:var(--primary);">1.2%</span>
            </label>
            <input type="range" id="webrtc-loss" min="0" max="15" step="0.2" value="1.2" style="width:100%; accent-color:var(--primary);" oninput="renderWebRtcSim()">
          </div>

          <div style="margin-bottom:0.85rem;">
            <label style="font-size:0.84rem; font-weight:700; display:flex; justify-content:space-between;">
              <span>Network Jitter (ms)</span>
              <span id="webrtc-jitter-val" style="color:var(--primary);">18 ms</span>
            </label>
            <input type="range" id="webrtc-jitter" min="2" max="150" step="1" value="18" style="width:100%; accent-color:var(--primary);" oninput="renderWebRtcSim()">
          </div>

          <div style="margin-bottom:0.5rem;">
            <label style="font-size:0.84rem; font-weight:700; display:flex; justify-content:space-between;">
              <span>Round-Trip Time / RTT (ms)</span>
              <span id="webrtc-rtt-val" style="color:var(--primary);">65 ms</span>
            </label>
            <input type="range" id="webrtc-rtt" min="15" max="400" step="5" value="65" style="width:100%; accent-color:var(--primary);" oninput="renderWebRtcSim()">
          </div>
        </div>

        <div class="cmp-panel-box" id="webrtc-telemetry-readout"></div>
      </div>
    </div>

  </div>
</section>

<!-- Kotlin Multiplatform Architecture & Source Code Inspector -->
<section class="cmp-source-card" id="cmp-kotlin-source">
  <div class="cmp-filter-label">
    <span>How to Add a New Portfolio App in Kotlin (<code>composeApp/src/commonMain</code>)</span>
    <span>Kotlin 2.1.0 • Compose Multiplatform 1.7.3</span>
  </div>
  <p style="font-size:0.88rem; color:var(--on-surface-variant);">
    All mini-apps live in <code>composeApp/src/commonMain/kotlin/com/mohitb117/portfolio/apps/</code> and register in <code>MiniAppRegistry.kt</code>:
  </p>
  <pre class="cmp-code-block"><code>// composeApp/src/commonMain/kotlin/com/mohitb117/portfolio/apps/MiniAppRegistry.kt
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
}</code></pre>
</section>

<script>
  // Shared Portfolio Repository mirroring composeApp/src/commonMain/.../PortfolioData.kt
  var CMP_SKILLS = [
    "All Skills",
    "Android & Jetpack Compose",
    "Kotlin & Coroutines",
    "Server-Driven UI (SDUI)",
    "WebRTC & Real-Time Media",
    "AWS & Cloud",
    "Hardware Peripherals",
    "CI & Visual Regression",
    "Mobile Technical Leadership"
  ];

  var CMP_STAGES = [
    {
      stepNumber: 4,
      stageTitle: "CURRENT ROLE: DOORDASH",
      organization: "DoorDash",
      roleTitle: "Senior Software Engineer | Mobile Technical Lead",
      period: "Nov 2021 – Present (4+ yrs)",
      brandColor: "#ff3008",
      deliverables: [
        {
          title: "Order Confirmation UI",
          subtitle: "Built from scratch with full Android & iOS parity",
          architectureNotes: "Architected reactive state machine and extensible surface for real-time ETA updates, multi-store order tracking, and promotional placements across millions of daily orders.",
          skills: ["Android & Jetpack Compose", "Kotlin & Coroutines", "Mobile Technical Leadership"],
          badge: "Millions Daily Orders"
        },
        {
          title: "Dynamic Delivery Options",
          subtitle: "Backend-driven zero-release delivery window experimentation",
          architectureNotes: "Orchestrated backend configuration schemas with reactive Android UI logic and led cross-platform iOS adoption.",
          skills: ["Server-Driven UI (SDUI)", "Kotlin & Coroutines", "Mobile Technical Leadership"],
          badge: "Zero-Release SDUI"
        },
        {
          title: "Hardware Integration (Hardware Peripherals)",
          subtitle: "Connected external hardware peripherals & fulfillment devices",
          architectureNotes: "Engineered low-latency peripheral discovery, connection resilience, and hardware telemetry pipelines.",
          skills: ["Hardware Peripherals", "Android & Jetpack Compose", "Kotlin & Coroutines"],
          badge: "Hardware Peripherals"
        },
        {
          title: "CI Build Time & Visual Regression Testing",
          subtitle: "Automated Jetpack Compose screenshot testing & build velocity",
          architectureNotes: "Instituted automated Compose visual regression testing pipelines and modular build optimizations to cut PR turnaround times.",
          skills: ["CI & Visual Regression", "Android & Jetpack Compose", "Mobile Technical Leadership"],
          badge: "Developer Velocity"
        }
      ]
    },
    {
      stepNumber: 3,
      stageTitle: "AMAZON",
      organization: "Amazon (Care, Silk, Flex)",
      roleTitle: "Senior Software Engineer",
      period: "Dec 2015 – Nov 2021 (6 yrs)",
      brandColor: "#ff9900",
      deliverables: [
        {
          title: "Amazon Care: Telehealth Audio/Video Engine",
          subtitle: "Video / Audio & App Platform Engineer",
          architectureNotes: "Built low-latency WebRTC telehealth conferencing engine with real-time packet-loss/jitter telemetry and dynamic bitrate adaptation.",
          skills: ["WebRTC & Real-Time Media", "Kotlin & Coroutines", "AWS & Cloud", "Mobile Technical Leadership"],
          badge: "Patent US11038933B1"
        },
        {
          title: "Amazon Silk: Fire TV Browser Lead",
          subtitle: "10-Foot TV Web Browser & Virtual Cursor (20M+ Devices)",
          architectureNotes: "Engineered Chromium-backed Leanback UI, HomeMenu launcher, and heuristic D-pad virtual cursor navigation across 20M+ Fire TV devices.",
          skills: ["Android & Jetpack Compose", "Mobile Technical Leadership"],
          badge: "20M+ Devices"
        },
        {
          title: "Amazon Flex: JVM Performance Optimization",
          subtitle: "Memory profiling & garbage collection tuning at scale",
          architectureNotes: "Built in-app memory telemetry profiler and eliminated systemic OOM crashes across delivery driver fleet devices.",
          skills: ["Kotlin & Coroutines", "Android & Jetpack Compose"],
          badge: "JVM & GC Tuning"
        }
      ]
    },
    {
      stepNumber: 2,
      stageTitle: "RESEARCH & EARLY CAREER",
      organization: "PNNL (US Dept. of Energy) & INRIX",
      roleTitle: "Software Dev Engineer",
      period: "2013 – 2015",
      brandColor: "#0d9488",
      deliverables: [
        {
          title: "PNNL: FoodFeed Food Health App",
          subtitle: "1st Place Winner – DOE Mobile Challenge",
          architectureNotes: "Primary developer for the FoodFeed food health & bio-surveillance Android platform with real-time Java EE backend push sync.",
          skills: ["Android & Jetpack Compose", "AWS & Cloud"],
          badge: "1st Place DOE Winner"
        },
        {
          title: "INRIX: Connected Car Mobility SDK",
          subtitle: "Real-time traffic & connected vehicle navigation SDK",
          architectureNotes: "Engineered mobile telemetry and route intelligence SDKs powering automotive OEM head-units and consumer navigation apps.",
          skills: ["Android & Jetpack Compose", "Hardware Peripherals"],
          badge: "Connected Car SDK"
        }
      ]
    },
    {
      stepNumber: 1,
      stageTitle: "EDUCATION",
      organization: "Syracuse University & GGSIU",
      roleTitle: "M.S. Computer Engineering • B.Tech Computer Science",
      period: "2008 – 2014",
      brandColor: "#ea580c",
      deliverables: [
        {
          title: "Syracuse University — M.S. Computer Engineering",
          subtitle: "Software Engineering & Mobile Systems (GPA: 3.55/4.0)",
          architectureNotes: "Awarded 50% Graduate Merit Scholarship for academic excellence in mobile systems and software architecture.",
          skills: ["Android & Jetpack Compose", "Kotlin & Coroutines"],
          badge: "Merit Scholar"
        },
        {
          title: "GGSIU — B.Tech Computer Science",
          subtitle: "First Division with Distinction (GPA: 3.97/4.0)",
          architectureNotes: "2nd Place Winner in IEEE India INNOVISION Linux Systems Challenge.",
          skills: ["Android & Jetpack Compose"],
          badge: "GPA 3.97/4.0"
        }
      ]
    }
  ];

  var activeSkill = "All Skills";
  var activeDeliveryWindow = "Express (25–35 min)";

  function switchCmpApp(appId, btn) {
    if (typeof triggerHaptic === 'function') triggerHaptic(10);
    document.querySelectorAll('.cmp-tab-btn').forEach(function(b) { b.classList.remove('active'); });
    if (btn) btn.classList.add('active');

    document.querySelectorAll('.cmp-app-pane').forEach(function(p) { p.style.display = 'none'; });
    var target = document.getElementById('cmp-app-' + appId);
    if (target) target.style.display = 'block';
  }

  function selectCmpSkill(skill) {
    if (typeof triggerHaptic === 'function') triggerHaptic(8);
    activeSkill = skill;
    renderCareerExplorer();
  }

  function renderCareerExplorer() {
    var strip = document.getElementById('cmp-skill-strip');
    var container = document.getElementById('cmp-stages-container');
    var countEl = document.getElementById('cmp-match-count');
    if (!strip || !container) return;

    strip.innerHTML = CMP_SKILLS.map(function(skill) {
      var isAct = skill === activeSkill ? ' active' : '';
      return '<button type="button" class="cmp-skill-chip' + isAct + '" onclick="selectCmpSkill(\'' + skill + '\')">' + skill + '</button>';
    }).join('');

    var totalDeliverables = 0;
    var visibleStages = 0;

    var html = CMP_STAGES.map(function(stage) {
      var matching = stage.deliverables.filter(function(d) {
        return activeSkill === "All Skills" || d.skills.indexOf(activeSkill) !== -1;
      });
      if (matching.length === 0) return '';
      visibleStages++;
      totalDeliverables += matching.length;

      var cardsHtml = matching.map(function(d) {
        var tagsHtml = d.skills.map(function(s) {
          return '<span class="cmp-mini-tag" onclick="event.stopPropagation(); selectCmpSkill(\'' + s + '\')">' + s + '</span>';
        }).join('');
        return (
          '<div class="cmp-deliverable-card">' +
            '<div class="cmp-deliverable-top">' +
              '<div>' +
                '<div class="cmp-deliverable-title">' + d.title + '</div>' +
                '<div class="cmp-deliverable-sub">' + d.subtitle + '</div>' +
              '</div>' +
              '<span class="cmp-deliverable-badge">' + d.badge + '</span>' +
            '</div>' +
            '<div class="cmp-deliverable-details">' +
              d.architectureNotes +
              '<div class="cmp-mini-tags">' + tagsHtml + '</div>' +
            '</div>' +
          '</div>'
        );
      }).join('');

      return (
        '<div class="cmp-stage-card">' +
          '<div class="cmp-stage-header">' +
            '<div>' +
              '<div class="cmp-stage-step" style="color:' + stage.brandColor + ';">' + stage.stepNumber + '. ' + stage.stageTitle + '</div>' +
              '<div class="cmp-stage-org">' + stage.organization + '</div>' +
              '<div class="cmp-stage-role">' + stage.roleTitle + '</div>' +
            '</div>' +
            '<span class="cmp-stage-period">' + stage.period + '</span>' +
          '</div>' +
          '<div class="cmp-deliverables-list">' + cardsHtml + '</div>' +
        '</div>'
      );
    }).join('');

    container.innerHTML = html;
    if (countEl) {
      countEl.textContent = 'Showing ' + visibleStages + ' stage(s) • ' + totalDeliverables + ' deliverable(s)';
    }
  }

  function selectDeliveryWindow(win) {
    if (typeof triggerHaptic === 'function') triggerHaptic(8);
    activeDeliveryWindow = win;
    renderSduiStudio();
  }

  function renderSduiStudio() {
    var showOrder = document.getElementById('sdui-chk-order').checked;
    var showDelivery = document.getElementById('sdui-chk-delivery').checked;
    var showHardware = document.getElementById('sdui-chk-hardware').checked;
    var eta = parseInt(document.getElementById('sdui-eta-slider').value, 10);

    document.getElementById('sdui-eta-val').textContent = eta + ' mins';

    var components = [];
    if (showOrder) components.push({ type: "order_confirmation_header", etaMinutes: eta, parity: "android_ios" });
    if (showDelivery) components.push({ type: "dynamic_delivery_options", selectedWindow: activeDeliveryWindow });
    if (showHardware) components.push({ type: "hardware_peripheral_banner", peripheral: "Bluetooth Scanner & Receipt Unit", status: "READY" });

    var payload = {
      schemaVersion: "2.4",
      screen: "doordash_post_checkout_hub",
      components: components
    };
    document.getElementById('sdui-json-output').textContent = JSON.stringify(payload, null, 2);

    var screenHtml = '';
    if (showOrder) {
      screenHtml += (
        '<div style="background:#1e293b; border-left:4px solid #ff3008; border-radius:12px; padding:0.85rem;">' +
          '<div style="font-size:0.7rem; color:#ff8c66; font-weight:700; text-transform:uppercase;">Order Confirmation UI</div>' +
          '<div style="font-size:1.05rem; font-weight:800; color:#fff; margin-top:0.15rem;">Estimated Arrival: ' + eta + ' mins</div>' +
          '<div style="font-size:0.76rem; color:#94a3b8; margin-top:0.2rem;">Multi-store fulfillment • Android &amp; iOS Parity</div>' +
        '</div>'
      );
    }
    if (showDelivery) {
      var windows = ["Express (25–35 min)", "Standard (40–55 min)", "Scheduled (4:00–5:00 PM)"];
      var btns = windows.map(function(w) {
        var activeStyle = w === activeDeliveryWindow
          ? 'background:#3ddc84; color:#003919; font-weight:800;'
          : 'background:#21262d; color:#e6edf3;';
        return '<button type="button" onclick="selectDeliveryWindow(\'' + w + '\')" style="border:none; padding:0.4rem 0.65rem; border-radius:8px; font-size:0.75rem; cursor:pointer; text-align:left; ' + activeStyle + '">' + w + '</button>';
      }).join('');
      screenHtml += (
        '<div style="background:#161b22; border:1px solid #30363d; border-radius:12px; padding:0.85rem;">' +
          '<div style="font-size:0.82rem; font-weight:700; color:#fff; margin-bottom:0.5rem;">Dynamic Delivery Options (SDUI)</div>' +
          '<div style="display:flex; flex-direction:column; gap:0.4rem;">' + btns + '</div>' +
        '</div>'
      );
    }
    if (showHardware) {
      screenHtml += (
        '<div style="background:#0a2617; border:1px solid #3ddc84; border-radius:12px; padding:0.8rem;">' +
          '<div style="font-size:0.8rem; font-weight:700; color:#69f0ae;">Hardware Peripherals Connected</div>' +
          '<div style="font-size:0.73rem; color:#d1fae5; margin-top:0.15rem;">External Scanner &amp; Fulfillment Peripheral • 98% Battery</div>' +
        '</div>'
      );
    }
    if (!screenHtml) {
      screenHtml = '<div style="color:#9aa0a6; text-align:center; padding:3rem 1rem; font-size:0.85rem;">All SDUI schema nodes disabled. Enable a node on the left to compose UI.</div>';
    }
    document.getElementById('sdui-phone-screen').innerHTML = screenHtml;
  }

  function renderWebRtcSim() {
    var loss = parseFloat(document.getElementById('webrtc-loss').value);
    var jitter = parseFloat(document.getElementById('webrtc-jitter').value);
    var rtt = parseFloat(document.getElementById('webrtc-rtt').value);

    document.getElementById('webrtc-loss-val').textContent = loss.toFixed(1) + '%';
    document.getElementById('webrtc-jitter-val').textContent = jitter + ' ms';
    document.getElementById('webrtc-rtt-val').textContent = rtt + ' ms';

    var mos = Math.max(1.0, Math.min(4.5, 4.5 - (loss * 0.22) - (jitter * 0.012) - (rtt * 0.003)));
    var statusColor = mos >= 3.8 ? '#3ddc84' : (mos >= 2.9 ? '#f59e0b' : '#ef4444');
    var profile = mos >= 3.8
      ? '1080p @ 60fps • VP9 / Opus Full-Band (Optimal Telehealth Stream)'
      : (mos >= 2.9 ? '720p @ 30fps • H.264 + Forward Error Correction (Adaptive Step-Down)' : '360p @ 15fps + Audio-Priority Fallback (Severe Packet Loss Recovery)');

    document.getElementById('webrtc-telemetry-readout').innerHTML = (
      '<div class="cmp-filter-label"><span>Real-Time Quality Telemetry Output</span></div>' +
      '<div style="font-size:2.2rem; font-weight:900; color:' + statusColor + '; line-height:1.1; margin:0.4rem 0;">' +
        mos.toFixed(2) + ' <span style="font-size:1rem; font-weight:600; color:var(--on-surface-variant);">/ 4.50 MOS</span>' +
      '</div>' +
      '<div style="margin:0.75rem 0; height:10px; border-radius:999px; background:var(--surface-container); overflow:hidden; border:1px solid var(--outline);">' +
        '<div style="height:100%; width:' + ((mos / 4.5) * 100).toFixed(0) + '%; background:' + statusColor + '; transition:width 0.15s ease;"></div>' +
      '</div>' +
      '<div style="font-size:0.88rem; font-weight:700; color:var(--on-surface); margin-top:0.75rem;">Active Adaptation Profile:</div>' +
      '<div style="font-size:0.84rem; color:var(--primary); font-weight:600; margin-top:0.2rem;">' + profile + '</div>' +
      '<div style="font-size:0.78rem; color:var(--on-surface-variant); margin-top:0.75rem;">' +
        'Patent US11038933B1 continuously monitors WebRTC RTCP Receiver Reports (packet loss, jitter, RTT) and dynamically adapts encoder bitrate and resolution before audio dropouts occur.' +
      '</div>'
    );
  }

  document.addEventListener('DOMContentLoaded', function() {
    renderCareerExplorer();
    renderSduiStudio();
    renderWebRtcSim();
  });
</script>
