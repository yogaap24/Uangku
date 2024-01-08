package com.yogaap.uangku.data

import androidx.compose.ui.graphics.Brush

data class Wallet(
    val type: String,
    val number: String? = null,
    val name: String,
    val balance: Double,
    val color: Brush
)
