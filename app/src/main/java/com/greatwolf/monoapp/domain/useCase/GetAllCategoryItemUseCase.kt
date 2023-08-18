package com.greatwolf.monoapp.domain.useCase

import com.greatwolf.monoapp.data.dto.CategoryItemDto
import com.greatwolf.monoapp.domain.repository.Repository
import javax.inject.Inject

class GetAllCategoryItemUseCase @Inject constructor(
    private val repository: Repository
){
    suspend operator fun invoke() = repository.getAllCategoryItem()
}