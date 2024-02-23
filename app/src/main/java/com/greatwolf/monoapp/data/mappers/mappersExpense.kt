package com.greatwolf.monoapp.data.mappers

import com.greatwolf.monoapp.data.dto.ExpenseCategoryItemDto
import com.greatwolf.monoapp.domain.model.CategoryItem

fun List<ExpenseCategoryItemDto>.toDomain() = this.map { it.toDomain() }

fun ExpenseCategoryItemDto.toDomain() = CategoryItem(
    icon = icon,
    string = string
)

fun CategoryItem.toExpenseDTO() = ExpenseCategoryItemDto(
    icon = icon,
    string = string
)