package com.mohitb117.portfolio.apps

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Interactive JVM Heap Memory Telemetry & GC Pause Latency Profiler Simulator.
 * Demonstrates the memory profiling and OOM mitigation architecture built at Amazon Flex.
 */
@Composable
fun FlexJvmProfilerApp() {
    var routeStops by remember { mutableStateOf(48f) }
    var bitmapPoolEnabled by remember { mutableStateOf(true) }
    var gcCycleCount by remember { mutableStateOf(4) }

    val rawMb = 92 + (routeStops * 1.8f).toInt()
    val allocatedMb = if (bitmapPoolEnabled) (rawMb * 0.56f).toInt() else rawMb
    val gcPauseMs = if (bitmapPoolEnabled) 3.4f else 28.6f

    Column(
        modifier = Modifier.fillMaxWidth().padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "AMAZON FLEX • JVM HEAP & GC PROFILER",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "Heap Usage: $allocatedMb MB / 256 MB • Avg GC Pause: ${gcPauseMs}ms",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                LinearProgressIndicator(
                    progress = { (allocatedMb / 256f).coerceIn(0f, 1f) },
                    modifier = Modifier.fillMaxWidth()
                )
                Button(onClick = {
                    gcCycleCount += 1
                    bitmapPoolEnabled = true
                }) {
                    Text("Trigger Explicit GC & Compact Heap (Cycles: $gcCycleCount)")
                }
            }
        }

        Card(shape = RoundedCornerShape(16.dp)) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Active Delivery Itinerary Stops: ${routeStops.toInt()}", fontWeight = FontWeight.Bold)
                Slider(
                    value = routeStops,
                    onValueChange = { routeStops = it },
                    valueRange = 10f..90f
                )
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Switch(checked = bitmapPoolEnabled, onCheckedChange = { bitmapPoolEnabled = it })
                    Text("Enable Bitmap Pool & Leak Fix (Eliminates OOM)")
                }
            }
        }
    }
}
