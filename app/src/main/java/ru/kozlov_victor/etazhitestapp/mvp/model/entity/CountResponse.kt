package ru.kozlov_victor.etazhitestapp.mvp.model.entity

data class CountResponse(
	val count: Count? = null,
	val success: Boolean? = null,
	val status: Int? = null
)
