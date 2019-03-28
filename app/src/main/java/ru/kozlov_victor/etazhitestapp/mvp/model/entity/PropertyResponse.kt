package ru.kozlov_victor.etazhitestapp.mvp.model.entity

data class PropertyResponse(
	val data: List<Property?>? = null,
	val success: Boolean? = null,
	val status: Int? = null
)
