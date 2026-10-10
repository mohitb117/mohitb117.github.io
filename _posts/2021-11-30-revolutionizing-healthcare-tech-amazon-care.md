---
layout: post
title: "Revolutionizing Healthcare Tech: Building Amazon Care from the Ground Up (2018–2021)"
date: 2021-11-30 09:00:00 -0800
categories: [Career, Engineering, Android]
tags: [Amazon Care, Android, Kotlin, Healthcare, WebRTC, Chime SDK, Engineering Leadership]
image: images/amazon-care-blog.png
---

In 2018, after briefly working on improving the memory footprint for the Amazon Flex (Rabbit) app, I transitioned to the Amazon Care (PH7-Tangelo) team. I was incredibly passionate about the healthcare space and wanted to help Amazon cross the finish line on an initiative that could solve real-world problems and genuinely improve people's quality of life.

My time at Amazon Care was defined by moving from a specialized Android developer to a cross-platform technical leader. Here is a deep dive into the major features, architectural decisions, and scaling challenges I tackled while building the foundation of Amazon's healthcare platform.

### 1. Engineering the Telehealth Video Stack: From WebRTC to Chime

Telehealth relies entirely on stable, reliable communication. **In 2018 and 2019, I led the implementation of a rock-solid end-to-end video calling solution for medical providers.** This required building the core architecture to securely send and receive calls, while also implementing complex support for Picture-in-Picture (PiP) mode so patients could navigate the app without dropping their session.

<div class="post-video-card">
  <div class="post-video-wrapper">
    <iframe src="https://www.youtube-nocookie.com/embed/COyElffSaxs?rel=0" title="End to End Persistent Callback Flow for Amazon Care" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
  </div>
  <div class="post-video-meta">
    <div class="post-video-meta-top">
      <span class="post-video-badge">End-to-End Flow Demo</span>
      <a href="https://youtu.be/COyElffSaxs" target="_blank" rel="noopener noreferrer" class="post-video-link">
        <span class="material-symbols-outlined">open_in_new</span>
        <span>Watch on YouTube</span>
      </a>
    </div>
    <h4 class="post-video-title">End-to-End Persistent Callback Flow for Amazon Care</h4>
    <p class="post-video-description">Demonstration of the patient-initiated consultation, persistent queuing/callback dispatch, and automated provider rendezvous architecture engineered for Amazon Care.</p>
  </div>
</div>

**Initially, our video architecture was built entirely on Vanilla WebRTC and utilized Alexa CMDS servers.** As the platform scaled, however, we needed a more robust infrastructure. In 2020, I assisted the team in migrating our existing video stack over to the new Chime SDK. Rather than just copying and pasting code, I directly mentored a peer developer to ensure my previous use cases and custom features were properly supported on the new Chime infrastructure.

