package com.mohitb117.portfolio.apps

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun WebRtcSimulatorApp() {
    var packetLossPct by remember { mutableStateOf(1.2f) }
    var jitterMs by remember { mutableStateOf(18f) }
    var rttMs by remember { mutableStateOf(65f) }

    val mosScore = remember(packetLossPct, jitterMs, rttMs) {
        val raw = 4.5f - (packetLossPct * 0.22f) - (jitterMs * 0.012f) - (rttMs * 0.003f)
        raw.coerceIn(1.0f, 4.5f)
    }

    val adaptationProfile = when {
        mosScore >= 3.8f -> "1080p @ 60fps • VP9 / Opus Full-Band (Optimal)"
        mosScore >= 2.9f -> "720p @ 30fps • H.264 / FEC Enabled (Adaptive Step-Down)"
        else -> "360p @ 15fps + Audio Priority Mode (High Packet Loss Recovery)"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
        ) {
            Column(modifier = Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    text = "WEBRTC QUALITY ENGINE • US PATENT US11038933B1",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Simulate real-time network degradation during a telehealth A/V consultation to observe the adaptive bitrate and resolution controller:",
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text("Packet Loss: ${(packetLossPct * 10).roundToInt() / 10.0}%", fontWeight = FontWeight.Bold)
                Slider(value = packetLossPct, onValueChange = { packetLossPct = it }, valueRange = 0f..15f)

                Text("Network Jitter: ${jitterMs.roundToInt()} ms", fontWeight = FontWeight.Bold)
                Slider(value = jitterMs, onValueChange = { jitterMs = it }, valueRange = 2f..150f)

                Text("Round-Trip Time (RTT): ${rttMs.roundToInt()} ms", fontWeight = FontWeight.Bold)
                Slider(value = rttMs, onValueChange = { rttMs = it }, valueRange = 15f..400f)

                HorizontalDivider()

                Text(
                    text = "Computed MOS Telemetry Score: ${(mosScore * 100).roundToInt() / 100.0} / 4.50",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "Active Media Profile: $adaptationProfile",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
