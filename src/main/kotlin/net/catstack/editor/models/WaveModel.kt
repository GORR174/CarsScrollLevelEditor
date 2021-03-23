package net.catstack.editor.models

data class WaveModel(
    val repeats: Int,
    val spawningDelay: Float,
    val waveElements: List<WaveEntityModel>,
)