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
 * Interactive 10-Foot Fire TV Web Browser & Heuristic D-Pad Virtual Cursor Simulator.
 * Demonstrates the architecture behind Amazon Silk on 20M+ Fire TV devices.
 */
@Composable
fun SilkFireTvApp() {
    var cursorX by remember { mutableStateOf(52) }
    var cursorY by remember { mutableStateOf(44) }
    var cursorAccel by remember { mutableStateOf(1.8f) }
    var magneticSnap by remember { mutableStateOf(true) }
    var snappedTile by remember { mutableStateOf("Prime Video 4K") }

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
                    text = "AMAZON SILK • 10-FOOT TV VIEWPORT (20M+ DEVICES)",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "Cursor Position: ($cursorX%, $cursorY%) • Snapped Node: $snappedTile",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedButton(onClick = {
                        cursorX = (cursorX - (14 * cursorAccel).toInt()).coerceIn(10, 90)
                        if (magneticSnap) snappedTile = "Prime Video 4K"
                    }) { Text("◀ Left") }
                    OutlinedButton(onClick = {
                        cursorY = (cursorY - (12 * cursorAccel).toInt()).coerceIn(15, 85)
                    }) { Text("▲ Up") }
                    OutlinedButton(onClick = {
                        cursorY = (cursorY + (12 * cursorAccel).toInt()).coerceIn(15, 85)
                    }) { Text("▼ Down") }
                    OutlinedButton(onClick = {
                        cursorX = (cursorX + (14 * cursorAccel).toInt()).coerceIn(10, 90)
                        if (magneticSnap) snappedTile = "IMDB TV Hub"
                    }) { Text("▶ Right") }
                }
            }
        }

        Card(shape = RoundedCornerShape(16.dp)) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("D-Pad Acceleration: ${((cursorAccel * 10).toInt() / 10f)}x", fontWeight = FontWeight.Bold)
                Slider(
                    value = cursorAccel,
                    onValueChange = { cursorAccel = it },
                    valueRange = 1.0f..3.0f
                )
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Switch(checked = magneticSnap, onCheckedChange = { magneticSnap = it })
                    Text("Magnetic DOM Target Snapping")
                }
            }
        }
    }
}
