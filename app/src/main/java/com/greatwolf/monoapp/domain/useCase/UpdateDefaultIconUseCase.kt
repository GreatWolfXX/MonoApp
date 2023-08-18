package com.greatwolf.monoapp.domain.useCase

import com.greatwolf.monoapp.data.dto.CategoryItemDto
import com.greatwolf.monoapp.domain.repository.Repository
import javax.inject.Inject

class UpdateDefaultIconUseCase @Inject constructor(
    private val repository: Repository
){
    suspend operator fun invoke(categoryItem: CategoryItemDto) = repository.updateCategoryItem(categoryItem)
}