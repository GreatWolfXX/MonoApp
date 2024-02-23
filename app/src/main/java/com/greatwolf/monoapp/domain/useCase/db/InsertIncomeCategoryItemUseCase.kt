package com.greatwolf.monoapp.domain.useCase.db

import com.greatwolf.monoapp.data.dto.IncomeCategoryItemDto
import com.greatwolf.monoapp.domain.repository.IncomeRepository
import javax.inject.Inject

class InsertIncomeCategoryItemUseCase @Inject constructor(
    private val repository: IncomeRepository
){
    suspend operator fun invoke(categoryItem: IncomeCategoryItemDto) = repository.insertIncomeCategoryItem(categoryItem)
}