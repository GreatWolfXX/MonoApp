package com.greatwolf.monoapp.domain.useCase

import com.greatwolf.monoapp.data.dto.IncomeCategoryItemDto
import com.greatwolf.monoapp.domain.repository.IncomeRepository
import javax.inject.Inject

class DeleteIncomeCategoryItemUseCase @Inject constructor(
    private val repository: IncomeRepository
){
    suspend operator fun invoke(categoryItem: IncomeCategoryItemDto) = repository.deleteIncomeCategoryItem(categoryItem)
}