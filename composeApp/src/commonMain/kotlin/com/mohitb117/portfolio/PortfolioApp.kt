package com.mohitb117.portfolio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mohitb117.portfolio.apps.MiniAppRegistry
import com.mohitb117.portfolio.theme.PortfolioTheme

@Composable
fun PortfolioApp(initialAppId: String = "career-explorer") {
    var darkTheme by remember { mutableStateOf(true) }
    var activeAppId by remember { mutableStateOf(initialAppId) }
    val activeApp = remember(activeAppId) {
        MiniAppRegistry.apps.find { it.id == activeAppId } ?: MiniAppRegistry.apps.first()
    }

    PortfolioTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                // Top CMP App Switcher Bar
                Surface(
                    color = MaterialTheme.colorScheme.surface,
                    tonalElevation = 2.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MiniAppRegistry.apps.forEach { app ->
                                val selected = app.id == activeApp.id
                                FilterChip(
                                    selected = selected,
                                    onClick = { activeAppId = app.id },
                                    label = {
                                        Text(
                                            text = app.title,
                                            fontWeight = if (selected) FontWeight.ExtraBold else FontWeight.Medium
                                        )
                                    }
                                )
                            }
                        }

                        TextButton(onClick = { darkTheme = !darkTheme }) {
                            Text(if (darkTheme) "Light Theme" else "Dark Theme")
                        }
                    }
                }

                HorizontalDivider(color = MaterialTheme.colorScheme.outline)

                // Active Mini-App Viewport
                Box(modifier = Modifier.weight(1f).fillMaxWidth()) {
                    activeApp.content()
                }
            }
        }
    }
}
