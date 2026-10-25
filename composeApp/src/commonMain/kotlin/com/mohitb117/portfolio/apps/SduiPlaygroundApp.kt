package com.mohitb117.portfolio.apps

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SduiPlaygroundApp() {
    var showOrderConfirmation by remember { mutableStateOf(true) }
    var showDeliveryWindows by remember { mutableStateOf(true) }
    var showHardwareStatus by remember { mutableStateOf(true) }
    var selectedWindow by remember { mutableStateOf("Express (25–35 min)") }
    var etaMinutes by remember { mutableStateOf(28f) }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Left Panel: Server-Driven UI Controls & JSON Payload Preview
        Card(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "BACKEND SDUI SCHEMA CONTROLS",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Toggle server-driven components and payload parameters to re-render the mobile Compose hierarchy with zero app release:",
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = showOrderConfirmation, onCheckedChange = { showOrderConfirmation = it })
                    Text("Node 1: OrderConfirmationHeader (ETA: ${etaMinutes.toInt()}m)", fontWeight = FontWeight.SemiBold)
                }

                Slider(
                    value = etaMinutes,
                    onValueChange = { etaMinutes = it },
                    valueRange = 12f..60f
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = showDeliveryWindows, onCheckedChange = { showDeliveryWindows = it })
                    Text("Node 2: DynamicDeliveryWindowSelector", fontWeight = FontWeight.SemiBold)
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = showHardwareStatus, onCheckedChange = { showHardwareStatus = it })
                    Text("Node 3: HardwarePeripheralStatusBanner", fontWeight = FontWeight.SemiBold)
                }

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = buildSduiJsonPreview(
                            showOrderConfirmation = showOrderConfirmation,
                            etaMinutes = etaMinutes.toInt(),
                            showDeliveryWindows = showDeliveryWindows,
                            selectedWindow = selectedWindow,
                            showHardwareStatus = showHardwareStatus
                        ),
                        modifier = Modifier.padding(12.dp),
                        fontFamily = FontFamily.Monospace,
                        fontSize = 12.sp,
                        lineHeight = 17.sp
                    )
                }
            }
        }

        // Right Panel: Live Rendered Compose Screen
        Card(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            shape = RoundedCornerShape(24.dp),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
        ) {
            Column(
                modifier = Modifier
                    .padding(18.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "LIVE COMPOSE SDUI RENDERER",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary
                )

                if (showOrderConfirmation) {
                    Surface(
                        shape = RoundedCornerShape(14.dp),
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text("Order Confirmed • Preparing Order", fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)
                            Text("Estimated Arrival: ${etaMinutes.toInt()} mins", fontSize = 14.sp)
                        }
                    }
                }

                if (showDeliveryWindows) {
                    Surface(
                        shape = RoundedCornerShape(14.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Text("Dynamic Delivery Options", fontWeight = FontWeight.Bold)
                            listOf("Express (25–35 min)", "Standard (40–55 min)", "Scheduled Window (4:00–5:00 PM)").forEach { option ->
                                FilterChip(
                                    selected = selectedWindow == option,
                                    onClick = { selectedWindow = option },
                                    label = { Text(option) }
                                )
                            }
                        }
                    }
                }

                if (showHardwareStatus) {
                    Surface(
                        shape = RoundedCornerShape(14.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text("Hardware Peripherals Connected", fontWeight = FontWeight.Bold)
                            Text("Bluetooth Barcode Scanner & Receipt Peripheral: Ready (98% Battery)", fontSize = 12.sp)
                        }
                    }
                }
            }
        }
    }
}

private fun buildSduiJsonPreview(
    showOrderConfirmation: Boolean,
    etaMinutes: Int,
    showDeliveryWindows: Boolean,
    selectedWindow: String,
    showHardwareStatus: Boolean
): String = """
{
  "schemaVersion": "2.4",
  "screen": "post_checkout_hub",
  "components": [
    ${if (showOrderConfirmation) """{ "type": "order_confirmation_header", "etaMinutes": $etaMinutes },""" else ""}
    ${if (showDeliveryWindows) """{ "type": "dynamic_delivery_options", "selected": "$selectedWindow" },""" else ""}
    ${if (showHardwareStatus) """{ "type": "hardware_peripheral_banner", "status": "CONNECTED" }""" else ""}
  ]
}
""".trimIndent()