To ensure pristine call quality across varying mobile cellular connections, I developed real-time telemetry algorithms to monitor audio/video packet loss and jitter, dynamically adjusting bitrates to maintain call stability—work that resulted in granted **US Patent [US11038933B1](https://patents.google.com/patent/US11038933B1/)**. Additionally, to give our video tiles modern rounded corners without hardware layer clipping artifacts common to standard `SurfaceView` implementations, I migrated our video renderers to `TextureView`.

<div class="post-shorts-grid">
  <div class="post-short-card">
    <div class="post-short-wrapper">
      <iframe src="https://www.youtube-nocookie.com/embed/bGq9uFefcPY?rel=0" title="WebRTC Real Time Metrics Visualization + Quality Adjustment" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
    </div>
    <div class="post-video-meta">
      <div class="post-video-meta-top">
        <span class="post-video-badge">US Patent US11038933B1</span>
        <a href="https://youtube.com/shorts/bGq9uFefcPY" target="_blank" rel="noopener noreferrer" class="post-video-link">
          <span class="material-symbols-outlined">open_in_new</span>
          <span>Watch Short</span>
        </a>
      </div>
      <h4 class="post-video-title">WebRTC Real-Time Telemetry &amp; Quality Adaptation</h4>
      <p class="post-video-description">Live metrics visualization showing packet loss, jitter telemetry, and automated bandwidth adaptation in Amazon Care.</p>
    </div>
  </div>

  <div class="post-short-card">
    <div class="post-short-wrapper">
      <iframe src="https://www.youtube-nocookie.com/embed/DqM70l8SU68?rel=0" title="TextureViews vs SurfaceViews: Rounded Corners for Video Calling UI" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
    </div>
    <div class="post-video-meta">
      <div class="post-video-meta-top">
        <span class="post-video-badge">UI Rendering Optimization</span>
        <a href="https://youtube.com/shorts/DqM70l8SU68" target="_blank" rel="noopener noreferrer" class="post-video-link">
          <span class="material-symbols-outlined">open_in_new</span>
          <span>Watch Short</span>
        </a>
      </div>
      <h4 class="post-video-title">TextureViews vs. SurfaceViews: Rounded Corners</h4>
      <p class="post-video-description">Solving hardware layer clipping limitations by leveraging TextureViews to deliver elegant rounded corners and seamless alpha blending for patient video tiles.</p>
    </div>
  </div>
</div>

Leveraging `TextureView` also unlocked fluid Picture-in-Picture (PiP) animations, allowing patients to minimize their video stream and interact with in-app medical chats or prescription reviews without dropped frames or visual stuttering:

<div class="post-video-card">
  <div class="post-video-wrapper">
    <iframe src="https://www.youtube-nocookie.com/embed/eYIFfLZvmyg?rel=0" title="Smooth Animations &amp; PiP Transitions with TextureViews" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
  </div>
  <div class="post-video-meta">
    <div class="post-video-meta-top">
      <span class="post-video-badge">PiP Animation Demo</span>
      <a href="https://youtu.be/eYIFfLZvmyg" target="_blank" rel="noopener noreferrer" class="post-video-link">
        <span class="material-symbols-outlined">open_in_new</span>
        <span>Watch on YouTube</span>
      </a>
    </div>
    <h4 class="post-video-title">Smooth Video Animations &amp; Picture-in-Picture (PiP) Transitions</h4>
    <p class="post-video-description">Demonstrating fluid view transitions and Picture-in-Picture resizing during live calls without frame drops or hardware surface re-allocation.</p>
  </div>
</div>

My deep dive into video calling also allowed me to act as a subject matter expert beyond my immediate team. **I organized a knowledge transfer with the Jadzia team to share my learnings on video calling.** I proactively reached out to them to highlight architectural issues they would face in the future and provided technical alternatives to ensure their success.

### 2. Modernizing the Tech Stack and Scalable Modularization

When building a new, large-scale application, setting the right foundational patterns is critical. I championed team-wide architectural decisions to move the entire Amazon Care app to pure Kotlin and Coroutines, setting a modern standard for Android development within our org.

As the project grew, I anticipated the need for multiple development teams to work simultaneously. **I introduced fine-grain feature modularization to the application.** This architectural shift provided clean code separation and isolation, allowing new teams to be spun up quickly and contribute to the app without stepping on each other's toes.

### 3. Pioneering Biometrics & Seamless Payments

In healthcare applications, security and seamless user experiences are paramount. **I am incredibly proud to have engineered Amazon's very first app with biometric unlock capability.**

Additionally, we needed a way to process payments without jarring the user out of the native app experience. I developed a seamless integration with Amazon Pay on Android using a WebView loaded directly into memory without ever attaching it to the view hierarchy. This approach created a beautiful, native-feeling user experience where customers could process payments without ever realizing they were interacting with a web page.

### 4. Cross-Platform Leadership & Driving Metrics

In my final years at Amazon Care, my focus expanded to maximizing my force-multiplying impact on the broader organization. Refusing to be siloed solely in Android, I dedicated time in 2020 to learn iOS and Backend development. **This allowed me to stretch my impact and significantly lead the team in the number of code reviews completed across Android, Web, and Backend services.**

I also took a leadership role in the App Metrics project to track customer engagement. This was a massive undertaking that had me touching iOS, backend, frontend, and Android pieces to build a resilient, cross-platform solution. While it was an ambiguous and challenging project that required heavy alignment with existing teams like ACE, it taught me valuable lessons on building consensus and program managing complex cross-org dependencies.

### Conclusion

Building Amazon Care was a profoundly rewarding experience. From pioneering biometric security to building life-saving telehealth video infrastructure on WebRTC and Chime, I thrived on optimizing for speed and efficiency. It pushed me to continually insist on the highest standards, dive deep into unfamiliar technical territory, and balance my obsession for engineering purity with delivering fast, impactful healthcare solutions for our customers.

---

What questions do you have about building healthcare technology at scale? Let's connect on [LinkedIn](https://www.linkedin.com/in/mohitb117).