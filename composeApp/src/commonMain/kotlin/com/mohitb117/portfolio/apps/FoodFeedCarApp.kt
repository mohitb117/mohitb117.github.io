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
 * Interactive PNNL FoodFeed (1st Place DOE Mobile Challenge) & INRIX Connected Car SDK Simulator.
 */
@Composable
fun FoodFeedCarApp() {
    var vehicleSpeedMph by remember { mutableStateOf(62f) }
    var fdaPushSyncEnabled by remember { mutableStateOf(true) }

    val congestionLabel = when {
        vehicleSpeedMph < 35f -> "Heavy Congestion (Red)"
        vehicleSpeedMph < 52f -> "Moderate Flow (Yellow)"
        else -> "Free Flow (Green)"
    }

    Column(
        modifier = Modifier.fillMaxWidth().padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "PNNL • FOODFEED BIO-SURVEILLANCE APP (1ST PLACE DOE)",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "UPC #036000291452 • Health Score: 96/100",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Switch(checked = fdaPushSyncEnabled, onCheckedChange = { fdaPushSyncEnabled = it })
                    Text(if (fdaPushSyncEnabled) "Java EE Real-Time FDA Recall Push Active" else "Offline Cached Mode")
                }
            }
        }

        Card(shape = RoundedCornerShape(16.dp)) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "INRIX • CONNECTED CAR MOBILITY SDK",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "I-90 Floating Bridge • ${vehicleSpeedMph.toInt()} MPH ($congestionLabel)",
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = vehicleSpeedMph,
                    onValueChange = { vehicleSpeedMph = it },
                    valueRange = 12f..75f
                )
            }
        }
    }
}
