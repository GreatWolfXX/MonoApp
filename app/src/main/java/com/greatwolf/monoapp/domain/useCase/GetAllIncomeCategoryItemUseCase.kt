package com.greatwolf.monoapp.domain.useCase

import com.greatwolf.monoapp.domain.repository.IncomeRepository
import javax.inject.Inject

class GetAllIncomeCategoryItemUseCase @Inject constructor(
    private val repository: IncomeRepository
){
    suspend operator fun invoke() = repository.getAllIncomeCategoryItem()
}