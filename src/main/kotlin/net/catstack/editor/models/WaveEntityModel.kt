package net.catstack.editor.models

data class WaveEntityModel(
    val enemy: String,
    val locationMethod: Int,
    val position: PositionModel,
)

data class PositionModel(
    val x: Float,
    val y: Float,
)