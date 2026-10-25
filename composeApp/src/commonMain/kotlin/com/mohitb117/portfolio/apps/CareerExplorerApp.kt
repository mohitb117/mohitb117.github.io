package com.mohitb117.portfolio.apps

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohitb117.portfolio.model.CareerStage
import com.mohitb117.portfolio.model.DeliverableItem
import com.mohitb117.portfolio.model.PortfolioRepository

@Composable
fun CareerExplorerApp() {
    var selectedSkill by remember { mutableStateOf("All Skills") }
    var expandedDeliverable by remember { mutableStateOf<String?>("Order Confirmation UI") }

    val filteredStages = remember(selectedSkill) {
        if (selectedSkill == "All Skills") {
            PortfolioRepository.careerStages
        } else {
            PortfolioRepository.careerStages.mapNotNull { stage ->
                val matching = stage.deliverables.filter { selectedSkill in it.skills }
                if (matching.isNotEmpty()) stage.copy(deliverables = matching) else null
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Skill Filter Bar
        Text(
            text = "FILTER TIMELINE BY TECHNICAL SKILL",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PortfolioRepository.allSkills.forEach { skill ->
                val isSelected = skill == selectedSkill
                FilterChip(
                    selected = isSelected,
                    onClick = { selectedSkill = skill },
                    label = { Text(skill, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium) }
                )
            }
        }

        // Stages List
        filteredStages.forEach { stage ->
            CareerStageCard(
                stage = stage,
                expandedDeliverable = expandedDeliverable,
                onToggleDeliverable = { title ->
                    expandedDeliverable = if (expandedDeliverable == title) null else title
                },
                onSelectSkill = { skill -> selectedSkill = skill }
            )
        }
    }
}

@Composable
private fun CareerStageCard(
    stage: CareerStage,
    expandedDeliverable: String?,
    onToggleDeliverable: (String) -> Unit,
    onSelectSkill: (String) -> Unit
) {
    val brandColor = Color(stage.brandHex)

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Column(modifier = Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "${stage.stepNumber}. ${stage.stageTitle}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = brandColor
                    )
                    Text(
                        text = stage.organization,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = stage.roleTitle,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Surface(
                    shape = RoundedCornerShape(999.dp),
                    color = brandColor.copy(alpha = 0.14f),
                    border = BorderStroke(1.dp, brandColor.copy(alpha = 0.4f))
                ) {
                    Text(
                        text = stage.period,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = brandColor
                    )
                }
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f))

            stage.deliverables.forEach { item ->
                DeliverableRow(
                    item = item,
                    brandColor = brandColor,
                    isExpanded = expandedDeliverable == item.title,
                    onToggle = { onToggleDeliverable(item.title) },
                    onSelectSkill = onSelectSkill
                )
            }
        }
    }
}

@Composable
private fun DeliverableRow(
    item: DeliverableItem,
    brandColor: Color,
    isExpanded: Boolean,
    onToggle: () -> Unit,
    onSelectSkill: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onToggle() },
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f),
        border = BorderStroke(1.dp, if (isExpanded) brandColor else MaterialTheme.colorScheme.outline.copy(alpha = 0.4f))
    ) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = item.title, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    Text(
                        text = item.subtitle,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                item.badge?.let { badge ->
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = brandColor.copy(alpha = 0.18f)
                    ) {
                        Text(
                            text = badge,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = brandColor
                        )
                    }
                }
            }

            AnimatedVisibility(visible = isExpanded) {
                Column(
                    modifier = Modifier.padding(top = 6.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = item.architectureNotes,
                        fontSize = 13.sp,
                        lineHeight = 19.sp
                    )
                    Row(
                        modifier = Modifier.horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        item.skills.forEach { skill ->
                            AssistChip(
                                onClick = { onSelectSkill(skill) },
                                label = { Text(skill, fontSize = 11.sp) }
                            )
                        }
                    }
                }
            }
        }
    }
}
