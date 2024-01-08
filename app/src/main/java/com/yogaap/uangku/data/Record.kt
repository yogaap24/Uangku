package com.yogaap.uangku.data

import androidx.compose.ui.graphics.vector.ImageVector

data class Record(
    val icon: ImageVector,
    val type: String,
    val name: String,
    val amount: Double,
    val date: String,
    val time: String,
    val timeZone: String,
    val category: String,
    val wallet: String,
    val note: String? = null,
)
