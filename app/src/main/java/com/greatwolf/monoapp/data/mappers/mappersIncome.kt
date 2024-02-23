package com.greatwolf.monoapp.data.mappers

import com.greatwolf.monoapp.data.dto.ExpenseCategoryItemDto
import com.greatwolf.monoapp.data.dto.IncomeCategoryItemDto
import com.greatwolf.monoapp.domain.model.CategoryItem

fun List<IncomeCategoryItemDto>.toDomain() = this.map { it.toDomain() }

fun IncomeCategoryItemDto.toDomain() = CategoryItem(
    icon = icon,
    string = string
)

fun CategoryItem.toIncomeDTO() = IncomeCategoryItemDto(
    icon = icon,
    string = string
)