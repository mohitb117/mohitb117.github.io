---
layout: default
title: Apps
description: Interactive Android & Compose Multiplatform apps running live in the browser — Career Explorer, DoorDash SDUI Studio, Amazon Care WebRTC, Amazon Silk Fire TV, Amazon Flex JVM Profiler, and PNNL FoodFeed & INRIX Connected Car.
permalink: /apps/
---

<style>
  /* Widen main container on /apps/ for spacious studio & full-width 10-Foot Fire TV mode */
  .main-container {
    max-width: 1240px !important;
  }

  /* Studio Split Layout: Device Left (Phone) + Live Controls & Kotlin IDE Right */
  .cmp-studio-grid {
    display: grid;
    grid-template-columns: 386px minmax(0, 1fr);
    gap: 1.6rem;
    align-items: start;
    margin: 0.25rem 0 1.5rem;
    transition: all 0.35s cubic-bezier(0.22, 1, 0.36, 1);
  }

  /* Full-Screen Width Mode when Widescreen Fire TV + Side D-Pad Remote is Selected */
  .cmp-studio-grid.tv-mode {
    grid-template-columns: 1fr;
  }

  @media (max-width: 960px) {
    .cmp-studio-grid,
    .cmp-studio-grid.tv-mode {
      grid-template-columns: 1fr;
    }
    .cmp-device-column {
      display: flex;
      justify-content: center;
    }
  }

  /* =====================================================
     COMPANY LOGO MINI BADGES (USED IN LAUNCHER & IN-DEVICE)
     ===================================================== */
  .cmp-company-badge {
    width: 22px;
    height: 22px;
    border-radius: 6px;
    background: #ffffff;
    padding: 2px;
    object-fit: contain;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.25);
    border: 1px solid rgba(255, 255, 255, 0.22);
    flex-shrink: 0;
  }

  .cmp-company-badge-sm {
    width: 18px;
    height: 18px;
    border-radius: 5px;
    background: #ffffff;
    padding: 1.5px;
    object-fit: contain;
    box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
    flex-shrink: 0;
  }

  .cmp-company-badge-lg {
    width: 38px;
    height: 38px;
    border-radius: 10px;
    background: #ffffff;
    padding: 4px;
    object-fit: contain;
    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.16);
    border: 1px solid rgba(0, 0, 0, 0.08);
    flex-shrink: 0;
  }

  .cmp-multi-logo-stack {
    display: inline-flex;
    align-items: center;
  }

  .cmp-multi-logo-stack .cmp-company-badge-sm + .cmp-company-badge-sm {
    margin-left: -5px;
    border: 1px solid #1e1f22;
  }

  /* =====================================================
     REALISTIC PIXEL 9 PRO MOBILE DEVICE CHASSIS
     ===================================================== */
  .cmp-phone-chassis {
    width: 386px;
    max-width: 100%;
    height: 770px;
    background: linear-gradient(145deg, #2b2f36 0%, #14161a 50%, #242830 100%);
    border-radius: 50px;
    padding: 12px;
    box-shadow:
      0 26px 54px rgba(0, 0, 0, 0.48),
      0 4px 14px rgba(0, 0, 0, 0.28),
      inset 0 1px 2px rgba(255, 255, 255, 0.24);
    border: 2px solid #3c424d;
    position: relative;
    display: flex;
    flex-direction: column;
    user-select: none;
    transition: width 0.38s cubic-bezier(0.22, 1, 0.36, 1), height 0.38s cubic-bezier(0.22, 1, 0.36, 1), border-radius 0.38s ease;
  }

  /* Landscape 16:9 Phone Mode when playing 16:9 Mobile Engineering Demo Videos */
  .cmp-phone-chassis.landscape-video-mode {
    width: 100%;
    max-width: 880px;
    height: 540px;
    border-radius: 42px;
    margin: 0 auto;
  }

  /* Hardware Side Buttons (Power + Volume Rocker) */
  .cmp-phone-chassis::before {
    content: '';
    position: absolute;
    right: -4px;
    top: 135px;
    width: 3px;
    height: 46px;
    background: #4b5260;
    border-radius: 0 3px 3px 0;
  }
  .cmp-phone-chassis::after {
    content: '';
    position: absolute;
    right: -4px;
    top: 200px;
    width: 3px;
    height: 86px;
    background: #4b5260;
    border-radius: 0 3px 3px 0;
  }

  /* Inner AMOLED Glass Viewport */
  .cmp-phone-glass {
    flex: 1;
    border-radius: 39px;
    overflow: hidden;
    display: flex;
    flex-direction: column;
    background: #0e1117;
    color: #f0f6fc;
    position: relative;
    border: 1px solid rgba(255, 255, 255, 0.08);
    transition: background 0.25s ease, color 0.25s ease;
  }

  .cmp-phone-glass.phone-light {
    background: #f8f4f1;
    color: #1c1b1a;
  }

  /* Android System Status Bar + Punch-Hole Camera */
  .cmp-android-statusbar {
    height: 36px;
    padding: 0 18px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 0.72rem;
    font-weight: 700;
    letter-spacing: 0.02em;
    background: #0a2617;
    color: #ffffff;
    position: relative;
    flex-shrink: 0;
    transition: background 0.25s ease;
  }

  .cmp-camera-punchhole {
    width: 11px;
    height: 11px;
    border-radius: 50%;
    background: #050608;
    box-shadow: inset 0 0 3px rgba(56, 189, 248, 0.45);
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    top: 11px;
  }

  .cmp-status-icons {
    display: flex;
    align-items: center;
    gap: 5px;
  }

  /* Compose Material 3 TopAppBar inside Phone */
  .cmp-m3-topbar {
    padding: 10px 13px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    gap: 8px;
    background: rgba(22, 27, 34, 0.95);
    border-bottom: 1px solid rgba(255, 255, 255, 0.08);
    flex-shrink: 0;
  }

  .cmp-phone-glass.phone-light .cmp-m3-topbar {
    background: #ffffff;
    border-bottom: 1px solid #e8d8ce;
  }

  .cmp-m3-topbar-left {
    display: flex;
    align-items: center;
    gap: 9px;
    min-width: 0;
  }

  .cmp-m3-title-wrap {
    display: flex;
    flex-direction: column;
    min-width: 0;
  }

  .cmp-m3-overline {
    font-size: 0.6rem;
    font-weight: 800;
    text-transform: uppercase;
    letter-spacing: 0.06em;
    color: #3ddc84;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }

  .cmp-phone-glass.phone-light .cmp-m3-overline {
    color: #ff6b00;
  }

  .cmp-m3-title {
    font-size: 0.9rem;
    font-weight: 800;
    line-height: 1.15;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }

  .cmp-m3-iconbtn {
    width: 30px;
    height: 30px;
    border-radius: 50%;
    border: 1px solid rgba(255, 255, 255, 0.16);
    background: rgba(255, 255, 255, 0.06);
    color: inherit;
    display: inline-flex;
    align-items: center;
    justify-content: center;
    cursor: pointer;
    flex-shrink: 0;
  }

  .cmp-phone-glass.phone-light .cmp-m3-iconbtn {
    border-color: #d7c3b8;
    background: #f3eeeb;
  }

  /* Scrollable Compose Content Area inside Phone */
  .cmp-phone-scroll {
    flex: 1;
    overflow-y: auto;
    padding: 11px;
    display: flex;
    flex-direction: column;
    gap: 9px;
    scrollbar-width: thin;
  }

  /* Compose FilterChips inside Phone */
  .cmp-phone-chip-row {
    display: flex;
    gap: 6px;
    overflow-x: auto;
    padding-bottom: 4px;
    scrollbar-width: none;
    flex-shrink: 0;
  }
  .cmp-phone-chip-row::-webkit-scrollbar {
    display: none;
  }

  .cmp-m3-chip {
    padding: 5px 10px;
    border-radius: 999px;
    font-size: 0.7rem;
    font-weight: 600;
    white-space: nowrap;
    border: 1px solid rgba(255, 255, 255, 0.16);
    background: rgba(255, 255, 255, 0.05);
    color: inherit;
    cursor: pointer;
    transition: all 0.15s ease;
  }

  .cmp-phone-glass.phone-light .cmp-m3-chip {
    border-color: #d7c3b8;
    background: #ffffff;
  }

  .cmp-m3-chip.active {
    background: #3ddc84;
    color: #003919;
    border-color: #3ddc84;
    font-weight: 800;
  }

  .cmp-phone-glass.phone-light .cmp-m3-chip.active {
    background: #ff6b00;
    color: #ffffff;
    border-color: #ff6b00;
  }

  /* Cards inside Phone Viewport */
  .cmp-m3-card {
    background: rgba(22, 27, 34, 0.92);
    border: 1px solid rgba(255, 255, 255, 0.1);
    border-radius: 14px;
    padding: 10px 11px;
  }

  .cmp-phone-glass.phone-light .cmp-m3-card {
    background: #ffffff;
    border-color: #e8d8ce;
    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.04);
  }

  .cmp-m3-subcard {
    background: rgba(255, 255, 255, 0.04);
    border: 1px solid rgba(255, 255, 255, 0.08);
    border-radius: 10px;
    padding: 8px 9px;
    margin-top: 7px;
    cursor: pointer;
    transition: border-color 0.15s ease;
  }

  .cmp-phone-glass.phone-light .cmp-m3-subcard {
    background: #f8f4f1;
    border-color: #e8d8ce;
  }

  .cmp-m3-subcard:hover {
    border-color: #3ddc84;
  }

  /* Material 3 NavigationBar inside Phone Bottom (6 Compact Dock Items) */
  .cmp-m3-bottomnav {
    height: 58px;
    background: rgba(22, 27, 34, 0.96);
    border-top: 1px solid rgba(255, 255, 255, 0.08);
    display: grid;
    grid-template-columns: repeat(6, 1fr);
    align-items: center;
    padding: 3px 4px 0;
    flex-shrink: 0;
  }

  .cmp-phone-glass.phone-light .cmp-m3-bottomnav {
    background: #ffffff;
    border-top: 1px solid #e8d8ce;
  }

  .cmp-m3-navitem {
    background: none;
    border: none;
    color: #9aa0a6;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 2px;
    font-size: 0.58rem;
    font-weight: 600;
    cursor: pointer;
    padding: 3px 0;
    min-width: 0;
  }

  .cmp-phone-glass.phone-light .cmp-m3-navitem {
    color: #52443d;
  }

  .cmp-m3-navitem.active {
    color: #3ddc84;
    font-weight: 800;
  }

  .cmp-phone-glass.phone-light .cmp-m3-navitem.active {
    color: #ff6b00;
  }

  .cmp-m3-navpill {
    padding: 2px 8px;
    border-radius: 999px;
    display: inline-flex;
    align-items: center;
    justify-content: center;
  }

  .cmp-m3-navitem.active .cmp-m3-navpill {
    background: rgba(61, 220, 132, 0.18);
  }

  .cmp-phone-glass.phone-light .cmp-m3-navitem.active .cmp-m3-navpill {
    background: rgba(255, 107, 0, 0.15);
  }

  /* Android Bottom Gesture Pill Bar */
  .cmp-android-gesturebar {
    height: 18px;
    display: flex;
    align-items: center;
    justify-content: center;
    background: rgba(22, 27, 34, 0.96);
    flex-shrink: 0;
  }

  .cmp-phone-glass.phone-light .cmp-android-gesturebar {
    background: #ffffff;
  }

  .cmp-gesture-pill {
    width: 108px;
    height: 4px;
    border-radius: 999px;
    background: rgba(255, 255, 255, 0.38);
  }

  .cmp-phone-glass.phone-light .cmp-gesture-pill {
    background: rgba(28, 27, 26, 0.35);
  }

  /* =====================================================
     AMAZON SILK 10-FOOT FIRE TV MONITOR + SIDE D-PAD REMOTE (FULL WIDTH)
     ===================================================== */
  @keyframes tvExpandStage {
    0% {
      opacity: 0.4;
      transform: scale(0.92);
    }
    100% {
      opacity: 1;
      transform: scale(1);
    }
  }

  .cmp-firetv-stage {
    display: none;
    width: 100%;
    max-width: 100%;
    flex-direction: column;
    gap: 1rem;
    user-select: none;
  }

  .cmp-firetv-stage.active {
    display: flex;
    animation: tvExpandStage 0.38s cubic-bezier(0.22, 1, 0.36, 1) forwards;
  }

  .cmp-tv-and-remote-row {
    display: grid;
    grid-template-columns: minmax(0, 1fr) 168px;
    gap: 22px;
    align-items: center;
    width: 100%;
  }

  @media (max-width: 720px) {
    .cmp-tv-and-remote-row {
      grid-template-columns: 1fr;
      justify-items: center;
    }
  }

  /* 16:9 Widescreen Smart TV Bezel & Stand */
  .cmp-tv-monitor-wrap {
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .cmp-tv-bezel {
    width: 100%;
    min-height: 490px;
    background: linear-gradient(145deg, #22262e 0%, #0f1115 100%);
    border-radius: 22px;
    padding: 14px 14px 22px;
    border: 2.5px solid #3c424d;
    box-shadow:
      0 28px 60px rgba(0, 0, 0, 0.55),
      inset 0 1px 2px rgba(255, 255, 255, 0.22);
    position: relative;
    display: flex;
    flex-direction: column;
  }

  .cmp-tv-screen {
    flex: 1;
    background: radial-gradient(circle at 20% 15%, #123354 0%, #071422 65%, #040b14 100%);
    border-radius: 12px;
    border: 1px solid rgba(56, 189, 248, 0.28);
    overflow: hidden;
    position: relative;
    display: flex;
    flex-direction: column;
    color: #f0f6fc;
  }

  /* TV Bottom Chin Logo + Power LED */
  .cmp-tv-chin {
    position: absolute;
    bottom: 4px;
    left: 0;
    right: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 7px;
    font-size: 0.6rem;
    font-weight: 800;
    letter-spacing: 0.16em;
    color: #8b949e;
    text-transform: uppercase;
  }

  .cmp-tv-led {
    width: 6px;
    height: 6px;
    border-radius: 50%;
    background: #38bdf8;
    box-shadow: 0 0 8px #38bdf8;
  }

  .cmp-tv-stand-neck {
    width: 76px;
    height: 18px;
    background: linear-gradient(90deg, #1b1e24, #343942, #1b1e24);
    border-left: 1px solid #454c59;
    border-right: 1px solid #454c59;
  }

  .cmp-tv-stand-base {
    width: 240px;
    height: 9px;
    border-radius: 999px;
    background: linear-gradient(90deg, #242830, #484f5d, #242830);
    box-shadow: 0 6px 16px rgba(0, 0, 0, 0.45);
  }

  /* Physical Amazon Fire TV Remote Control on the Side */
  .cmp-firetv-remote {
    width: 164px;
    background: linear-gradient(160deg, #2c3038 0%, #17191e 55%, #101216 100%);
    border-radius: 40px;
    padding: 18px 14px 22px;
    border: 2px solid #3f4551;
    box-shadow:
      0 24px 48px rgba(0, 0, 0, 0.52),
      inset 0 1px 2px rgba(255, 255, 255, 0.22);
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 12px;
    position: relative;
  }

  .cmp-remote-top-row {
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 6px;
  }

  .cmp-remote-pwr {
    width: 24px;
    height: 24px;
    border-radius: 50%;
    border: 1px solid rgba(255, 255, 255, 0.18);
    background: #22252b;
    color: #f87171;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 13px;
  }

  .cmp-remote-mic-led {
    width: 8px;
    height: 8px;
    border-radius: 50%;
    background: #38bdf8;
    box-shadow: 0 0 8px #38bdf8;
    transition: transform 0.15s ease, background 0.15s ease;
  }

  .cmp-remote-voice-btn {
    width: 34px;
    height: 34px;
    border-radius: 50%;
    border: 1px solid rgba(56, 189, 248, 0.5);
    background: linear-gradient(145deg, #0284c7, #0369a1);
    color: #ffffff;
    display: flex;
    align-items: center;
    justify-content: center;
    cursor: pointer;
    box-shadow: 0 2px 8px rgba(2, 132, 199, 0.4);
  }

  /* Circular Physical 8-Way D-Pad Navigation Ring on Remote (Cardinal + Diagonal) */
  .cmp-remote-dpad-ring {
    width: 128px;
    height: 128px;
    border-radius: 50%;
    background: radial-gradient(circle, #262b34 0%, #15171c 75%);
    border: 3px solid #3c424e;
    box-shadow:
      0 6px 14px rgba(0, 0, 0, 0.55),
      inset 0 2px 4px rgba(255, 255, 255, 0.12);
    position: relative;
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    grid-template-rows: repeat(3, 1fr);
    align-items: center;
    justify-items: center;
    padding: 5px;
    overflow: hidden;
  }

  .cmp-r-dir {
    width: 100%;
    height: 100%;
    background: transparent;
    border: none;
    color: #e6edf3;
    font-size: 0.74rem;
    font-weight: 900;
    cursor: pointer;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 8px;
    transition: all 0.12s ease;
  }

  .cmp-r-diag {
    color: #7dd3fc;
    font-size: 0.68rem;
    opacity: 0.85;
  }

  .cmp-r-dir:hover {
    color: #38bdf8;
    background: rgba(56, 189, 248, 0.18);
    opacity: 1;
  }

  .cmp-r-dir:active {
    background: #38bdf8;
    color: #000000;
    transform: scale(0.92);
  }

  .cmp-r-select {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    background: linear-gradient(145deg, #2f3540, #1c2026);
    border: 1.5px solid #525a68;
    color: #ffffff;
    font-size: 0.62rem;
    font-weight: 800;
    cursor: pointer;
    display: flex;
    align-items: center;
    justify-content: center;
    box-shadow: inset 0 1px 2px rgba(255, 255, 255, 0.2);
    transition: all 0.12s ease;
  }

  .cmp-r-select:hover {
    border-color: #3ddc84;
    color: #3ddc84;
  }

  .cmp-r-select:active {
    background: #3ddc84;
    color: #002b12;
    transform: scale(0.93);
  }

  /* Remote Control Action Buttons Row (Back / Home / Menu) */
  .cmp-remote-btn-grid {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 5px;
    width: 100%;
  }

  .cmp-remote-small-btn {
    height: 26px;
    border-radius: 13px;
    border: 1px solid #3c424e;
    background: #21252c;
    color: #c9d1d9;
    display: flex;
    align-items: center;
    justify-content: center;
    cursor: pointer;
    font-size: 0.65rem;
    transition: all 0.12s ease;
  }

  .cmp-remote-small-btn:hover {
    border-color: #38bdf8;
    color: #38bdf8;
  }

  .cmp-remote-small-btn:active {
    background: #38bdf8;
    color: #000;
  }

  .cmp-remote-brand {
    margin-top: 2px;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 3px;
    font-size: 0.56rem;
    font-weight: 800;
    color: #8b949e;
    letter-spacing: 0.08em;
    text-transform: uppercase;
  }

  /* =====================================================
     RIGHT COLUMN: 6-APP LAUNCHER + LIVE INSPECTOR + KOTLIN IDE
     ===================================================== */
  .cmp-right-column {
    display: flex;
    flex-direction: column;
    gap: 1.25rem;
    min-width: 0;
  }

  /* 6-App Switcher Cards Grid (2x3 for Spacious Text & Zero Truncation) */
  .cmp-launcher-grid {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    gap: 0.75rem;
  }

  @media (max-width: 580px) {
    .cmp-launcher-grid {
      grid-template-columns: 1fr;
    }
  }

  .cmp-app-tile {
    background: var(--surface-container);
    border: 1.5px solid var(--outline-variant);
    border-radius: 16px;
    padding: 0.85rem 1rem;
    text-align: left;
    cursor: pointer;
    transition: all 0.2s cubic-bezier(0.22, 1, 0.36, 1);
    display: flex;
    align-items: center;
    gap: 0.8rem;
    min-width: 0;
  }

  .cmp-app-tile:hover {
    border-color: var(--primary);
    background: var(--surface-container-high);
    transform: translateY(-2px);
    box-shadow: var(--elevation-1);
  }

  .cmp-app-tile.active {
    border-color: var(--primary);
    background: var(--primary-bg);
    box-shadow: 0 6px 20px rgba(61, 220, 132, 0.14);
  }

  .cmp-app-tile-title {
    font-size: 0.9rem;
    font-weight: 800;
    color: var(--on-surface);
    line-height: 1.25;
  }

  .cmp-app-tile-sub {
    font-size: 0.74rem;
    color: var(--on-surface-variant);
    margin-top: 3px;
    display: flex;
    align-items: center;
    gap: 5px;
  }

  .cmp-inspector-card {
    background: var(--surface-container);
    border: 1px solid var(--outline-variant);
    border-radius: var(--shape-lg);
    padding: 1.1rem 1.25rem;
    box-shadow: var(--elevation-1);
  }

  .cmp-section-overline {
    font-size: 0.71rem;
    font-weight: 800;
    letter-spacing: 0.06em;
    text-transform: uppercase;
    color: var(--primary);
    display: flex;
    align-items: center;
    justify-content: space-between;
    gap: 0.5rem;
    margin-bottom: 0.55rem;
  }

  /* Demo Playlist & Blog Article Destinations Tray (Synced with Resume) */
  .cmp-blog-dest-banner {
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    justify-content: space-between;
    gap: 0.65rem;
    padding: 0.65rem 0.85rem;
    border-radius: 12px;
    background: var(--surface-container-low);
    border: 1px solid var(--outline-variant);
    margin-bottom: 0.75rem;
  }

  .cmp-blog-dest-link {
    font-size: 0.8rem;
    font-weight: 800;
    color: var(--on-surface);
    text-decoration: none;
    display: inline-flex;
    align-items: center;
    gap: 6px;
  }

  .cmp-blog-dest-link:hover {
    color: var(--primary);
    text-decoration: underline;
  }

  .cmp-blog-read-pill {
    display: inline-flex;
    align-items: center;
    gap: 5px;
    padding: 0.32rem 0.72rem;
    border-radius: 999px;
    background: var(--primary);
    color: var(--on-primary);
    font-size: 0.72rem;
    font-weight: 800;
    text-decoration: none;
    white-space: nowrap;
    transition: opacity 0.15s ease;
  }

  .cmp-blog-read-pill:hover {
    opacity: 0.9;
  }

  .cmp-playlist-tray {
    display: flex;
    align-items: flex-start;
    gap: 0.9rem;
    overflow-x: auto;
    padding: 4px 2px 8px;
    scrollbar-width: thin;
  }

  /* Each Playlist Item IS a Mini Phone Cutout (or Mini TV Cutout for Silk) with Caption Below */
  .cmp-demo-tile {
    width: 146px;
    min-width: 146px;
    background: transparent;
    border: none;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 8px;
    flex-shrink: 0;
    transition: transform 0.2s cubic-bezier(0.22, 1, 0.36, 1);
  }

  .cmp-demo-tile.tv-tile {
    width: 214px;
    min-width: 214px;
  }

  .cmp-demo-tile:hover {
    transform: translateY(-3px);
  }

  .cmp-demo-thumb-wrap {
    position: relative;
    width: 100%;
    cursor: pointer;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

  /* Mini Upright Portrait Mobile Phone Bezel Cutout (The Top of the Item IS the Phone!) */
  .cmp-thumb-phone-cutout {
    position: relative;
    width: 126px;
    height: 218px;
    border-radius: 22px;
    border: 3.5px solid #3c424d;
    background: #0b0e14;
    box-shadow: 0 10px 24px rgba(0, 0, 0, 0.55), inset 0 0 0 1px rgba(255, 255, 255, 0.14);
    overflow: hidden;
    flex-shrink: 0;
    transition: all 0.2s ease;
  }

  /* Camera Punch-Hole on Mini Upright Phone Cutout (Top Center) */
  .cmp-thumb-phone-cutout::before {
    content: '';
    position: absolute;
    top: 6px;
    left: 50%;
    transform: translateX(-50%);
    width: 22px;
    height: 5px;
    border-radius: 999px;
    background: #05070a;
    z-index: 3;
    border: 0.5px solid rgba(255, 255, 255, 0.28);
  }

  /* Bottom Gesture Pill on Mini Upright Phone Cutout */
  .cmp-thumb-phone-cutout::after {
    content: '';
    position: absolute;
    bottom: 5px;
    left: 50%;
    transform: translateX(-50%);
    width: 38px;
    height: 3px;
    border-radius: 999px;
    background: rgba(255, 255, 255, 0.65);
    z-index: 3;
  }

  /* Mini Widescreen Fire TV + Stand Cutout ONLY for Silk Fire TV Thumbnails */
  .cmp-thumb-tv-cutout-wrap {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    width: 100%;
  }

  .cmp-thumb-tv-cutout {
    position: relative;
    width: 210px;
    height: 132px;
    border-radius: 10px;
    border: 3.5px solid #3c424d;
    background: #0b0e14;
    box-shadow: 0 10px 24px rgba(0, 0, 0, 0.6);
    overflow: hidden;
    transition: all 0.2s ease;
  }

  .cmp-thumb-tv-stand {
    width: 68px;
    height: 5px;
    background: #475569;
    border-radius: 0 0 5px 5px;
    margin-top: 2px;
  }

  .cmp-demo-tile:hover .cmp-thumb-phone-cutout,
  .cmp-demo-tile:hover .cmp-thumb-tv-cutout {
    border-color: var(--primary);
  }

  .cmp-demo-tile.playing .cmp-thumb-phone-cutout,
  .cmp-demo-tile.playing .cmp-thumb-tv-cutout {
    border-color: #3ddc84;
    box-shadow: 0 0 0 2px rgba(61, 220, 132, 0.35), 0 12px 26px rgba(0, 0, 0, 0.65);
  }

  /* Scale YouTube 16:9 mqdefault image inside upright 9:16 phone screen so the center phone screen fills the frame */
  .cmp-thumb-phone-cutout img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    transform: scale(1.38);
    opacity: 0.94;
  }

  .cmp-thumb-tv-cutout img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    opacity: 0.94;
  }

  .cmp-demo-play-badge {
    position: absolute;
    inset: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    background: rgba(0, 0, 0, 0.28);
    color: #ffffff;
    z-index: 2;
  }

  .cmp-demo-type-pill {
    position: absolute;
    top: 14px;
    right: 8px;
    background: rgba(0, 0, 0, 0.78);
    color: #fff;
    font-size: 0.54rem;
    font-weight: 800;
    padding: 2px 5px;
    border-radius: 4px;
    z-index: 4;
  }

  /* Compact Caption & Actions Directly Below the Phone / TV Cutout */
  .cmp-demo-body {
    width: 100%;
    padding: 0 2px;
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
    gap: 4px;
  }

  .cmp-demo-title {
    font-size: 0.74rem;
    font-weight: 800;
    color: var(--on-surface);
    line-height: 1.25;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    overflow: hidden;
  }

  .cmp-demo-actions {
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 5px;
    margin-top: 2px;
    white-space: nowrap;
  }

  .cmp-demo-mini-link {
    font-size: 0.64rem;
    font-weight: 700;
    color: var(--primary);
    text-decoration: none;
    display: inline-flex;
    align-items: center;
    gap: 2px;
    background: var(--surface-container-low);
    border: 1px solid var(--outline-variant);
    padding: 2px 6px;
    border-radius: 6px;
    cursor: pointer;
    white-space: nowrap;
    transition: all 0.15s ease;
  }

  .cmp-demo-mini-link:hover {
    background: var(--primary);
    color: var(--on-primary);
    border-color: var(--primary);
    text-decoration: none;
  }

  /* JetBrains Darcula / Android Studio Code Editor Window (Collapsible by Default) */
  .cmp-ide-details {
    background: #1e1f22;
    border: 1px solid #393b40;
    border-radius: 14px;
    overflow: hidden;
    box-shadow: var(--elevation-1);
  }

  .cmp-ide-summary {
    list-style: none;
    background: #2b2d30;
    padding: 0.65rem 0.95rem;
    display: flex;
    align-items: center;
    justify-content: space-between;
    gap: 0.75rem;
    cursor: pointer;
    user-select: none;
    color: #dfe1e5;
    font-size: 0.78rem;
    font-weight: 700;
    transition: background 0.15s ease;
  }

  .cmp-ide-summary::-webkit-details-marker {
    display: none;
  }

  .cmp-ide-summary:hover {
    background: #323539;
  }

  .cmp-ide-details[open] .cmp-ide-summary {
    border-bottom: 1px solid #393b40;
  }

  .cmp-ide-chevron {
    transition: transform 0.2s ease;
    color: #3ddc84;
  }

  .cmp-ide-details[open] .cmp-ide-chevron {
    transform: rotate(180deg);
  }

  .cmp-ide-titlebar {
    background: #25272a;
    border-bottom: 1px solid #393b40;
    padding: 0.45rem 0.85rem;
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    justify-content: space-between;
    gap: 0.5rem;
  }

  .cmp-ide-dots {
    display: flex;
    align-items: center;
    gap: 6px;
  }

  .cmp-ide-dot {
    width: 11px;
    height: 11px;
    border-radius: 50%;
  }

  .cmp-ide-tabs {
    display: flex;
    flex-wrap: wrap;
    gap: 3px;
  }

  .cmp-ide-tab {
    background: transparent;
    border: 1px solid transparent;
    color: #9da0a8;
    font-family: var(--font-mono);
    font-size: 0.7rem;
    font-weight: 600;
    padding: 0.28rem 0.58rem;
    border-radius: 7px;
    cursor: pointer;
    display: inline-flex;
    align-items: center;
    gap: 4px;
    transition: all 0.15s ease;
  }

  .cmp-ide-tab:hover {
    color: #dfe1e5;
    background: rgba(255, 255, 255, 0.05);
  }

  .cmp-ide-tab.active {
    background: #1e1f22;
    color: #ffffff;
    border-color: #4e5157;
    border-bottom-color: #3ddc84;
    border-bottom-width: 2px;
  }

  .cmp-copy-btn {
    background: #35373b;
    border: 1px solid #4e5157;
    color: #dfe1e5;
    font-size: 0.7rem;
    font-weight: 600;
    padding: 0.25rem 0.6rem;
    border-radius: 6px;
    cursor: pointer;
    display: inline-flex;
    align-items: center;
    gap: 4px;
  }

  .cmp-copy-btn:hover {
    border-color: #3ddc84;
    color: #3ddc84;
  }

  /* Syntax Highlighted Code Body */
  .cmp-ide-body {
    padding: 0.9rem 1rem;
    overflow-x: auto;
    max-height: 430px;
    overflow-y: auto;
    font-family: var(--font-mono);
    font-size: 0.77rem;
    line-height: 1.54;
    color: #bcbec4;
  }

  .cmp-code-table {
    border-collapse: collapse;
    width: 100%;
  }

  .cmp-line-num {
    user-select: none;
    text-align: right;
    padding-right: 14px;
    color: #4b5059;
    font-size: 0.71rem;
    width: 28px;
    vertical-align: top;
  }

  .cmp-line-code {
    white-space: pre;
    color: #bcbec4;
  }

  /* JetBrains Kotlin Darcula Syntax Tokens */
  .kt-kw { color: #cf8e6d; font-weight: 600; }       /* package, import, fun, val, var, object, if, else, when */
  .kt-ann { color: #b3ae60; font-weight: 600; }      /* @Composable, @OptIn */
  .kt-type { color: #56a8f5; }                       /* Types & Composable functions */
  .kt-str { color: #6aab73; }                        /* Strings */
  .kt-num { color: #2aacb8; }                        /* Numbers & dp/sp literals */
  .kt-cmt { color: #7a7e85; font-style: italic; }    /* Comments */
</style>

<!-- Split Studio: Device Frame Left (Mobile Phone OR Fire TV Widescreen + Side D-Pad Remote) + App Switcher & Kotlin IDE Right -->
<div class="cmp-studio-grid" id="cmpStudioGrid">

  <!-- ==================== LEFT: HARDWARE DEVICE PREVIEW (PHONE OR FIRE TV + SIDE REMOTE) ==================== -->
  <div class="cmp-device-column">

    <!-- 1. PIXEL 9 PRO MOBILE DEVICE CHASSIS (Shown for Mobile Apps) -->
    <div class="cmp-phone-chassis" id="cmpMobileDeviceWrap">
      <div class="cmp-phone-glass" id="cmpPhoneGlass">

        <!-- Android System Status Bar -->
        <div class="cmp-android-statusbar" id="cmpStatusBar">
          <span>9:41</span>
          <div class="cmp-camera-punchhole"></div>
          <div class="cmp-status-icons">
            <span class="material-symbols-outlined" style="font-size:14px;">signal_cellular_alt</span>
            <span class="material-symbols-outlined" style="font-size:14px;">wifi</span>
            <span class="material-symbols-outlined" style="font-size:15px;">battery_full</span>
          </div>
        </div>

        <!-- In-Phone Material 3 Top App Bar with Active Company Logo Icon -->
        <div class="cmp-m3-topbar">
          <div class="cmp-m3-topbar-left">
            <img src="/images/DoorDash_Logo.svg.png" alt="Company Logo" class="cmp-company-badge" id="cmpPhoneCompanyLogo">
            <div class="cmp-m3-title-wrap">
              <span class="cmp-m3-overline" id="cmpPhoneOverline">All Roles • Material 3</span>
              <span class="cmp-m3-title" id="cmpPhoneTitle">Career &amp; Skill Explorer</span>
            </div>
          </div>
          <button type="button" class="cmp-m3-iconbtn" onclick="togglePhoneInternalTheme()" title="Toggle In-Phone Dark/Light Theme">
            <span class="material-symbols-outlined" style="font-size:16px;" id="cmpPhoneThemeIcon">light_mode</span>
          </button>
        </div>

        <!-- Scrollable In-Phone Compose Viewport -->
        <div class="cmp-phone-scroll" id="cmpPhoneViewport"></div>

        <!-- In-Phone Material 3 Bottom Navigation Bar (All 6 Portfolio Mini-Apps) -->
        <div class="cmp-m3-bottomnav" role="tablist">
          <button type="button" class="cmp-m3-navitem active" id="nav-career-explorer" onclick="switchCmpApp('career-explorer')">
            <span class="cmp-m3-navpill">
              <span class="material-symbols-outlined" style="font-size:17px;">timeline</span>
            </span>
            <span>Career</span>
          </button>
          <button type="button" class="cmp-m3-navitem" id="nav-sdui-playground" onclick="switchCmpApp('sdui-playground')">
            <span class="cmp-m3-navpill">
              <span class="material-symbols-outlined" style="font-size:17px;">schema</span>
            </span>
            <span>SDUI</span>
          </button>
          <button type="button" class="cmp-m3-navitem" id="nav-webrtc-telemetry" onclick="switchCmpApp('webrtc-telemetry')">
            <span class="cmp-m3-navpill">
              <span class="material-symbols-outlined" style="font-size:17px;">videocam</span>
            </span>
            <span>WebRTC</span>
          </button>
          <button type="button" class="cmp-m3-navitem" id="nav-silk-firetv" onclick="switchCmpApp('silk-firetv')">
            <span class="cmp-m3-navpill">
              <span class="material-symbols-outlined" style="font-size:17px;">tv_remote</span>
            </span>
            <span>Silk TV</span>
          </button>
          <button type="button" class="cmp-m3-navitem" id="nav-flex-jvm" onclick="switchCmpApp('flex-jvm')">
            <span class="cmp-m3-navpill">
              <span class="material-symbols-outlined" style="font-size:17px;">memory</span>
            </span>
            <span>Flex JVM</span>
          </button>
          <button type="button" class="cmp-m3-navitem" id="nav-foodfeed-inrix" onclick="switchCmpApp('foodfeed-inrix')">
            <span class="cmp-m3-navpill">
              <span class="material-symbols-outlined" style="font-size:17px;">directions_car</span>
            </span>
            <span>DOE/Car</span>
          </button>
        </div>

        <!-- Android Gesture Navigation Pill -->
        <div class="cmp-android-gesturebar">
          <div class="cmp-gesture-pill"></div>
        </div>

      </div>
    </div>

    <!-- 2. WIDESCREEN AMAZON FIRE TV + PHYSICAL SIDE D-PAD REMOTE (Shown for Silk Fire TV App) -->
    <div class="cmp-firetv-stage" id="cmpFireTvDeviceWrap">
      <div class="cmp-tv-and-remote-row">

        <!-- Left: 10-Foot Widescreen Smart TV Monitor -->
        <div class="cmp-tv-monitor-wrap">
          <div class="cmp-tv-bezel">
            <div class="cmp-tv-screen">
              <div id="cmpFireTvScreenViewport" style="flex:1; display:flex; flex-direction:column;"></div>

              <!-- Bottom Project Switcher Bar inside TV so user can switch back to any Mobile App or stay on TV -->
              <div class="cmp-m3-bottomnav" role="tablist" style="background:rgba(7,15,28,0.95); border-top:1px solid rgba(56,189,248,0.2);">
                <button type="button" class="cmp-m3-navitem" onclick="switchCmpApp('career-explorer')">
                  <span class="cmp-m3-navpill"><span class="material-symbols-outlined" style="font-size:17px;">timeline</span></span>
                  <span>Career</span>
                </button>
                <button type="button" class="cmp-m3-navitem" onclick="switchCmpApp('sdui-playground')">
                  <span class="cmp-m3-navpill"><span class="material-symbols-outlined" style="font-size:17px;">schema</span></span>
                  <span>SDUI</span>
                </button>
                <button type="button" class="cmp-m3-navitem" onclick="switchCmpApp('webrtc-telemetry')">
                  <span class="cmp-m3-navpill"><span class="material-symbols-outlined" style="font-size:17px;">videocam</span></span>
                  <span>WebRTC</span>
                </button>
                <button type="button" class="cmp-m3-navitem active" onclick="switchCmpApp('silk-firetv')">
                  <span class="cmp-m3-navpill"><span class="material-symbols-outlined" style="font-size:17px;">tv_remote</span></span>
                  <span>Silk TV</span>
                </button>
                <button type="button" class="cmp-m3-navitem" onclick="switchCmpApp('flex-jvm')">
                  <span class="cmp-m3-navpill"><span class="material-symbols-outlined" style="font-size:17px;">memory</span></span>
                  <span>Flex JVM</span>
                </button>
                <button type="button" class="cmp-m3-navitem" onclick="switchCmpApp('foodfeed-inrix')">
                  <span class="cmp-m3-navpill"><span class="material-symbols-outlined" style="font-size:17px;">directions_car</span></span>
                  <span>DOE/Car</span>
                </button>
              </div>
            </div>
            <div class="cmp-tv-chin">
              <span class="cmp-tv-led" id="cmpTvPowerLed"></span>
              <span>AMAZON FIRE TV • 10-FOOT SILK BROWSER</span>
            </div>
          </div>
          <div class="cmp-tv-stand-neck"></div>
          <div class="cmp-tv-stand-base"></div>
        </div>

        <!-- Right Side: Physical Fire TV Alexa Voice Remote with 8-Way (Cardinal + Diagonal) D-Pad Ring -->
        <div class="cmp-firetv-remote" aria-label="Amazon Fire TV D-Pad Remote Control">
          <div class="cmp-remote-top-row">
            <span class="cmp-remote-pwr" title="TV Power">
              <span class="material-symbols-outlined" style="font-size:13px;">power_settings_new</span>
            </span>
            <span class="cmp-remote-mic-led" id="cmpRemoteLed"></span>
          </div>

          <button type="button" class="cmp-remote-voice-btn" onclick="resetSilkCursorCenter()" title="Center Virtual Cursor">
            <span class="material-symbols-outlined" style="font-size:16px;">mic</span>
          </button>

          <!-- Tactile Circular 8-Way D-Pad Ring (Cardinal + Diagonal Movement) -->
          <div class="cmp-remote-dpad-ring">
            <button type="button" class="cmp-r-dir cmp-r-diag" onclick="moveSilkCursor(-12, -11)" title="D-Pad Up-Left (Diagonal)">↖</button>
            <button type="button" class="cmp-r-dir" onclick="moveSilkCursor(0, -14)" title="D-Pad Up">▲</button>
            <button type="button" class="cmp-r-dir cmp-r-diag" onclick="moveSilkCursor(12, -11)" title="D-Pad Up-Right (Diagonal)">↗</button>
            <button type="button" class="cmp-r-dir" onclick="moveSilkCursor(-16, 0)" title="D-Pad Left">◀</button>
            <button type="button" class="cmp-r-select" onclick="triggerSilkClick()" title="Select / Click">OK</button>
            <button type="button" class="cmp-r-dir" onclick="moveSilkCursor(16, 0)" title="D-Pad Right">▶</button>
            <button type="button" class="cmp-r-dir cmp-r-diag" onclick="moveSilkCursor(-12, 11)" title="D-Pad Down-Left (Diagonal)">↙</button>
            <button type="button" class="cmp-r-dir" onclick="moveSilkCursor(0, 14)" title="D-Pad Down">▼</button>
            <button type="button" class="cmp-r-dir cmp-r-diag" onclick="moveSilkCursor(12, 11)" title="D-Pad Down-Right (Diagonal)">↘</button>
          </div>

          <!-- Back / Home / Menu Row -->
          <div class="cmp-remote-btn-grid">
            <button type="button" class="cmp-remote-small-btn" onclick="moveSilkCursor(-16, 0)" title="Back">
              <span class="material-symbols-outlined" style="font-size:14px;">undo</span>
            </button>
            <button type="button" class="cmp-remote-small-btn" onclick="resetSilkCursorCenter()" title="Home">
              <span class="material-symbols-outlined" style="font-size:14px;">home</span>
            </button>
            <button type="button" class="cmp-remote-small-btn" onclick="toggleSilkSnapMode()" title="Toggle Magnetic Snap">
              <span class="material-symbols-outlined" style="font-size:14px;">menu</span>
            </button>
          </div>

          <!-- Media Transport Row -->
          <div class="cmp-remote-btn-grid">
            <button type="button" class="cmp-remote-small-btn" onclick="adjustSilkSpeed(-0.2)" title="Slower Cursor">
              <span class="material-symbols-outlined" style="font-size:14px;">fast_rewind</span>
            </button>
            <button type="button" class="cmp-remote-small-btn" onclick="triggerSilkClick()" title="Play/Select">
              <span class="material-symbols-outlined" style="font-size:14px;">play_arrow</span>
            </button>
            <button type="button" class="cmp-remote-small-btn" onclick="adjustSilkSpeed(0.2)" title="Faster Cursor">
              <span class="material-symbols-outlined" style="font-size:14px;">fast_forward</span>
            </button>
          </div>

          <div class="cmp-remote-brand">
            <img src="/images/Amazon_Silk_Logo.webp" alt="Amazon Silk" class="cmp-company-badge-sm">
            <span>FIRE TV REMOTE</span>
          </div>
        </div>

      </div>
    </div>

  </div>

  <!-- ==================== RIGHT: 6-APP LAUNCHER WITH COMPANY ICONS + LIVE CONTROLS + KOTLIN IDE ==================== -->
  <div class="cmp-right-column">

    <!-- 6 Project Mini-App Launcher Cards with Official Company Logos -->
    <div class="cmp-launcher-grid">
      <!-- 1. Career Explorer (All Companies) -->
      <button type="button" class="cmp-app-tile active" id="tile-career-explorer" onclick="switchCmpApp('career-explorer')">
        <img src="/images/DoorDash_Logo.svg.png" alt="Career Explorer" class="cmp-company-badge-lg">
        <div style="min-width:0;">
          <div class="cmp-app-tile-title">Career Explorer</div>
          <div class="cmp-app-tile-sub">
            <span class="cmp-multi-logo-stack">
              <img src="/images/DoorDash_Logo.svg.png" alt="DoorDash" class="cmp-company-badge-sm">
              <img src="/images/Amazon_icon.svg.png" alt="Amazon" class="cmp-company-badge-sm">
              <img src="/images/PNNL_CENTER_FullColorSMALL.jpg" alt="PNNL" class="cmp-company-badge-sm">
              <img src="/images/Syracuse_Orange_logo.svg" alt="Syracuse" class="cmp-company-badge-sm">
            </span>
            <span>All Roles</span>
          </div>
        </div>
      </button>

      <!-- 2. DoorDash SDUI & Hardware Studio -->
      <button type="button" class="cmp-app-tile" id="tile-sdui-playground" onclick="switchCmpApp('sdui-playground')">
        <img src="/images/DoorDash_Logo.svg.png" alt="DoorDash" class="cmp-company-badge-lg">
        <div style="min-width:0;">
          <div class="cmp-app-tile-title">SDUI &amp; Hardware</div>
          <div class="cmp-app-tile-sub">DoorDash • Live UI</div>
        </div>
      </button>

      <!-- 3. Amazon Care WebRTC Telemetry -->
      <button type="button" class="cmp-app-tile" id="tile-webrtc-telemetry" onclick="switchCmpApp('webrtc-telemetry')">
        <img src="/images/amazon-care.webp" alt="Amazon Care" class="cmp-company-badge-lg">
        <div style="min-width:0;">
          <div class="cmp-app-tile-title">WebRTC Telemetry</div>
          <div class="cmp-app-tile-sub">Amazon Care • Patent</div>
        </div>
      </button>

      <!-- 4. Amazon Silk Fire TV Virtual Cursor -->
      <button type="button" class="cmp-app-tile" id="tile-silk-firetv" onclick="switchCmpApp('silk-firetv')">
        <img src="/images/Amazon_Silk_Logo.webp" alt="Amazon Silk" class="cmp-company-badge-lg">
        <div style="min-width:0;">
          <div class="cmp-app-tile-title">Silk Fire TV Cursor</div>
          <div class="cmp-app-tile-sub">Amazon Silk • TV + Remote</div>
        </div>
      </button>

      <!-- 5. Amazon Flex JVM Memory & GC Profiler -->
      <button type="button" class="cmp-app-tile" id="tile-flex-jvm" onclick="switchCmpApp('flex-jvm')">
        <img src="/images/Amazon_icon.svg.png" alt="Amazon Flex" class="cmp-company-badge-lg">
        <div style="min-width:0;">
          <div class="cmp-app-tile-title">Flex JVM Profiler</div>
          <div class="cmp-app-tile-sub">Amazon Flex • Heap/GC</div>
        </div>
      </button>

      <!-- 6. PNNL FoodFeed & INRIX Connected Car -->
      <button type="button" class="cmp-app-tile" id="tile-foodfeed-inrix" onclick="switchCmpApp('foodfeed-inrix')">
        <img src="/images/PNNL_CENTER_FullColorSMALL.jpg" alt="PNNL & INRIX" class="cmp-company-badge-lg">
        <div style="min-width:0;">
          <div class="cmp-app-tile-title">FoodFeed &amp; Car SDK</div>
          <div class="cmp-app-tile-sub">
            <img src="/images/INRIX_logo.png" alt="INRIX" class="cmp-company-badge-sm">
            <span>PNNL &amp; INRIX</span>
          </div>
        </div>
      </button>
    </div>

    <!-- Dynamic Interactive State Controller for Active App -->
    <div class="cmp-inspector-card" id="cmpInspectorCard"></div>

    <!-- Demo Playlist & Blog Article Destinations (Synced with Resume Showcase) -->
    <div class="cmp-inspector-card" id="cmpMediaDestinationsCard"></div>

    <!-- JetBrains Darcula Syntax-Highlighted Kotlin Source Viewer (Collapsed by Default) -->
    <details class="cmp-ide-details" id="cmpKotlinIdeDetails">
      <summary class="cmp-ide-summary">
        <span style="display:inline-flex; align-items:center; gap:8px;">
          <span class="cmp-ide-dots">
            <span class="cmp-ide-dot" style="background:#ff5f56;"></span>
            <span class="cmp-ide-dot" style="background:#ffbd2e;"></span>
            <span class="cmp-ide-dot" style="background:#27c93f;"></span>
          </span>
          <span style="color:#ff8c33; font-family:var(--font-mono); font-weight:800;">K</span>
          <span>View Compose Multiplatform Kotlin Source (<code id="cmpActiveKotlinFilename" style="color:#3ddc84; font-family:var(--font-mono); font-size:0.75rem;">CareerExplorerApp.kt</code>)</span>
        </span>
        <span style="display:inline-flex; align-items:center; gap:4px; font-size:0.72rem; color:#9da0a8;">
          <span>Expand Code</span>
          <span class="material-symbols-outlined cmp-ide-chevron" style="font-size:18px;">expand_more</span>
        </span>
      </summary>

      <div class="cmp-ide-titlebar">
        <div class="cmp-ide-tabs">
          <button type="button" class="cmp-ide-tab active" id="tab-CareerExplorerApp" onclick="selectKotlinFile('CareerExplorerApp')">
            <span style="color:#ff8c33;">K</span> CareerExplorerApp.kt
          </button>
          <button type="button" class="cmp-ide-tab" id="tab-SduiPlaygroundApp" onclick="selectKotlinFile('SduiPlaygroundApp')">
            <span style="color:#ff8c33;">K</span> SduiPlaygroundApp.kt
          </button>
          <button type="button" class="cmp-ide-tab" id="tab-WebRtcSimulatorApp" onclick="selectKotlinFile('WebRtcSimulatorApp')">
            <span style="color:#ff8c33;">K</span> WebRtcSimulatorApp.kt
          </button>
          <button type="button" class="cmp-ide-tab" id="tab-SilkFireTvApp" onclick="selectKotlinFile('SilkFireTvApp')">
            <span style="color:#ff8c33;">K</span> SilkFireTvApp.kt
          </button>
          <button type="button" class="cmp-ide-tab" id="tab-FlexJvmProfilerApp" onclick="selectKotlinFile('FlexJvmProfilerApp')">
            <span style="color:#ff8c33;">K</span> FlexJvmProfilerApp.kt
          </button>
          <button type="button" class="cmp-ide-tab" id="tab-FoodFeedCarApp" onclick="selectKotlinFile('FoodFeedCarApp')">
            <span style="color:#ff8c33;">K</span> FoodFeedCarApp.kt
          </button>
          <button type="button" class="cmp-ide-tab" id="tab-MiniAppRegistry" onclick="selectKotlinFile('MiniAppRegistry')">
            <span style="color:#ff8c33;">K</span> MiniAppRegistry.kt
          </button>
        </div>

        <button type="button" class="cmp-copy-btn" onclick="copyActiveKotlinCode()" id="cmpCopyBtn">
          <span class="material-symbols-outlined" style="font-size:14px;">content_copy</span>
          <span id="cmpCopyText">Copy Kotlin</span>
        </button>
      </div>

      <div class="cmp-ide-body" id="cmpKotlinCodeViewport"></div>
    </details>

  </div>

</div>

<script>
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
      logo: "/images/DoorDash_Logo.svg.png",
      roleTitle: "Senior Software Engineer | Mobile Technical Lead",
      period: "Nov 2021 – Present (5 yrs)",
      brandColor: "#ff3008",
      deliverables: [
        {
          title: "Order Confirmation UI",
          logo: "/images/DoorDash_Logo.svg.png",
          subtitle: "Built from scratch • Android & iOS parity",
          architectureNotes: "Reactive state machine and extensible surface for dynamic ETA updates, multi-store order tracking, and promotional placements.",
          skills: ["Android & Jetpack Compose", "Kotlin & Coroutines", "Mobile Technical Leadership"],
          badge: "Millions Daily"
        },
        {
          title: "Dynamic Delivery Options",
          logo: "/images/DoorDash_Logo.svg.png",
          subtitle: "Backend-driven zero-release delivery windows",
          architectureNotes: "Orchestrated backend configuration schemas with reactive Android UI logic and led cross-platform iOS adoption.",
          skills: ["Server-Driven UI (SDUI)", "Kotlin & Coroutines", "Mobile Technical Leadership"],
          badge: "Zero-Release SDUI"
        },
        {
          title: "Hardware Integration (Hardware Peripherals)",
          logo: "/images/DoorDash_Logo.svg.png",
          subtitle: "Connected external hardware peripherals",
          architectureNotes: "Engineered low-latency peripheral discovery, connection resilience, and hardware telemetry pipelines.",
          skills: ["Hardware Peripherals", "Android & Jetpack Compose", "Kotlin & Coroutines"],
          badge: "Peripherals"
        },
        {
          title: "CI Build Time & Visual Regression Testing",
          logo: "/images/DoorDash_Logo.svg.png",
          subtitle: "Automated Compose screenshot testing & velocity",
          architectureNotes: "Instituted automated Jetpack Compose visual regression testing pipelines and modular build optimizations.",
          skills: ["CI & Visual Regression", "Android & Jetpack Compose", "Mobile Technical Leadership"],
          badge: "Dev Velocity"
        }
      ]
    },
    {
      stepNumber: 3,
      stageTitle: "AMAZON",
      organization: "Amazon (Care, Silk, Flex)",
      logo: "/images/Amazon_icon.svg.png",
      roleTitle: "Senior Software Engineer",
      period: "2015 – 2021 (6 yrs)",
      brandColor: "#ff9900",
      deliverables: [
        {
          title: "Amazon Care: Telehealth Audio/Video Engine",
          logo: "/images/amazon-care.webp",
          subtitle: "Video / Audio & App Platform Engineer",
          architectureNotes: "Built low-latency WebRTC telehealth conferencing engine with real-time packet-loss/jitter telemetry and dynamic bitrate adaptation.",
          skills: ["WebRTC & Real-Time Media", "Kotlin & Coroutines", "AWS & Cloud", "Mobile Technical Leadership"],
          badge: "Patent US11038933B1"
        },
        {
          title: "Amazon Silk: Fire TV Browser Lead",
          logo: "/images/Amazon_Silk_Logo.webp",
          subtitle: "10-Foot TV Web Browser (20M+ Devices)",
          architectureNotes: "Engineered Chromium-backed Leanback UI, HomeMenu launcher, and heuristic D-pad virtual cursor navigation.",
          skills: ["Android & Jetpack Compose", "Mobile Technical Leadership"],
          badge: "20M+ Devices"
        },
        {
          title: "Amazon Flex: JVM Performance Optimization",
          logo: "/images/Amazon_icon.svg.png",
          subtitle: "Memory profiling & GC tuning at scale",
          architectureNotes: "Built in-app memory telemetry profiler and eliminated systemic OOM crashes across delivery driver devices.",
          skills: ["Kotlin & Coroutines", "Android & Jetpack Compose"],
          badge: "JVM Tuning"
        }
      ]
    },
    {
      stepNumber: 2,
      stageTitle: "RESEARCH & EARLY CAREER",
      organization: "PNNL & INRIX",
      logo: "/images/PNNL_CENTER_FullColorSMALL.jpg",
      roleTitle: "Software Dev Engineer",
      period: "2013 – 2015",
      brandColor: "#0d9488",
      deliverables: [
        {
          title: "PNNL: FoodFeed Food Health App",
          logo: "/images/PNNL_CENTER_FullColorSMALL.jpg",
          subtitle: "1st Place Winner – DOE Mobile Challenge",
          architectureNotes: "Primary developer for the FoodFeed food health & bio-surveillance Android platform with real-time Java EE push sync.",
          skills: ["Android & Jetpack Compose", "AWS & Cloud"],
          badge: "1st Place DOE"
        },
        {
          title: "INRIX: Connected Car Mobility SDK",
          logo: "/images/INRIX_logo.png",
          subtitle: "Real-time traffic & connected vehicle SDK",
          architectureNotes: "Engineered mobile telemetry and route intelligence SDKs powering automotive head-units and navigation apps.",
          skills: ["Android & Jetpack Compose", "Hardware Peripherals"],
          badge: "Connected Car"
        }
      ]
    },
    {
      stepNumber: 1,
      stageTitle: "EDUCATION",
      organization: "Syracuse University & GGSIU",
      logo: "/images/Syracuse_Orange_logo.svg",
      roleTitle: "M.S. Computer Engineering • B.Tech CS",
      period: "2008 – 2014",
      brandColor: "#ea580c",
      deliverables: [
        {
          title: "Syracuse University — M.S. Computer Engineering",
          logo: "/images/Syracuse_Orange_logo.svg",
          subtitle: "Software Engineering & Mobile Systems",
          architectureNotes: "Awarded 50% Graduate Merit Scholarship for academic excellence in mobile systems and software architecture (GPA: 3.55/4.0).",
          skills: ["Android & Jetpack Compose", "Kotlin & Coroutines"],
          badge: "Merit Scholar"
        },
        {
          title: "GGSIU — B.Tech Computer Science",
          logo: "/images/GGSIU_logo.svg.png",
          subtitle: "First Division with Distinction (GPA: 3.97/4.0)",
          architectureNotes: "2nd Place Winner in IEEE India INNOVISION Linux Systems Challenge.",
          skills: ["Android & Jetpack Compose"],
          badge: "GPA 3.97/4.0"
        }
      ]
    }
  ];

  var KOTLIN_FILES = {
    CareerExplorerApp: [
      'package com.mohitb117.portfolio.apps',
      '',
      'import androidx.compose.animation.AnimatedVisibility',
      'import androidx.compose.foundation.layout.*',
      'import androidx.compose.material3.*',
      'import androidx.compose.runtime.*',
      'import androidx.compose.ui.Modifier',
      'import androidx.compose.ui.unit.dp',
      'import com.mohitb117.portfolio.model.PortfolioRepository',
      '',
      '// Interactive Material 3 Career Timeline with Company Logos & Skill Filter',
      '@Composable',
      'fun CareerExplorerApp() {',
      '    var selectedSkill by remember { mutableStateOf("All Skills") }',
      '    var expandedItem by remember { mutableStateOf("Order Confirmation UI") }',
      '',
      '    val stages = remember(selectedSkill) {',
      '        PortfolioRepository.filterBySkill(selectedSkill)',
      '    }',
      '',
      '    Column(',
      '        modifier = Modifier.fillMaxSize().padding(12.dp),',
      '        verticalArrangement = Arrangement.spacedBy(10.dp)',
      '    ) {',
      '        SkillFilterChipRow(',
      '            skills = PortfolioRepository.allSkills,',
      '            selected = selectedSkill,',
      '            onSelect = { skill -> selectedSkill = skill }',
      '        )',
      '        stages.forEach { stage ->',
      '            CareerStageCard(',
      '                stage = stage,',
      '                companyLogoUrl = stage.logoUrl,',
      '                expandedTitle = expandedItem,',
      '                onToggle = { title -> expandedItem = title }',
      '            )',
      '        }',
      '    }',
      '}'
    ],
    SduiPlaygroundApp: [
      'package com.mohitb117.portfolio.apps',
      '',
      'import androidx.compose.foundation.layout.*',
      'import androidx.compose.material3.*',
      'import androidx.compose.runtime.*',
      'import androidx.compose.ui.Modifier',
      'import androidx.compose.ui.unit.dp',
      '',
      '// DoorDash Server-Driven UI (SDUI) & Hardware Peripherals Live Studio',
      '@Composable',
      'fun SduiPlaygroundApp(',
      '    showOrderHeader: Boolean = true,',
      '    etaMinutes: Int = 26,',
      '    showDeliveryOptions: Boolean = true,',
      '    showHardwareBanner: Boolean = true',
      ') {',
      '    var selectedWindow by remember { mutableStateOf("Express (25–35 min)") }',
      '',
      '    Column(',
      '        modifier = Modifier.fillMaxSize().padding(12.dp),',
      '        verticalArrangement = Arrangement.spacedBy(10.dp)',
      '    ) {',
      '        if (showOrderHeader) {',
      '            OrderConfirmationCard(etaMinutes = etaMinutes)',
      '        }',
      '        if (showDeliveryOptions) {',
      '            DynamicDeliverySelector(',
      '                selected = selectedWindow,',
      '                onSelect = { window -> selectedWindow = window }',
      '            )',
      '        }',
      '        if (showHardwareBanner) {',
      '            HardwarePeripheralStatusCard(',
      '                deviceName = "Bluetooth Barcode & Fulfillment Scanner",',
      '                batteryPct = 98',
      '            )',
      '        }',
      '    }',
      '}'
    ],
    WebRtcSimulatorApp: [
      'package com.mohitb117.portfolio.apps',
      '',
      'import androidx.compose.foundation.layout.*',
      'import androidx.compose.material3.*',
      'import androidx.compose.runtime.*',
      'import androidx.compose.ui.Modifier',
      'import androidx.compose.ui.unit.dp',
      '',
      '// Amazon Care US Patent US11038933B1: Real-Time WebRTC Quality & Bitrate Controller',
      '@Composable',
      'fun WebRtcSimulatorApp(',
      '    packetLossPct: Float = 1.2f,',
      '    jitterMs: Float = 18f,',
      '    rttMs: Float = 65f',
      ') {',
      '    val mosScore = remember(packetLossPct, jitterMs, rttMs) {',
      '        val raw = 4.5f - (packetLossPct * 0.22f) - (jitterMs * 0.012f) - (rttMs * 0.003f)',
      '        raw.coerceIn(1.0f, 4.5f)',
      '    }',
      '',
      '    val profile = when {',
      '        mosScore >= 3.8f -> "1080p @ 60fps • VP9 / Opus Full-Band"',
      '        mosScore >= 2.9f -> "720p @ 30fps • H.264 + FEC Step-Down"',
      '        else -> "360p @ 15fps • Audio-Priority Recovery"',
      '    }',
      '',
      '    TelehealthCallViewport(',
      '        mosScore = mosScore,',
      '        activeProfile = profile,',
      '        packetLossPct = packetLossPct,',
      '        jitterMs = jitterMs',
      '    )',
      '}'
    ],
    SilkFireTvApp: [
      'package com.mohitb117.portfolio.apps',
      '',
      'import androidx.compose.foundation.layout.*',
      'import androidx.compose.material3.*',
      'import androidx.compose.runtime.*',
      'import androidx.compose.ui.Modifier',
      'import androidx.compose.ui.unit.dp',
      '',
      '// Amazon Silk Fire TV Browser (20M+ Devices): 10-Foot TV UI + Side D-Pad Remote',
      '@Composable',
      'fun SilkFireTvApp(',
      '    cursorAccel: Float = 1.8f,',
      '    magneticSnapEnabled: Boolean = true',
      ') {',
      '    var cursorX by remember { mutableStateOf(28) }',
      '    var cursorY by remember { mutableStateOf(38) }',
      '    var activeTile by remember { mutableStateOf("Prime Video 4K") }',
      '',
      '    Row(',
      '        modifier = Modifier.fillMaxSize().padding(12.dp),',
      '        horizontalArrangement = Arrangement.spacedBy(14.dp)',
      '    ) {',
      '        FireTvTenFootViewport(',
      '            modifier = Modifier.weight(1f),',
      '            cursorX = cursorX,',
      '            cursorY = cursorY,',
      '            snappedTile = activeTile,',
      '            magneticSnap = magneticSnapEnabled',
      '        )',
      '        FireTvDpadRemoteControl(',
      '            acceleration = cursorAccel,',
      '            onMove = { dx, dy ->',
      '                cursorX = (cursorX + (dx * cursorAccel).toInt()).coerceIn(10, 90)',
      '                cursorY = (cursorY + (dy * cursorAccel).toInt()).coerceIn(15, 85)',
      '            }',
      '        )',
      '    }',
      '}'
    ],
    FlexJvmProfilerApp: [
      'package com.mohitb117.portfolio.apps',
      '',
      'import androidx.compose.foundation.layout.*',
      'import androidx.compose.material3.*',
      'import androidx.compose.runtime.*',
      'import androidx.compose.ui.Modifier',
      'import androidx.compose.ui.unit.dp',
      '',
      '// Amazon Flex: In-App JVM Heap Memory Telemetry & GC Pause Profiler',
      '@Composable',
      'fun FlexJvmProfilerApp(',
      '    routeStopCount: Int = 48,',
      '    bitmapPoolReuse: Boolean = true',
      ') {',
      '    val allocatedMb = remember(routeStopCount, bitmapPoolReuse) {',
      '        val base = 92 + (routeStopCount * 1.8f).toInt()',
      '        if (bitmapPoolReuse) (base * 0.58f).toInt() else base',
      '    }',
      '    val gcPauseMs = if (bitmapPoolReuse) 3.4f else 28.6f',
      '',
      '    Column(',
      '        modifier = Modifier.fillMaxSize().padding(12.dp),',
      '        verticalArrangement = Arrangement.spacedBy(10.dp)',
      '    ) {',
      '        JvmHeapGaugeCard(allocatedMb = allocatedMb, maxHeapMb = 256)',
      '        GcLatencyTelemetryCard(',
      '            gcPauseMs = gcPauseMs,',
      '            bitmapPoolActive = bitmapPoolReuse,',
      '            oomRisk = if (allocatedMb > 210) "HIGH" else "LOW (OPTIMIZED)"',
      '        )',
      '    }',
      '}'
    ],
    FoodFeedCarApp: [
      'package com.mohitb117.portfolio.apps',
      '',
      'import androidx.compose.foundation.layout.*',
      'import androidx.compose.material3.*',
      'import androidx.compose.runtime.*',
      'import androidx.compose.ui.Modifier',
      'import androidx.compose.ui.unit.dp',
      '',
      '// PNNL FoodFeed (1st Place DOE) & INRIX Connected Car Mobility SDK',
      '@Composable',
      'fun FoodFeedCarApp(',
      '    activeTab: String = "FoodFeed (PNNL)",',
      '    vehicleSpeedMph: Int = 62,',
      '    fdaRecallPushActive: Boolean = true',
      ') {',
      '    Column(',
      '        modifier = Modifier.fillMaxSize().padding(12.dp),',
      '        verticalArrangement = Arrangement.spacedBy(10.dp)',
      '    ) {',
      '        FoodFeedBioSurveillanceCard(',
      '            pushEnabled = fdaRecallPushActive,',
      '            safetyScore = 96,',
      '            awardBadge = "1st Place – DOE Mobile Challenge"',
      '        )',
      '        InrixConnectedCarTelemetryCard(',
      '            speedMph = vehicleSpeedMph,',
      '            corridor = "I-90 Floating Bridge • Seattle",',
      '            congestionLevel = if (vehicleSpeedMph < 35) "Heavy Traffic" else "Free Flow"',
      '        )',
      '    }',
      '}'
    ],
    MiniAppRegistry: [
      'package com.mohitb117.portfolio.apps',
      '',
      'import androidx.compose.runtime.Composable',
      '',
      'data class PortfolioMiniApp(',
      '    val id: String,',
      '    val title: String,',
      '    val companyLogo: String,',
      '    val content: @Composable () -> Unit',
      ')',
      '',
      'object MiniAppRegistry {',
      '    val apps = listOf(',
      '        PortfolioMiniApp("career-explorer", "Career Explorer", "/images/DoorDash_Logo.svg.png") { CareerExplorerApp() },',
      '        PortfolioMiniApp("sdui-playground", "SDUI & Hardware Studio", "/images/DoorDash_Logo.svg.png") { SduiPlaygroundApp() },',
      '        PortfolioMiniApp("webrtc-telemetry", "WebRTC Telemetry Sim", "/images/amazon-care.webp") { WebRtcSimulatorApp() },',
      '        PortfolioMiniApp("silk-firetv", "Silk Fire TV Cursor", "/images/Amazon_Silk_Logo.webp") { SilkFireTvApp() },',
      '        PortfolioMiniApp("flex-jvm", "Flex JVM Profiler", "/images/Amazon_icon.svg.png") { FlexJvmProfilerApp() },',
      '        PortfolioMiniApp("foodfeed-inrix", "FoodFeed & Car SDK", "/images/PNNL_CENTER_FullColorSMALL.jpg") { FoodFeedCarApp() }',
      '    )',
      '}'
    ]
  };

  var currentAppId = 'career-explorer';
  var currentKotlinFile = 'CareerExplorerApp';
  var phoneDarkTheme = true;

  // App 1: Career Explorer state
  var selectedSkill = 'All Skills';
  var expandedDeliverable = 'Order Confirmation UI';

  // App 2: DoorDash SDUI state
  var sduiOrder = true;
  var sduiDelivery = true;
  var sduiHardware = true;
  var sduiEta = 26;
  var sduiWindow = 'Express (25–35 min)';

  // App 3: Amazon Care WebRTC state
  var webrtcLoss = 1.2;
  var webrtcJitter = 18;
  var webrtcRtt = 65;

  // App 4: Amazon Silk Fire TV state (Widescreen TV + Side D-Pad Remote)
  var silkCursorX = 28;
  var silkCursorY = 38;
  var silkAccel = 1.8;
  var silkMagneticSnap = true;
  var silkSnappedTile = 'Prime Video 4K';
  var silkActiveUrl = 'https://silk.amazon.com/firetv-home';
  var silkClickPulse = false;

  var SILK_TV_TILES = [
    { name: 'Prime Video 4K', sub: 'UHD HDR10+ Streaming', url: 'https://amazon.com/primevideo', x: 22, y: 38, icon: 'movie' },
    { name: 'IMDb TV Freevee', sub: 'Live Channels & Movies', url: 'https://imdb.com/tv', x: 50, y: 38, icon: 'live_tv' },
    { name: 'Silk Web Bookmarks', sub: 'Chromium 10-Foot Engine', url: 'https://silk.amazon.com/bookmarks', x: 78, y: 38, icon: 'bookmarks' },
    { name: 'Trending Sports Hub', sub: 'Thursday Night Football', url: 'https://amazon.com/tnf', x: 22, y: 74, icon: 'sports_football' },
    { name: 'YouTube 4K WebApp', sub: 'VP9 Hardware Decode', url: 'https://youtube.com/tv', x: 50, y: 74, icon: 'smart_display' },
    { name: 'Silk Privacy & AdGuard', sub: 'Protected TV Browsing', url: 'https://silk.amazon.com/security', x: 78, y: 74, icon: 'shield' }
  ];

  // App 5: Amazon Flex JVM Profiler state
  var flexStops = 48;
  var flexBitmapPool = true;
  var flexGcCount = 4;

  // App 6: PNNL FoodFeed & INRIX Connected Car state
  var foodFeedBarcode = '036000291452';
  var foodFeedAlertActive = true;
  var inrixSpeedMph = 62;

  // Demo Playlist & Blog Article Destinations (Synced with /resume/ & _data/portfolio_videos.yml)
  var activeEmbeddedDemoId = null;
  var showAllDemosInTray = false;

  var CMP_PORTFOLIO_DEMOS = [
    {
      id: 'COyElffSaxs',
      title: 'Amazon Care: End-to-End Telehealth Callback',
      subtitle: 'Provider Queueing & Automated Dispatch Flow',
      badge: 'Amazon Care',
      year: '2019',
      type: '16:9',
      appId: 'webrtc-telemetry',
      logo: '/images/amazon-care.webp',
      url: 'https://youtu.be/COyElffSaxs',
      post_url: '/revolutionizing-healthcare-tech-amazon-care/',
      post_title: 'Revolutionizing Healthcare Tech: Building Amazon Care from the Ground Up (2018–2021)'
    },
    {
      id: 'bGq9uFefcPY',
      title: 'WebRTC Real-Time Telemetry & Quality Engine',
      subtitle: 'US Patent US11038933B1 • Dynamic Adaptation',
      badge: 'US Patent',
      year: '2020',
      type: 'Short',
      appId: 'webrtc-telemetry',
      logo: '/images/amazon-care.webp',
      url: 'https://youtube.com/shorts/bGq9uFefcPY',
      post_url: '/revolutionizing-healthcare-tech-amazon-care/',
      post_title: 'Revolutionizing Healthcare Tech: Building Amazon Care from the Ground Up (2018–2021)'
    },
    {
      id: 'DqM70l8SU68',
      title: 'TextureViews vs SurfaceViews: Rounded Corners',
      subtitle: 'Hardware Layer Clipping Optimization',
      badge: 'Android UI',
      year: '2020',
      type: 'Short',
      appId: 'webrtc-telemetry',
      logo: '/images/amazon-care.webp',
      url: 'https://youtube.com/shorts/DqM70l8SU68',
      post_url: '/revolutionizing-healthcare-tech-amazon-care/',
      post_title: 'Revolutionizing Healthcare Tech: Building Amazon Care from the Ground Up (2018–2021)'
    },
    {
      id: 'eYIFfLZvmyg',
      title: 'Smooth Video Animations & PiP Transitions',
      subtitle: 'Picture-in-Picture & Fluid In-App Resizing',
      badge: 'Amazon Care',
      year: '2020',
      type: '16:9',
      appId: 'webrtc-telemetry',
      logo: '/images/amazon-care.webp',
      url: 'https://youtu.be/eYIFfLZvmyg',
      post_url: '/revolutionizing-healthcare-tech-amazon-care/',
      post_title: 'Revolutionizing Healthcare Tech: Building Amazon Care from the Ground Up (2018–2021)'
    },
    {
      id: 'xq66Aid3Zvw',
      title: 'Amazon Silk on Fire TV: Browser UI',
      subtitle: '10-Foot Television Web UX on Chromium',
      badge: 'Fire TV',
      year: '2016',
      type: '16:9',
      appId: 'silk-firetv',
      logo: '/images/Amazon_Silk_Logo.webp',
      url: 'https://youtu.be/xq66Aid3Zvw',
      post_url: '/blog/engineering-amazon-silk-fire-tv/',
      post_title: 'Engineering the Living Room Web: Deep Dive into Amazon Silk for Fire TV (2015–2018)'
    },
    {
      id: 'D00RIkvuwIA',
      title: 'Fire TV Virtual Cursor: Remote Navigation Engine',
      subtitle: 'Asynchronous Cursor Rendering & Heuristic Smoothing',
      badge: 'Fire TV',
      year: '2017',
      type: '16:9',
      appId: 'silk-firetv',
      logo: '/images/Amazon_Silk_Logo.webp',
      url: 'https://www.youtube.com/watch?v=D00RIkvuwIA',
      post_url: '/blog/engineering-amazon-silk-silk-fire-tv/'.replace('silk-silk-', 'silk-'),
      post_title: 'Engineering the Living Room Web: Deep Dive into Amazon Silk for Fire TV (2015–2018)'
    },
    {
      id: 'HVIy1bWt29Y',
      title: 'FoodFeed Bio-Surveillance App',
      subtitle: '1st Place Champion • US Dept. of Energy / PNNL',
      badge: 'PNNL / DOE',
      year: '2014',
      type: '16:9',
      appId: 'foodfeed-inrix',
      logo: '/images/PNNL_CENTER_FullColorSMALL.jpg',
      url: 'https://www.youtube.com/watch?v=HVIy1bWt29Y',
      post_url: '',
      post_title: '1st Place Winner • US Department of Energy Mobile App Challenge'
    }
  ];

  var CMP_APP_BLOG_META = {
    'career-explorer': {
      pill: 'Engineering Blog & Patent Destinations',
      title: 'Explore All 4 Engineering Deep-Dive Articles & 7 Video Demos',
      url: '/blog/',
      cta: 'All Blog Posts',
      secondaryUrl: '/resume/#demos',
      secondaryCta: 'Resume Showcase'
    },
    'sdui-playground': {
      pill: 'Featured Engineering Blog Posts',
      title: 'AI Multitasking & LLM-Assisted Mobile Release Engineering',
      url: '/blog/ai-multitasking-empowering-exhausting/',
      cta: 'Read AI Post',
      secondaryUrl: '/blog/welcome-to-llm-assisted-merging/',
      secondaryCta: 'Read Claude PR Post'
    },
    'webrtc-telemetry': {
      pill: 'Featured in Engineering Blog Post & US Patent',
      title: 'Revolutionizing Healthcare Tech: Building Amazon Care from the Ground Up (2018–2021)',
      url: '/revolutionizing-healthcare-tech-amazon-care/',
      cta: 'Read Amazon Care Post',
      secondaryUrl: 'https://patents.google.com/patent/US11038933B1/',
      secondaryCta: 'Patent US11038933B1'
    },
    'silk-firetv': {
      pill: 'Featured in Engineering Blog Post',
      title: 'Engineering the Living Room Web: Deep Dive into Amazon Silk for Fire TV (2015–2018)',
      url: '/blog/engineering-amazon-silk-fire-tv/',
      cta: 'Read Silk Fire TV Post',
      secondaryUrl: 'https://www.youtube.com/watch?v=D00RIkvuwIA',
      secondaryCta: 'Watch Cursor Demo'
    },
    'flex-jvm': {
      pill: 'Android Performance & Architecture Deep Dives',
      title: 'Engineering Blog: Mobile Architecture, JVM Profiling & AI Workflows',
      url: '/blog/welcome-to-llm-assisted-merging/',
      cta: 'Read Engineering Blog',
      secondaryUrl: '/resume/#experience',
      secondaryCta: 'Full CV Details'
    },
    'foodfeed-inrix': {
      pill: '1st Place National Lab Award Showcase',
      title: 'FoodFeed Bio-Surveillance App • 1st Place US Dept. of Energy Mobile Challenge',
      url: 'https://www.youtube.com/watch?v=HVIy1bWt29Y',
      cta: 'Watch DOE Demo Video',
      secondaryUrl: '/resume/#honors',
      secondaryCta: 'View Award Details'
    }
  };

  function getDemoById(demoId) {
    for (var i = 0; i < CMP_PORTFOLIO_DEMOS.length; i++) {
      if (CMP_PORTFOLIO_DEMOS[i].id === demoId) return CMP_PORTFOLIO_DEMOS[i];
    }
    return null;
  }

  function syncDeviceFrameForVideo() {
    var studioGrid = document.getElementById('cmpStudioGrid');
    var mobileWrap = document.getElementById('cmpMobileDeviceWrap');
    var fireTvWrap = document.getElementById('cmpFireTvDeviceWrap');
    if (!studioGrid || !mobileWrap || !fireTvWrap) return;

    // ONLY Silk Fire TV uses the widescreen TV cutout & TV stage; all other 5 apps stay in the Portrait Mobile Phone cutout!
    if (currentAppId === 'silk-firetv') {
      studioGrid.classList.add('tv-mode');
      mobileWrap.style.display = 'none';
      mobileWrap.classList.remove('landscape-video-mode');
      fireTvWrap.classList.add('active');
      return;
    }

    fireTvWrap.classList.remove('active');
    mobileWrap.style.display = 'flex';
    studioGrid.classList.remove('tv-mode');
    mobileWrap.classList.remove('landscape-video-mode');
  }

  function playDemoInDevice(demoId) {
    if (typeof triggerHaptic === 'function') triggerHaptic(12);
    var demo = getDemoById(demoId);
    if (!demo) return;

    // Switch to the matching mini-app so the phone / TV device preview matches the demo!
    if (currentAppId !== demo.appId) {
      switchCmpApp(demo.appId);
    }
    activeEmbeddedDemoId = demoId;
    syncDeviceFrameForVideo();

    renderPhoneViewport();
    renderFireTvScreen();
    renderMediaDestinationsPanel();
  }

  function closeDeviceVideo() {
    if (typeof triggerHaptic === 'function') triggerHaptic(10);
    activeEmbeddedDemoId = null;
    syncDeviceFrameForVideo();
    renderPhoneViewport();
    renderFireTvScreen();
    renderMediaDestinationsPanel();
  }

  function toggleAllDemosTray() {
    if (typeof triggerHaptic === 'function') triggerHaptic(8);
    showAllDemosInTray = !showAllDemosInTray;
    renderMediaDestinationsPanel();
  }

  function togglePhoneInternalTheme() {
    if (typeof triggerHaptic === 'function') triggerHaptic(10);
    phoneDarkTheme = !phoneDarkTheme;
    var glass = document.getElementById('cmpPhoneGlass');
    var icon = document.getElementById('cmpPhoneThemeIcon');
    if (phoneDarkTheme) {
      glass.classList.remove('phone-light');
      icon.textContent = 'light_mode';
    } else {
      glass.classList.add('phone-light');
      icon.textContent = 'dark_mode';
    }
    renderPhoneViewport();
  }

  function switchCmpApp(appId) {
    if (typeof triggerHaptic === 'function') triggerHaptic(12);
    currentAppId = appId;
    activeEmbeddedDemoId = null;

    document.querySelectorAll('.cmp-m3-navitem').forEach(function(el) { el.classList.remove('active'); });
    var activeNav = document.getElementById('nav-' + appId);
    if (activeNav) activeNav.classList.add('active');

    document.querySelectorAll('.cmp-app-tile').forEach(function(el) { el.classList.remove('active'); });
    var activeTile = document.getElementById('tile-' + appId);
    if (activeTile) activeTile.classList.add('active');

    syncDeviceFrameForVideo();

    var statusBar = document.getElementById('cmpStatusBar');
    var overline = document.getElementById('cmpPhoneOverline');
    var title = document.getElementById('cmpPhoneTitle');
    var logo = document.getElementById('cmpPhoneCompanyLogo');

    if (appId === 'career-explorer') {
      statusBar.style.background = '#0a2617';
      overline.textContent = 'All Companies • Material 3';
      title.textContent = 'Career & Skill Explorer';
      logo.src = '/images/DoorDash_Logo.svg.png';
      selectKotlinFile('CareerExplorerApp');
    } else if (appId === 'sdui-playground') {
      statusBar.style.background = '#450a0a';
      overline.textContent = 'DoorDash • Mobile Tech Lead';
      title.textContent = 'SDUI & Hardware Studio';
      logo.src = '/images/DoorDash_Logo.svg.png';
      selectKotlinFile('SduiPlaygroundApp');
    } else if (appId === 'webrtc-telemetry') {
      statusBar.style.background = '#3b2106';
      overline.textContent = 'Amazon Care • US11038933B1';
      title.textContent = 'WebRTC Telemetry Sim';
      logo.src = '/images/amazon-care.webp';
      selectKotlinFile('WebRtcSimulatorApp');
    } else if (appId === 'silk-firetv') {
      selectKotlinFile('SilkFireTvApp');
    } else if (appId === 'flex-jvm') {
      statusBar.style.background = '#2e1f05';
      overline.textContent = 'Amazon Flex • Android JVM';
      title.textContent = 'Heap & GC Telemetry';
      logo.src = '/images/Amazon_icon.svg.png';
      selectKotlinFile('FlexJvmProfilerApp');
    } else if (appId === 'foodfeed-inrix') {
      statusBar.style.background = '#06322d';
      overline.textContent = 'PNNL (1st Place DOE) & INRIX';
      title.textContent = 'FoodFeed & Car SDK';
      logo.src = '/images/PNNL_CENTER_FullColorSMALL.jpg';
      selectKotlinFile('FoodFeedCarApp');
    }

    renderPhoneViewport();
    renderFireTvScreen();
    renderInspectorPanel();
    renderMediaDestinationsPanel();
  }

  // Render the 10-Foot Widescreen Amazon Silk Fire TV Screen
  function renderFireTvScreen() {
    var tvScreen = document.getElementById('cmpFireTvScreenViewport');
    if (!tvScreen) return;

    // If a Fire TV video demo is playing inside the TV screen, render the embedded YouTube player
    if (activeEmbeddedDemoId && currentAppId === 'silk-firetv') {
      var activeDemo = getDemoById(activeEmbeddedDemoId);
      if (activeDemo) {
        tvScreen.innerHTML = (
          '<div style="padding:10px 16px; background:rgba(7,15,28,0.95); border-bottom:1px solid rgba(56,189,248,0.25); display:flex; align-items:center; justify-content:space-between; gap:10px;">' +
            '<button type="button" onclick="closeDeviceVideo()" style="background:rgba(56,189,248,0.18); border:1px solid #38bdf8; color:#38bdf8; border-radius:999px; padding:4px 12px; font-size:0.72rem; font-weight:800; cursor:pointer; display:inline-flex; align-items:center; gap:5px;">' +
              '<span class="material-symbols-outlined" style="font-size:15px;">arrow_back</span> Back to Interactive 10-Foot Cursor Simulator' +
            '</button>' +
            '<div style="font-size:0.78rem; font-weight:800; color:#fff; overflow:hidden; text-overflow:ellipsis; white-space:nowrap;">' + activeDemo.title + '</div>' +
            '<a href="' + activeDemo.post_url + '" style="background:#3ddc84; color:#002b12; text-decoration:none; padding:4px 12px; border-radius:999px; font-size:0.7rem; font-weight:800; white-space:nowrap;">Read Silk Blog Post ↗</a>' +
          '</div>' +
          '<div style="flex:1; background:#000; position:relative; min-height:360px;">' +
            '<iframe src="https://www.youtube-nocookie.com/embed/' + activeDemo.id + '?rel=0&modestbranding=1&autoplay=1" title="' + activeDemo.title + '" style="position:absolute; inset:0; width:100%; height:100%; border:0;" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>' +
          '</div>'
        );
        return;
      }
    }

    var tilesHtml = SILK_TV_TILES.map(function(t) {
      var isFocused = silkSnappedTile === t.name;
      var borderStyle = isFocused
        ? '2px solid #38bdf8; box-shadow:0 0 18px rgba(56,189,248,0.48); transform:scale(1.02);'
        : '1px solid rgba(255,255,255,0.14);';
      var bgStyle = isFocused
        ? 'linear-gradient(145deg, rgba(2,132,199,0.45), rgba(15,23,42,0.92))'
        : 'rgba(15, 23, 42, 0.68)';

      return (
        '<div onclick="snapSilkTile(\'' + t.name + '\',' + t.x + ',' + t.y + ',\'' + t.url + '\')" style="padding:18px 16px; border-radius:14px; border:' + borderStyle + '; background:' + bgStyle + '; cursor:pointer; display:flex; flex-direction:column; justify-content:space-between; min-height:118px; transition:all 0.16s ease;">' +
          '<div style="display:flex; justify-content:space-between; align-items:center;">' +
            '<span class="material-symbols-outlined" style="font-size:24px; color:' + (isFocused ? '#38bdf8' : '#94a3b8') + ';">' + t.icon + '</span>' +
            (isFocused ? '<span style="font-size:0.62rem; font-weight:800; padding:2px 7px; border-radius:6px; background:#38bdf8; color:#000;">MAGNETIC FOCUS</span>' : '') +
          '</div>' +
          '<div style="margin-top:10px;">' +
            '<div style="font-size:0.9rem; font-weight:800; line-height:1.2; color:#fff;">' + t.name + '</div>' +
            '<div style="font-size:0.72rem; color:#94a3b8; margin-top:3px;">' + t.sub + '</div>' +
          '</div>' +
        '</div>'
      );
    }).join('');

    var cursorRingSize = silkClickPulse ? 32 : 24;
    var cursorColor = silkClickPulse ? '#38bdf8' : '#3ddc84';

    tvScreen.innerHTML = (
      /* Top 10-Foot Chromium Address & Telemetry Bar */
      '<div style="padding:11px 18px; background:rgba(7,15,28,0.92); border-bottom:1px solid rgba(255,255,255,0.12); display:flex; align-items:center; justify-content:space-between; gap:12px;">' +
        '<div style="display:flex; align-items:center; gap:9px; min-width:0; flex:1;">' +
          '<img src="/images/Amazon_Silk_Logo.webp" alt="Amazon Silk" class="cmp-company-badge">' +
          '<span style="font-size:0.82rem; font-weight:800; color:#38bdf8; white-space:nowrap;">Amazon Silk Browser</span>' +
          '<div style="background:rgba(255,255,255,0.08); border:1px solid rgba(255,255,255,0.14); border-radius:999px; padding:4px 14px; font-family:var(--font-mono); font-size:0.72rem; color:#e2e8f0; overflow:hidden; text-overflow:ellipsis; white-space:nowrap; max-width:340px;">' +
            silkActiveUrl +
          '</div>' +
        '</div>' +
        '<div style="display:flex; align-items:center; gap:8px;">' +
          '<button type="button" onclick="playDemoInDevice(\'D00RIkvuwIA\')" style="background:rgba(56,189,248,0.18); border:1px solid #38bdf8; color:#7dd3fc; border-radius:999px; padding:3px 10px; font-size:0.66rem; font-weight:800; cursor:pointer; display:inline-flex; align-items:center; gap:4px;">' +
            '<span class="material-symbols-outlined" style="font-size:14px;">play_circle</span> Watch Cursor Demo' +
          '</button>' +
          '<a href="/blog/engineering-amazon-silk-fire-tv/" style="background:rgba(61,220,132,0.18); border:1px solid #3ddc84; color:#3ddc84; text-decoration:none; border-radius:999px; padding:3px 10px; font-size:0.66rem; font-weight:800; display:inline-flex; align-items:center; gap:4px;">' +
            '<span class="material-symbols-outlined" style="font-size:14px;">menu_book</span> Read Silk Blog Post' +
          '</a>' +
        '</div>' +
      '</div>' +

      /* Main 10-Foot Spatial Canvas with Virtual Cursor Overlay */
      '<div style="flex:1; position:relative; padding:20px 22px; display:flex; flex-direction:column; justify-content:space-between;">' +
        '<div style="display:grid; grid-template-columns:repeat(3, 1fr); gap:14px; margin:auto 0;">' +
          tilesHtml +
        '</div>' +

        /* Heuristic Virtual Cursor Pointer */
        '<div style="position:absolute; left:' + silkCursorX + '%; top:' + silkCursorY + '%; transform:translate(-50%,-50%); width:' + cursorRingSize + 'px; height:' + cursorRingSize + 'px; border-radius:50%; border:2.5px solid ' + cursorColor + '; background:rgba(61,220,132,0.28); box-shadow:0 0 16px ' + cursorColor + '; pointer-events:none; transition:left 0.14s cubic-bezier(0.2,0.9,0.3,1), top 0.14s cubic-bezier(0.2,0.9,0.3,1), width 0.12s ease, height 0.12s ease; display:flex; align-items:center; justify-content:center;">' +
          '<div style="width:6px; height:6px; border-radius:50%; background:#ffffff;"></div>' +
        '</div>' +

        /* Bottom TV Status & Telemetry Bar */
        '<div style="margin-top:14px; padding-top:9px; border-top:1px solid rgba(255,255,255,0.12); display:flex; justify-content:space-between; align-items:center; font-size:0.72rem; color:#93c5fd;">' +
          '<span>Virtual Cursor: <strong>(' + silkCursorX + '%, ' + silkCursorY + '%)</strong> • 8-Way D-Pad Accel: <strong>' + silkAccel.toFixed(1) + 'x</strong></span>' +
          '<span>Snapped DOM Node: <strong style="color:#3ddc84;">' + silkSnappedTile + '</strong></span>' +
        '</div>' +
      '</div>'
    );
  }

  function renderPhoneViewport() {
    var viewport = document.getElementById('cmpPhoneViewport');
    if (!viewport) return;

    // If a video demo is playing inside the mobile phone screen, render the embedded YouTube player edge-to-edge matching the phone preview
    if (activeEmbeddedDemoId && currentAppId !== 'silk-firetv') {
      var activeDemo = getDemoById(activeEmbeddedDemoId);
      if (activeDemo) {
        viewport.style.padding = '0';
        viewport.style.overflow = 'hidden';

        var blogActionHtml = activeDemo.post_url
          ? '<a href="' + activeDemo.post_url + '" style="display:inline-flex; align-items:center; gap:4px; padding:4px 10px; border-radius:999px; background:#3ddc84; color:#002b12; font-size:0.68rem; font-weight:800; text-decoration:none; white-space:nowrap;"><span class="material-symbols-outlined" style="font-size:13px;">menu_book</span> Read Blog ↗</a>'
          : '<a href="' + activeDemo.url + '" target="_blank" rel="noopener noreferrer" style="display:inline-flex; align-items:center; gap:4px; padding:4px 10px; border-radius:999px; background:#38bdf8; color:#001e2b; font-size:0.68rem; font-weight:800; text-decoration:none; white-space:nowrap;"><span class="material-symbols-outlined" style="font-size:13px;">open_in_new</span> YouTube ↗</a>';

        viewport.innerHTML = (
          '<div style="flex:1; width:100%; height:100%; display:flex; flex-direction:column; background:#000;">' +
            '<div style="padding:7px 12px; background:rgba(13,17,23,0.95); border-bottom:1px solid rgba(255,255,255,0.12); display:flex; justify-content:space-between; align-items:center; gap:8px; flex-shrink:0;">' +
              '<button type="button" onclick="closeDeviceVideo()" style="background:rgba(56,189,248,0.18); border:1px solid #38bdf8; color:#38bdf8; border-radius:999px; padding:3px 10px; font-size:0.66rem; font-weight:800; cursor:pointer; display:inline-flex; align-items:center; gap:4px; white-space:nowrap;">' +
                '<span class="material-symbols-outlined" style="font-size:13px;">arrow_back</span> Interactive Simulator' +
              '</button>' +
              '<div style="font-size:0.7rem; font-weight:800; color:#f0f6fc; overflow:hidden; text-overflow:ellipsis; white-space:nowrap; flex:1; text-align:center;">' +
                activeDemo.title +
              '</div>' +
              blogActionHtml +
            '</div>' +
            '<div style="flex:1; width:100%; position:relative; background:#000;">' +
              '<iframe src="https://www.youtube-nocookie.com/embed/' + activeDemo.id + '?rel=0&modestbranding=1&autoplay=1&playsinline=1" title="' + activeDemo.title + '" style="position:absolute; inset:0; width:100%; height:100%; border:0;" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>' +
            '</div>' +
          '</div>'
        );
        return;
      }
    }

    viewport.style.padding = '11px';
    viewport.style.overflowY = 'auto';

    if (currentAppId === 'career-explorer') {
      var chipsHtml = CMP_SKILLS.map(function(skill) {
        var act = skill === selectedSkill ? ' active' : '';
        return '<button type="button" class="cmp-m3-chip' + act + '" onclick="setSkillFilter(\'' + skill + '\')">' + skill + '</button>';
      }).join('');

      var stagesHtml = CMP_STAGES.map(function(st) {
        var matching = st.deliverables.filter(function(d) {
          return selectedSkill === 'All Skills' || d.skills.indexOf(selectedSkill) !== -1;
        });
        if (!matching.length) return '';

        var rows = matching.map(function(d) {
          var isExp = expandedDeliverable === d.title;
          var expHtml = isExp ? (
            '<div style="margin-top:6px; padding-top:6px; border-top:1px dashed rgba(150,150,150,0.25); font-size:0.71rem; line-height:1.4; opacity:0.92;">' +
              d.architectureNotes +
            '</div>'
          ) : '';

          return (
            '<div class="cmp-m3-subcard" onclick="togglePhoneDeliverable(\'' + d.title.replace(/'/g, "\\'") + '\')">' +
              '<div style="display:flex; justify-content:space-between; align-items:flex-start; gap:6px;">' +
                '<div style="display:flex; align-items:center; gap:6px; min-width:0;">' +
                  '<img src="' + d.logo + '" alt="" class="cmp-company-badge-sm">' +
                  '<div style="font-size:0.76rem; font-weight:700; line-height:1.2;">' + d.title + '</div>' +
                '</div>' +
                '<span style="font-size:0.6rem; font-weight:800; padding:2px 6px; border-radius:6px; background:rgba(61,220,132,0.16); color:#3ddc84; white-space:nowrap;">' + d.badge + '</span>' +
              '</div>' +
              '<div style="font-size:0.69rem; opacity:0.75; margin-top:3px; padding-left:24px;">' + d.subtitle + '</div>' +
              expHtml +
            '</div>'
          );
        }).join('');

        return (
          '<div class="cmp-m3-card">' +
            '<div style="display:flex; justify-content:space-between; align-items:center;">' +
              '<span style="font-size:0.62rem; font-weight:800; color:' + st.brandColor + ';">' + st.stepNumber + '. ' + st.stageTitle + '</span>' +
              '<span style="font-size:0.62rem; opacity:0.7;">' + st.period + '</span>' +
            '</div>' +
            '<div style="display:flex; align-items:center; gap:7px; margin-top:4px;">' +
              '<img src="' + st.logo + '" alt="' + st.organization + '" class="cmp-company-badge">' +
              '<div>' +
                '<div style="font-size:0.86rem; font-weight:800; line-height:1.15;">' + st.organization + '</div>' +
                '<div style="font-size:0.69rem; opacity:0.8;">' + st.roleTitle + '</div>' +
              '</div>' +
            '</div>' +
            rows +
          '</div>'
        );
      }).join('');

      viewport.innerHTML = '<div class="cmp-phone-chip-row">' + chipsHtml + '</div>' + stagesHtml;

    } else if (currentAppId === 'sdui-playground') {
      var nodes = '';
      if (sduiOrder) {
        nodes += (
          '<div class="cmp-m3-card" style="border-left:4px solid #ff3008;">' +
            '<div style="display:flex; justify-content:space-between; align-items:center;">' +
              '<div style="display:flex; align-items:center; gap:6px;">' +
                '<img src="/images/DoorDash_Logo.svg.png" alt="DoorDash" class="cmp-company-badge-sm">' +
                '<span style="font-size:0.64rem; font-weight:800; color:#ff3008; text-transform:uppercase;">OrderConfirmationHeader</span>' +
              '</div>' +
              '<span style="font-size:0.63rem; padding:2px 6px; border-radius:999px; background:rgba(34,197,94,0.18); color:#4ade80; font-weight:700;">Active</span>' +
            '</div>' +
            '<div style="font-size:1.02rem; font-weight:800; margin-top:5px;">Arriving in ' + sduiEta + ' mins</div>' +
            '<div style="font-size:0.72rem; opacity:0.78; margin-top:2px;">Multi-Store Order • Android &amp; iOS Parity</div>' +
          '</div>'
        );
      }
      if (sduiDelivery) {
        var opts = ['Express (25–35 min)', 'Standard (40–55 min)', 'Scheduled (4:00–5:00 PM)'].map(function(w) {
          var sel = w === sduiWindow;
          var st = sel
            ? 'background:#ff3008; color:#fff; font-weight:800; border-color:#ff3008;'
            : 'background:transparent; color:inherit; border-color:rgba(150,150,150,0.3);';
          return '<button type="button" onclick="setSduiWindow(\'' + w + '\')" style="width:100%; text-align:left; padding:7px 10px; border-radius:9px; border:1px solid; font-size:0.73rem; cursor:pointer; margin-top:5px; ' + st + '">' + w + '</button>';
        }).join('');

        nodes += (
          '<div class="cmp-m3-card">' +
            '<div style="display:flex; align-items:center; gap:6px;">' +
              '<img src="/images/DoorDash_Logo.svg.png" alt="DoorDash" class="cmp-company-badge-sm">' +
              '<span style="font-size:0.64rem; font-weight:800; color:#38bdf8; text-transform:uppercase;">DynamicDeliveryWindowSelector</span>' +
            '</div>' +
            '<div style="font-size:0.8rem; font-weight:700; margin-top:4px;">Select Delivery Option (Zero-Release SDUI)</div>' +
            opts +
          '</div>'
        );
      }
      if (sduiHardware) {
        nodes += (
          '<div class="cmp-m3-card" style="border-left:4px solid #3ddc84;">' +
            '<div style="display:flex; align-items:center; gap:6px;">' +
              '<img src="/images/DoorDash_Logo.svg.png" alt="DoorDash" class="cmp-company-badge-sm">' +
              '<span style="font-size:0.64rem; font-weight:800; color:#3ddc84; text-transform:uppercase;">HardwarePeripheralStatusBanner</span>' +
            '</div>' +
            '<div style="font-size:0.83rem; font-weight:800; margin-top:4px;">Hardware Peripherals Ready</div>' +
            '<div style="font-size:0.71rem; opacity:0.8; margin-top:2px;">Bluetooth Fulfillment Scanner • 98% Battery</div>' +
          '</div>'
        );
      }
      if (!nodes) {
        nodes = '<div class="cmp-m3-card" style="text-align:center; padding:2.5rem 1rem; opacity:0.75; font-size:0.8rem;">All SDUI JSON nodes disabled.<br>Toggle a node in the controller on the right!</div>';
      }
      viewport.innerHTML = nodes;

    } else if (currentAppId === 'webrtc-telemetry') {
      var mos = Math.max(1.0, Math.min(4.5, 4.5 - (webrtcLoss * 0.22) - (webrtcJitter * 0.012) - (webrtcRtt * 0.003)));
      var badgeColor = mos >= 3.8 ? '#3ddc84' : (mos >= 2.9 ? '#f59e0b' : '#ef4444');
      var resLabel = mos >= 3.8 ? '1080p • 60fps • VP9' : (mos >= 2.9 ? '720p • 30fps • H.264 FEC' : '360p • 15fps • Audio Priority');

      viewport.innerHTML = (
        '<div class="cmp-m3-card" style="background:linear-gradient(160deg, #111927 0%, #0a2617 100%); color:#fff; border-color:#30363d; text-align:center; padding:14px 12px;">' +
          '<div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:10px;">' +
            '<span style="display:inline-flex; align-items:center; gap:5px; font-size:0.65rem; background:rgba(0,0,0,0.45); padding:3px 8px; border-radius:999px; font-weight:700;">' +
              '<img src="/images/amazon-care.webp" alt="Amazon Care" class="cmp-company-badge-sm"> Amazon Care' +
            '</span>' +
            '<span style="font-size:0.65rem; background:' + badgeColor + '; color:#000; padding:2px 8px; border-radius:999px; font-weight:800;">MOS ' + mos.toFixed(2) + '</span>' +
          '</div>' +
          '<div style="width:62px; height:62px; border-radius:50%; background:rgba(61,220,132,0.16); border:2px solid ' + badgeColor + '; margin:4px auto 8px; display:flex; align-items:center; justify-content:center;">' +
            '<span class="material-symbols-outlined" style="font-size:32px; color:' + badgeColor + ';">videocam</span>' +
          '</div>' +
          '<div style="font-size:0.9rem; font-weight:800;">Dr. Sarah Jenkins, MD</div>' +
          '<div style="font-size:0.71rem; color:#9aa0a6; margin-top:2px;">Active Stream: ' + resLabel + '</div>' +
        '</div>' +
        '<div class="cmp-m3-card">' +
          '<div style="display:flex; align-items:center; gap:6px;">' +
            '<img src="/images/amazon-care.webp" alt="Amazon Care" class="cmp-company-badge-sm">' +
            '<span style="font-size:0.65rem; font-weight:800; color:#ff9900; text-transform:uppercase;">Patent US11038933B1 Telemetry</span>' +
          '</div>' +
          '<div style="display:grid; grid-template-columns:repeat(3,1fr); gap:6px; margin-top:8px; text-align:center;">' +
            '<div class="cmp-m3-subcard" style="margin:0;"><div style="font-size:0.63rem; opacity:0.7;">Loss</div><div style="font-size:0.82rem; font-weight:800;">' + webrtcLoss.toFixed(1) + '%</div></div>' +
            '<div class="cmp-m3-subcard" style="margin:0;"><div style="font-size:0.63rem; opacity:0.7;">Jitter</div><div style="font-size:0.82rem; font-weight:800;">' + webrtcJitter + 'ms</div></div>' +
            '<div class="cmp-m3-subcard" style="margin:0;"><div style="font-size:0.63rem; opacity:0.7;">RTT</div><div style="font-size:0.82rem; font-weight:800;">' + webrtcRtt + 'ms</div></div>' +
          '</div>' +
          '<div style="margin-top:8px; font-size:0.71rem; opacity:0.85; line-height:1.4;">' +
            'Adaptive Media Controller scales video resolution and Forward Error Correction (FEC) from real-time RTCP reports.' +
          '</div>' +
          '<div style="display:flex; flex-wrap:wrap; gap:6px; margin-top:9px; padding-top:8px; border-top:1px dashed rgba(150,150,150,0.25);">' +
            '<button type="button" onclick="playDemoInDevice(\'bGq9uFefcPY\')" style="flex:1; padding:6px 8px; border-radius:8px; border:1px solid #38bdf8; background:rgba(56,189,248,0.14); color:inherit; font-size:0.68rem; font-weight:800; cursor:pointer; display:inline-flex; align-items:center; justify-content:center; gap:4px;"><span class="material-symbols-outlined" style="font-size:14px;">play_circle</span> Play WebRTC Demo</button>' +
            '<a href="/revolutionizing-healthcare-tech-amazon-care/" style="flex:1; padding:6px 8px; border-radius:8px; border:1px solid #3ddc84; background:rgba(61,220,132,0.14); color:inherit; text-decoration:none; font-size:0.68rem; font-weight:800; display:inline-flex; align-items:center; justify-content:center; gap:4px;"><span class="material-symbols-outlined" style="font-size:14px;">menu_book</span> Read Blog Post</a>' +
          '</div>' +
        '</div>'
      );

    } else if (currentAppId === 'flex-jvm') {
      var rawMb = 92 + Math.round(flexStops * 1.8);
      var usedMb = flexBitmapPool ? Math.round(rawMb * 0.56) : rawMb;
      var maxMb = 256;
      var pct = Math.min(98, Math.round((usedMb / maxMb) * 100));
      var barColor = pct > 82 ? '#ef4444' : (pct > 65 ? '#f59e0b' : '#3ddc84');
      var gcPause = flexBitmapPool ? '3.4 ms' : '28.6 ms';
      var frameDrop = flexBitmapPool ? '0.2% Jank' : '11.4% Jank';

      viewport.innerHTML = (
        '<div class="cmp-m3-card" style="border-left:4px solid #ff9900;">' +
          '<div style="display:flex; justify-content:space-between; align-items:center;">' +
            '<span style="display:inline-flex; align-items:center; gap:6px; font-size:0.64rem; font-weight:800; color:#ff9900; text-transform:uppercase;">' +
              '<img src="/images/Amazon_icon.svg.png" alt="Amazon Flex" class="cmp-company-badge-sm"> Flex JVM Heap Monitor' +
            '</span>' +
            '<span style="font-size:0.63rem; font-weight:800; color:' + barColor + ';">' + usedMb + ' / ' + maxMb + ' MB (' + pct + '%)</span>' +
          '</div>' +
          '<div style="height:10px; background:rgba(150,150,150,0.2); border-radius:999px; overflow:hidden; margin:8px 0;">' +
            '<div style="width:' + pct + '%; height:100%; background:' + barColor + '; transition:width 0.2s ease;"></div>' +
          '</div>' +
          '<div style="font-size:0.71rem; opacity:0.82;">Active Delivery Itinerary: <strong>' + flexStops + ' Stops</strong> • GC Cycles: <strong>' + flexGcCount + '</strong></div>' +
        '</div>' +
        '<div class="cmp-m3-card">' +
          '<div style="font-size:0.65rem; font-weight:800; color:#3ddc84; text-transform:uppercase;">GC Latency &amp; OOM Crash Mitigation</div>' +
          '<div style="display:grid; grid-template-columns:1fr 1fr; gap:6px; margin-top:8px; text-align:center;">' +
            '<div class="cmp-m3-subcard" style="margin:0;"><div style="font-size:0.63rem; opacity:0.7;">Avg GC Pause</div><div style="font-size:0.84rem; font-weight:800; color:' + barColor + ';">' + gcPause + '</div></div>' +
            '<div class="cmp-m3-subcard" style="margin:0;"><div style="font-size:0.63rem; opacity:0.7;">UI Frame Jank</div><div style="font-size:0.84rem; font-weight:800;">' + frameDrop + '</div></div>' +
          '</div>' +
          '<button type="button" onclick="runManualGc()" style="width:100%; margin-top:9px; padding:7px 10px; border-radius:9px; border:1px solid #ff9900; background:rgba(255,153,0,0.15); color:inherit; font-size:0.73rem; font-weight:800; cursor:pointer;">Trigger Explicit GC &amp; Compact Heap</button>' +
        '</div>'
      );

    } else if (currentAppId === 'foodfeed-inrix') {
      var congestion = inrixSpeedMph < 35 ? 'Heavy Congestion (Red)' : (inrixSpeedMph < 52 ? 'Moderate Flow (Yellow)' : 'Free Flow (Green)');
      var congColor = inrixSpeedMph < 35 ? '#ef4444' : (inrixSpeedMph < 52 ? '#f59e0b' : '#3ddc84');

      viewport.innerHTML = (
        '<div class="cmp-m3-card" style="border-left:4px solid #0d9488;">' +
          '<div style="display:flex; justify-content:space-between; align-items:center;">' +
            '<span style="display:inline-flex; align-items:center; gap:6px; font-size:0.64rem; font-weight:800; color:#2dd4bf; text-transform:uppercase;">' +
              '<img src="/images/PNNL_CENTER_FullColorSMALL.jpg" alt="PNNL" class="cmp-company-badge-sm"> PNNL FoodFeed App' +
            '</span>' +
            '<span style="font-size:0.6rem; background:rgba(45,212,191,0.18); color:#2dd4bf; padding:2px 6px; border-radius:6px; font-weight:800;">1st Place DOE</span>' +
          '</div>' +
          '<div style="font-size:0.84rem; font-weight:800; margin-top:5px;">UPC Scan: #' + foodFeedBarcode + '</div>' +
          '<div style="font-size:0.71rem; opacity:0.85; margin-top:2px;">Health Score: <strong>96/100</strong> • Bio-Surveillance Status: <strong style="color:' + (foodFeedAlertActive ? '#3ddc84' : '#f59e0b') + ';">' + (foodFeedAlertActive ? 'Verified Safe (Live Push)' : 'Offline Cache') + '</strong></div>' +
          '<button type="button" onclick="playDemoInDevice(\'HVIy1bWt29Y\')" style="width:100%; margin-top:8px; padding:6px 10px; border-radius:8px; border:1px solid #2dd4bf; background:rgba(45,212,191,0.14); color:inherit; font-size:0.69rem; font-weight:800; cursor:pointer; display:inline-flex; align-items:center; justify-content:center; gap:5px;"><span class="material-symbols-outlined" style="font-size:15px;">play_circle</span> Watch 1st Place DOE FoodFeed Video Demo</button>' +
        '</div>' +
        '<div class="cmp-m3-card" style="border-left:4px solid #38bdf8;">' +
          '<div style="display:flex; justify-content:space-between; align-items:center;">' +
            '<span style="display:inline-flex; align-items:center; gap:6px; font-size:0.64rem; font-weight:800; color:#38bdf8; text-transform:uppercase;">' +
              '<img src="/images/INRIX_logo.png" alt="INRIX" class="cmp-company-badge-sm"> INRIX Connected Car SDK' +
            '</span>' +
            '<span style="font-size:0.64rem; font-weight:800; color:' + congColor + ';">' + inrixSpeedMph + ' MPH</span>' +
          '</div>' +
          '<div style="font-size:0.83rem; font-weight:800; margin-top:5px;">I-90 Floating Bridge Corridor</div>' +
          '<div style="font-size:0.71rem; opacity:0.82; margin-top:2px;">Telemetry Status: <strong style="color:' + congColor + ';">' + congestion + '</strong></div>' +
          '<div style="font-size:0.68rem; opacity:0.72; margin-top:4px;">Real-time GPS probe fusion &amp; predictive ETA routing SDK</div>' +
        '</div>'
      );
    }
  }

  var CMP_APP_PREVIEW_META = {
    'career-explorer': {
      title: 'Interactive Career & Skill Explorer',
      deviceBadge: '📱 Phone 9:16',
      logo: '/images/DoorDash_Logo.svg.png',
      company: 'All Companies',
      bgGradient: 'linear-gradient(145deg, #0a2617 0%, #111927 100%)',
      icon: 'work_history',
      accentColor: '#3ddc84'
    },
    'sdui-playground': {
      title: 'Interactive DoorDash SDUI & Hardware Studio',
      deviceBadge: '📱 Phone 9:16',
      logo: '/images/DoorDash_Logo.svg.png',
      company: 'DoorDash',
      bgGradient: 'linear-gradient(145deg, #450a0a 0%, #111927 100%)',
      icon: 'widgets',
      accentColor: '#ff3008'
    },
    'webrtc-telemetry': {
      title: 'Interactive Amazon Care WebRTC Simulator',
      deviceBadge: '📱 Phone 9:16',
      logo: '/images/amazon-care.webp',
      company: 'Amazon Care',
      bgGradient: 'linear-gradient(145deg, #3b2106 0%, #0a2617 100%)',
      icon: 'video_call',
      accentColor: '#ff9900'
    },
    'silk-firetv': {
      title: 'Interactive 10-Foot Fire TV Cursor & D-Pad',
      deviceBadge: '📺 Fire TV 16:9',
      logo: '/images/Amazon_Silk_Logo.webp',
      company: 'Amazon Silk',
      bgGradient: 'linear-gradient(145deg, #061831 0%, #0f172a 100%)',
      icon: 'tv',
      accentColor: '#38bdf8'
    },
    'flex-jvm': {
      title: 'Interactive Amazon Flex JVM & GC Profiler',
      deviceBadge: '📱 Phone 9:16',
      logo: '/images/Amazon_icon.svg.png',
      company: 'Amazon Flex',
      bgGradient: 'linear-gradient(145deg, #2e1f05 0%, #111927 100%)',
      icon: 'memory',
      accentColor: '#ff9900'
    },
    'foodfeed-inrix': {
      title: 'Interactive PNNL FoodFeed & INRIX Car SDK',
      deviceBadge: '📱 Phone 9:16',
      logo: '/images/PNNL_CENTER_FullColorSMALL.jpg',
      company: 'PNNL & INRIX',
      bgGradient: 'linear-gradient(145deg, #06322d 0%, #0f172a 100%)',
      icon: 'directions_car',
      accentColor: '#2dd4bf'
    }
  };

  function renderMediaDestinationsPanel() {
    var container = document.getElementById('cmpMediaDestinationsCard');
    if (!container) return;

    var blogMeta = CMP_APP_BLOG_META[currentAppId] || CMP_APP_BLOG_META['career-explorer'];
    var appPreview = CMP_APP_PREVIEW_META[currentAppId] || CMP_APP_PREVIEW_META['career-explorer'];
    var filteredDemos = CMP_PORTFOLIO_DEMOS.filter(function(d) {
      if (showAllDemosInTray || currentAppId === 'career-explorer' || currentAppId === 'sdui-playground' || currentAppId === 'flex-jvm') {
        return true;
      }
      return d.appId === currentAppId;
    });

    var filterToggleText = (showAllDemosInTray || currentAppId === 'career-explorer' || currentAppId === 'sdui-playground' || currentAppId === 'flex-jvm')
      ? 'Showing All ' + CMP_PORTFOLIO_DEMOS.length + ' Demos'
      : 'Showing ' + filteredDemos.length + ' Device Demo(s) • Show All (' + CMP_PORTFOLIO_DEMOS.length + ')';

    var isLiveSimulatorActive = !activeEmbeddedDemoId;
    var isCurrentTv = currentAppId === 'silk-firetv';
    var liveCutoutHtml = isCurrentTv
      ? '<div class="cmp-thumb-tv-cutout-wrap">' +
          '<div class="cmp-thumb-tv-cutout" style="background:' + appPreview.bgGradient + '; display:flex; flex-direction:column; align-items:center; justify-content:center; gap:4px;">' +
            '<span class="material-symbols-outlined" style="font-size:28px; color:' + appPreview.accentColor + ';">' + appPreview.icon + '</span>' +
            '<span style="font-size:0.58rem; font-weight:800; color:#e2e8f0; letter-spacing:0.04em;">LIVE TV SIMULATOR</span>' +
          '</div>' +
          '<div class="cmp-thumb-tv-stand"></div>' +
        '</div>'
      : '<div class="cmp-thumb-phone-cutout" style="background:' + appPreview.bgGradient + '; display:flex; flex-direction:column; align-items:center; justify-content:center; gap:5px; padding:8px;">' +
          '<span class="material-symbols-outlined" style="font-size:26px; color:' + appPreview.accentColor + ';">' + appPreview.icon + '</span>' +
          '<span style="font-size:0.52rem; font-weight:800; color:#e2e8f0; text-align:center; line-height:1.15;">LIVE PHONE SIMULATOR</span>' +
        '</div>';

    var liveSimulatorTileHtml = (
      '<div class="cmp-demo-tile' + (isCurrentTv ? ' tv-tile' : '') + (isLiveSimulatorActive ? ' playing' : '') + '">' +
        '<div class="cmp-demo-thumb-wrap" onclick="closeDeviceVideo()" title="Switch Back to Live Interactive Device Preview">' +
          liveCutoutHtml +
        '</div>' +
        '<div class="cmp-demo-body">' +
          '<div style="display:flex; align-items:center; justify-content:center; gap:4px; font-size:0.62rem; font-weight:800; color:var(--primary);">' +
            '<img src="' + appPreview.logo + '" alt="" class="cmp-company-badge-sm" style="width:13px; height:13px;"> ' + appPreview.company +
          '</div>' +
          '<div class="cmp-demo-title">' + appPreview.title + '</div>' +
          '<div class="cmp-demo-actions">' +
            '<button type="button" class="cmp-demo-mini-link" onclick="closeDeviceVideo()">' +
              '<span class="material-symbols-outlined" style="font-size:12px;">touch_app</span>' +
              '<span>' + (isLiveSimulatorActive ? 'Active' : 'Open') + '</span>' +
            '</button>' +
            '<a href="' + blogMeta.url + '" class="cmp-demo-mini-link">' +
              '<span class="material-symbols-outlined" style="font-size:12px;">article</span>' +
              '<span>Blog ↗</span>' +
            '</a>' +
          '</div>' +
        '</div>' +
      '</div>'
    );

    var tilesHtml = liveSimulatorTileHtml + filteredDemos.map(function(vid, idx) {
      var isPlaying = activeEmbeddedDemoId === vid.id;
      var isTvVideo = vid.appId === 'silk-firetv';

      var cutoutThumbHtml = isTvVideo
        ? '<div class="cmp-thumb-tv-cutout-wrap">' +
            '<div class="cmp-thumb-tv-cutout">' +
              '<img src="https://img.youtube.com/vi/' + vid.id + '/mqdefault.jpg" alt="' + vid.title + '" loading="lazy">' +
              '<div class="cmp-demo-play-badge">' +
                '<span class="material-symbols-outlined" style="font-size:28px;">' + (isPlaying ? 'pause_circle' : 'play_circle') + '</span>' +
              '</div>' +
            '</div>' +
            '<div class="cmp-thumb-tv-stand"></div>' +
          '</div>'
        : '<div class="cmp-thumb-phone-cutout">' +
            '<img src="https://img.youtube.com/vi/' + vid.id + '/mqdefault.jpg" alt="' + vid.title + '" loading="lazy">' +
            '<div class="cmp-demo-play-badge">' +
              '<span class="material-symbols-outlined" style="font-size:26px;">' + (isPlaying ? 'pause_circle' : 'play_circle') + '</span>' +
            '</div>' +
          '</div>';

      var blogLinkHtml = vid.post_url
        ? '<a href="' + vid.post_url + '" class="cmp-demo-mini-link" title="' + vid.post_title + '">' +
            '<span class="material-symbols-outlined" style="font-size:12px;">article</span>' +
            '<span>Blog ↗</span>' +
          '</a>'
        : '<a href="' + vid.url + '" target="_blank" rel="noopener noreferrer" class="cmp-demo-mini-link">' +
            '<span class="material-symbols-outlined" style="font-size:12px;">workspace_premium</span>' +
            '<span>Award ↗</span>' +
          '</a>';

      return (
        '<div class="cmp-demo-tile' + (isTvVideo ? ' tv-tile' : '') + (isPlaying ? ' playing' : '') + '">' +
          '<div class="cmp-demo-thumb-wrap" onclick="playDemoInDevice(\'' + vid.id + '\')" title="Play Video Inside ' + (isTvVideo ? 'Fire TV' : 'Phone') + '">' +
            cutoutThumbHtml +
          '</div>' +
          '<div class="cmp-demo-body">' +
            '<div style="display:flex; align-items:center; justify-content:center; gap:4px; font-size:0.62rem; font-weight:800; color:var(--primary);">' +
              '<img src="' + vid.logo + '" alt="" class="cmp-company-badge-sm" style="width:13px; height:13px;"> ' + vid.badge + ' • ' + vid.year +
            '</div>' +
            '<div class="cmp-demo-title">' + vid.title + '</div>' +
            '<div class="cmp-demo-actions">' +
              '<button type="button" class="cmp-demo-mini-link" onclick="playDemoInDevice(\'' + vid.id + '\')">' +
                '<span class="material-symbols-outlined" style="font-size:12px;">smart_display</span>' +
                '<span>' + (isPlaying ? 'Playing' : 'Play') + '</span>' +
              '</button>' +
              blogLinkHtml +
            '</div>' +
          '</div>' +
        '</div>'
      );
    }).join('');

    container.innerHTML = (
      '<div class="cmp-section-overline">' +
        '<span style="display:inline-flex; align-items:center; gap:6px;">' +
          '<span class="material-symbols-outlined" style="font-size:16px;">video_library</span>' +
          '<span>Demo Playlist &amp; Blog Article Destinations</span>' +
        '</span>' +
        '<button type="button" onclick="toggleAllDemosTray()" style="background:none; border:none; color:var(--primary); font-size:0.68rem; font-weight:800; cursor:pointer; text-decoration:underline; padding:0;">' +
          filterToggleText +
        '</button>' +
      '</div>' +

        '<div style="display:flex; justify-content:space-between; align-items:center; gap:8px; margin-bottom:0.65rem;">' +
          '<a href="' + blogMeta.url + '" class="cmp-blog-dest-link" style="font-size:0.78rem;">' +
            '<span class="material-symbols-outlined" style="font-size:16px; color:var(--primary);">menu_book</span>' +
            '<span>' + blogMeta.title + '</span>' +
          '</a>' +
          '<div style="display:flex; align-items:center; gap:6px; flex-shrink:0;">' +
            '<a href="' + blogMeta.url + '" class="cmp-blog-read-pill">' +
              '<span>' + blogMeta.cta + '</span>' +
              '<span class="material-symbols-outlined" style="font-size:13px;">arrow_forward</span>' +
            '</a>' +
            (blogMeta.secondaryUrl ? (
              '<a href="' + blogMeta.secondaryUrl + '" class="cmp-blog-read-pill" style="background:var(--surface-container-high); color:var(--on-surface); border:1px solid var(--outline-variant);">' +
                '<span>' + blogMeta.secondaryCta + '</span>' +
                '<span class="material-symbols-outlined" style="font-size:13px;">open_in_new</span>' +
              '</a>'
            ) : '') +
          '</div>' +
        '</div>' +

      /* Horizontal Video Demo Playlist Tray */
      '<div class="cmp-playlist-tray">' +
        tilesHtml +
      '</div>'
    );
  }

  function renderInspectorPanel() {
    var box = document.getElementById('cmpInspectorCard');
    if (!box) return;

    if (currentAppId === 'career-explorer') {
      var pills = CMP_SKILLS.map(function(s) {
        var act = s === selectedSkill
          ? 'background:var(--primary); color:var(--on-primary); border-color:var(--primary); font-weight:800;'
          : 'background:var(--surface-container-low); color:var(--on-surface); border-color:var(--outline);';
        return '<button type="button" onclick="setSkillFilter(\'' + s + '\')" style="padding:0.32rem 0.72rem; border-radius:999px; border:1px solid; font-size:0.74rem; cursor:pointer; white-space:nowrap; transition:all 0.15s ease; ' + act + '">' + s + '</button>';
      }).join('');

      box.innerHTML = (
        '<div class="cmp-section-overline">' +
          '<span>Skill Filter • Updates Phone UI Live</span>' +
          '<span>Active: ' + selectedSkill + '</span>' +
        '</div>' +
        '<div style="display:flex; gap:0.45rem; overflow-x:auto; padding-bottom:4px; scrollbar-width:thin;">' + pills + '</div>'
      );
    } else if (currentAppId === 'sdui-playground') {
      box.innerHTML = (
        '<div class="cmp-section-overline">' +
          '<span style="display:inline-flex; align-items:center; gap:6px;"><img src="/images/DoorDash_Logo.svg.png" alt="" class="cmp-company-badge-sm"> DoorDash Server-Driven UI Schema Nodes</span>' +
          '<span>SDUI v2.4</span>' +
        '</div>' +
        '<div style="display:flex; flex-wrap:wrap; gap:1rem; align-items:center; margin-bottom:0.6rem;">' +
          '<label style="display:flex; align-items:center; gap:0.4rem; font-size:0.8rem; font-weight:600; cursor:pointer;">' +
            '<input type="checkbox" ' + (sduiOrder ? 'checked' : '') + ' onchange="sduiOrder=this.checked; renderPhoneViewport();">' +
            '<span>OrderConfirmationHeader</span>' +
          '</label>' +
          '<label style="display:flex; align-items:center; gap:0.4rem; font-size:0.8rem; font-weight:600; cursor:pointer;">' +
            '<input type="checkbox" ' + (sduiDelivery ? 'checked' : '') + ' onchange="sduiDelivery=this.checked; renderPhoneViewport();">' +
            '<span>DynamicDeliveryOptions</span>' +
          '</label>' +
          '<label style="display:flex; align-items:center; gap:0.4rem; font-size:0.8rem; font-weight:600; cursor:pointer;">' +
            '<input type="checkbox" ' + (sduiHardware ? 'checked' : '') + ' onchange="sduiHardware=this.checked; renderPhoneViewport();">' +
            '<span>HardwarePeripheralBanner</span>' +
          '</label>' +
        '</div>' +
        '<div style="display:flex; align-items:center; gap:0.75rem;">' +
          '<span style="font-size:0.78rem; font-weight:700; white-space:nowrap;">Live ETA (' + sduiEta + 'm):</span>' +
          '<input type="range" min="12" max="60" value="' + sduiEta + '" style="flex:1; accent-color:var(--primary);" oninput="sduiEta=parseInt(this.value,10); renderPhoneViewport(); renderInspectorPanel();">' +
        '</div>'
      );
    } else if (currentAppId === 'webrtc-telemetry') {
      box.innerHTML = (
        '<div class="cmp-section-overline">' +
          '<span style="display:inline-flex; align-items:center; gap:6px;"><img src="/images/amazon-care.webp" alt="" class="cmp-company-badge-sm"> Amazon Care WebRTC Impairment Controller</span>' +
          '<span>Patent US11038933B1</span>' +
        '</div>' +
        '<div style="display:grid; grid-template-columns:repeat(auto-fit, minmax(150px, 1fr)); gap:0.75rem;">' +
          '<div>' +
            '<div style="font-size:0.76rem; font-weight:700;">Packet Loss: ' + webrtcLoss.toFixed(1) + '%</div>' +
            '<input type="range" min="0" max="15" step="0.2" value="' + webrtcLoss + '" style="width:100%; accent-color:var(--primary);" oninput="webrtcLoss=parseFloat(this.value); renderPhoneViewport(); renderInspectorPanel();">' +
          '</div>' +
          '<div>' +
            '<div style="font-size:0.76rem; font-weight:700;">Jitter: ' + webrtcJitter + ' ms</div>' +
            '<input type="range" min="2" max="150" step="1" value="' + webrtcJitter + '" style="width:100%; accent-color:var(--primary);" oninput="webrtcJitter=parseFloat(this.value); renderPhoneViewport(); renderInspectorPanel();">' +
          '</div>' +
          '<div>' +
            '<div style="font-size:0.76rem; font-weight:700;">RTT Latency: ' + webrtcRtt + ' ms</div>' +
            '<input type="range" min="15" max="400" step="5" value="' + webrtcRtt + '" style="width:100%; accent-color:var(--primary);" oninput="webrtcRtt=parseFloat(this.value); renderPhoneViewport(); renderInspectorPanel();">' +
          '</div>' +
        '</div>'
      );
    } else if (currentAppId === 'silk-firetv') {
      box.innerHTML = (
        '<div class="cmp-section-overline">' +
          '<span style="display:inline-flex; align-items:center; gap:6px;"><img src="/images/Amazon_Silk_Logo.webp" alt="" class="cmp-company-badge-sm"> Amazon Silk Virtual Cursor &amp; D-Pad Heuristics (Use Side Remote or Arrow Keys)</span>' +
          '<span>20M+ Fire TV Devices</span>' +
        '</div>' +
        '<div style="display:flex; flex-wrap:wrap; gap:1rem; align-items:center;">' +
          '<div style="flex:1; min-width:180px;">' +
            '<div style="font-size:0.76rem; font-weight:700;">D-Pad Cursor Acceleration: ' + silkAccel.toFixed(1) + 'x</div>' +
            '<input type="range" min="1.0" max="3.0" step="0.2" value="' + silkAccel + '" style="width:100%; accent-color:var(--primary);" oninput="silkAccel=parseFloat(this.value); renderFireTvScreen(); renderInspectorPanel();">' +
          '</div>' +
          '<label style="display:flex; align-items:center; gap:0.4rem; font-size:0.8rem; font-weight:600; cursor:pointer;">' +
            '<input type="checkbox" ' + (silkMagneticSnap ? 'checked' : '') + ' onchange="silkMagneticSnap=this.checked; renderFireTvScreen();">' +
            '<span>Magnetic DOM Target Snapping</span>' +
          '</label>' +
        '</div>'
      );
    } else if (currentAppId === 'flex-jvm') {
      box.innerHTML = (
        '<div class="cmp-section-overline">' +
          '<span style="display:inline-flex; align-items:center; gap:6px;"><img src="/images/Amazon_icon.svg.png" alt="" class="cmp-company-badge-sm"> Amazon Flex JVM Memory &amp; GC Tuning Controls</span>' +
          '<span>Android Runtime (ART)</span>' +
        '</div>' +
        '<div style="display:flex; flex-wrap:wrap; gap:1rem; align-items:center;">' +
          '<div style="flex:1; min-width:180px;">' +
            '<div style="font-size:0.76rem; font-weight:700;">Itinerary Route Stops: ' + flexStops + ' Stops</div>' +
            '<input type="range" min="10" max="90" step="2" value="' + flexStops + '" style="width:100%; accent-color:var(--primary);" oninput="flexStops=parseInt(this.value,10); renderPhoneViewport(); renderInspectorPanel();">' +
          '</div>' +
          '<label style="display:flex; align-items:center; gap:0.4rem; font-size:0.8rem; font-weight:600; cursor:pointer;">' +
            '<input type="checkbox" ' + (flexBitmapPool ? 'checked' : '') + ' onchange="flexBitmapPool=this.checked; renderPhoneViewport();">' +
            '<span>Enable Bitmap Pool &amp; Leak Fix (Eliminates OOM)</span>' +
          '</label>' +
        '</div>'
      );
    } else if (currentAppId === 'foodfeed-inrix') {
      box.innerHTML = (
        '<div class="cmp-section-overline">' +
          '<span style="display:inline-flex; align-items:center; gap:6px;">' +
            '<img src="/images/PNNL_CENTER_FullColorSMALL.jpg" alt="" class="cmp-company-badge-sm">' +
            '<img src="/images/INRIX_logo.png" alt="" class="cmp-company-badge-sm">' +
            'PNNL FoodFeed &amp; INRIX Connected Car Simulator' +
          '</span>' +
          '<span>Early Career</span>' +
        '</div>' +
        '<div style="display:flex; flex-wrap:wrap; gap:1rem; align-items:center;">' +
          '<div style="flex:1; min-width:180px;">' +
            '<div style="font-size:0.76rem; font-weight:700;">INRIX Connected Vehicle Speed: ' + inrixSpeedMph + ' MPH</div>' +
            '<input type="range" min="12" max="75" step="1" value="' + inrixSpeedMph + '" style="width:100%; accent-color:var(--primary);" oninput="inrixSpeedMph=parseInt(this.value,10); renderPhoneViewport(); renderInspectorPanel();">' +
          '</div>' +
          '<label style="display:flex; align-items:center; gap:0.4rem; font-size:0.8rem; font-weight:600; cursor:pointer;">' +
            '<input type="checkbox" ' + (foodFeedAlertActive ? 'checked' : '') + ' onchange="foodFeedAlertActive=this.checked; renderPhoneViewport();">' +
            '<span>FoodFeed Java EE Real-Time FDA Push Sync</span>' +
          '</label>' +
        '</div>'
      );
    }
  }

  function setSkillFilter(skill) {
    if (typeof triggerHaptic === 'function') triggerHaptic(8);
    selectedSkill = skill;
    renderPhoneViewport();
    renderInspectorPanel();
  }

  function togglePhoneDeliverable(title) {
    if (typeof triggerHaptic === 'function') triggerHaptic(8);
    expandedDeliverable = (expandedDeliverable === title) ? '' : title;
    renderPhoneViewport();
  }

  function setSduiWindow(w) {
    if (typeof triggerHaptic === 'function') triggerHaptic(8);
    sduiWindow = w;
    renderPhoneViewport();
  }

  function pulseRemoteLed() {
    var led = document.getElementById('cmpRemoteLed');
    if (!led) return;
    led.style.background = '#3ddc84';
    led.style.transform = 'scale(1.35)';
    setTimeout(function() {
      led.style.background = '#38bdf8';
      led.style.transform = 'scale(1)';
    }, 160);
  }

  function moveSilkCursor(dx, dy) {
    if (typeof triggerHaptic === 'function') triggerHaptic(8);
    pulseRemoteLed();
    silkCursorX = Math.max(10, Math.min(90, Math.round(silkCursorX + dx * (silkAccel / 1.8))));
    silkCursorY = Math.max(18, Math.min(84, Math.round(silkCursorY + dy * (silkAccel / 1.8))));

    if (silkMagneticSnap) {
      var nearest = SILK_TV_TILES[0];
      var bestDist = 999999;
      SILK_TV_TILES.forEach(function(t) {
        var d = Math.pow(t.x - silkCursorX, 2) + Math.pow(t.y - silkCursorY, 2);
        if (d < bestDist) {
          bestDist = d;
          nearest = t;
        }
      });
      silkSnappedTile = nearest.name;
      silkActiveUrl = nearest.url;
    }
    renderFireTvScreen();
  }

  function triggerSilkClick() {
    if (typeof triggerHaptic === 'function') triggerHaptic(12);
    pulseRemoteLed();
    silkClickPulse = true;
    renderFireTvScreen();
    setTimeout(function() {
      silkClickPulse = false;
      renderFireTvScreen();
    }, 180);
  }

  function resetSilkCursorCenter() {
    if (typeof triggerHaptic === 'function') triggerHaptic(10);
    pulseRemoteLed();
    silkCursorX = 50;
    silkCursorY = 38;
    silkSnappedTile = 'IMDb TV Freevee';
    silkActiveUrl = 'https://imdb.com/tv';
    renderFireTvScreen();
  }

  function toggleSilkSnapMode() {
    if (typeof triggerHaptic === 'function') triggerHaptic(8);
    pulseRemoteLed();
    silkMagneticSnap = !silkMagneticSnap;
    renderFireTvScreen();
    renderInspectorPanel();
  }

  function adjustSilkSpeed(delta) {
    if (typeof triggerHaptic === 'function') triggerHaptic(8);
    pulseRemoteLed();
    silkAccel = Math.max(1.0, Math.min(3.0, Math.round((silkAccel + delta) * 10) / 10));
    renderFireTvScreen();
    renderInspectorPanel();
  }

  function snapSilkTile(name, x, y, url) {
    if (typeof triggerHaptic === 'function') triggerHaptic(8);
    pulseRemoteLed();
    silkSnappedTile = name;
    silkCursorX = x;
    silkCursorY = y;
    if (url) silkActiveUrl = url;
    renderFireTvScreen();
  }

  function runManualGc() {
    if (typeof triggerHaptic === 'function') triggerHaptic(12);
    flexGcCount += 1;
    flexBitmapPool = true;
    renderPhoneViewport();
    renderInspectorPanel();
  }

  // Allow keyboard Arrow keys to control the Fire TV D-Pad remote when Silk Fire TV app is active
  document.addEventListener('keydown', function(e) {
    if (currentAppId !== 'silk-firetv') return;
    if (e.key === 'ArrowUp') { e.preventDefault(); moveSilkCursor(0, -14); }
    else if (e.key === 'ArrowDown') { e.preventDefault(); moveSilkCursor(0, 14); }
    else if (e.key === 'ArrowLeft') { e.preventDefault(); moveSilkCursor(-16, 0); }
    else if (e.key === 'ArrowRight') { e.preventDefault(); moveSilkCursor(16, 0); }
    else if (e.key === 'Enter') { e.preventDefault(); triggerSilkClick(); }
  });

  // JetBrains Darcula Kotlin Syntax Highlighter (Single-Pass Tokenizer)
  function highlightKotlinLine(line) {
    var escaped = line
      .replace(/&/g, '&amp;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;');

    if (/^\s*\/\//.test(escaped)) {
      return '<span class="kt-cmt">' + escaped + '</span>';
    }

    var tokens = [];
    function stashToken(cls, text) {
      tokens.push('<span class="' + cls + '">' + text + '</span>');
      return '___KT_TOK_' + (tokens.length - 1) + '___';
    }

    // 1. Stash string literals first
    escaped = escaped.replace(/"([^"\\]|\\.)*"/g, function(m) {
      return stashToken('kt-str', m);
    });

    // 2. Stash annotations (@Composable, @OptIn, etc.)
    escaped = escaped.replace(/@[A-Za-z0-9_]+/g, function(m) {
      return stashToken('kt-ann', m);
    });

    // 3. Stash Kotlin keywords (including 'class' safely before HTML tags are restored)
    escaped = escaped.replace(
      /\b(package|import|fun|val|var|object|data|class|if|else|when|forEach|by|private|return|true|false)\b/g,
      function(m) { return stashToken('kt-kw', m); }
    );

    // 4. Stash Compose & Kotlin types/functions
    escaped = escaped.replace(
      /\b(Column|Row|Card|Surface|Text|FilterChip|Slider|Modifier|Arrangement|PortfolioRepository|PortfolioMiniApp|MiniAppRegistry|CareerExplorerApp|SduiPlaygroundApp|WebRtcSimulatorApp|SilkFireTvApp|FlexJvmProfilerApp|FoodFeedCarApp|OrderConfirmationCard|DynamicDeliverySelector|HardwarePeripheralStatusCard|TelehealthCallViewport|FireTvTenFootViewport|FireTvDpadRemoteControl|JvmHeapGaugeCard|GcLatencyTelemetryCard|FoodFeedBioSurveillanceCard|InrixConnectedCarTelemetryCard|SkillFilterChipRow|CareerStageCard|Boolean|Int|Float|String|Unit|remember|mutableStateOf|listOf|coerceIn)\b/g,
      function(m) { return stashToken('kt-type', m); }
    );

    // 5. Stash numeric / dp / sp / float literals
    escaped = escaped.replace(
      /\b(\d+(\.\d+)?(f|\.dp|\.sp)?)\b/g,
      function(m) { return stashToken('kt-num', m); }
    );

    // Restore all stashed syntax tokens in a single pass
    escaped = escaped.replace(/___KT_TOK_(\d+)___/g, function(_, idx) {
      return tokens[parseInt(idx, 10)];
    });

    return escaped;
  }

  function selectKotlinFile(fileKey) {
    currentKotlinFile = fileKey;
    document.querySelectorAll('.cmp-ide-tab').forEach(function(t) { t.classList.remove('active'); });
    var activeTab = document.getElementById('tab-' + fileKey);
    if (activeTab) activeTab.classList.add('active');

    var fnLabel = document.getElementById('cmpActiveKotlinFilename');
    if (fnLabel) fnLabel.textContent = fileKey + '.kt';

    var lines = KOTLIN_FILES[fileKey] || [];
    var rowsHtml = lines.map(function(line, idx) {
      return (
        '<tr>' +
          '<td class="cmp-line-num">' + (idx + 1) + '</td>' +
          '<td class="cmp-line-code">' + highlightKotlinLine(line) + '</td>' +
        '</tr>'
      );
    }).join('');

    document.getElementById('cmpKotlinCodeViewport').innerHTML = '<table class="cmp-code-table"><tbody>' + rowsHtml + '</tbody></table>';
  }

  function copyActiveKotlinCode() {
    if (typeof triggerHaptic === 'function') triggerHaptic(10);
    var raw = (KOTLIN_FILES[currentKotlinFile] || []).join('\n');
    if (navigator.clipboard) {
      navigator.clipboard.writeText(raw).then(function() {
        var txt = document.getElementById('cmpCopyText');
        txt.textContent = 'Copied!';
        setTimeout(function() { txt.textContent = 'Copy Kotlin'; }, 1600);
      });
    }
  }

  document.addEventListener('DOMContentLoaded', function() {
    switchCmpApp('career-explorer');
  });
</script>
