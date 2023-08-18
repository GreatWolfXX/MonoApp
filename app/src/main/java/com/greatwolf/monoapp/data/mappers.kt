package com.greatwolf.monoapp.data

import com.greatwolf.monoapp.data.dto.CategoryItemDto
import com.greatwolf.monoapp.domain.model.CategoryItem

fun List<CategoryItemDto>.toDomain() = this.map { it.toDomain() }

fun CategoryItemDto.toDomain() = CategoryItem(
    icon = icon,
    string = string
)