package com.greatwolf.monoapp.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense_category_item")
data class ExpenseCategoryItemDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val icon: Int,
    val string: String?
)
