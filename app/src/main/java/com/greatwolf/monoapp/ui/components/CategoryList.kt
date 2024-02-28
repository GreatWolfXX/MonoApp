package com.greatwolf.monoapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.ui.theme.poppins

@Composable
fun CategoryList(
    selectedItem: MutableState<CategoryItem?>,
    selectedColor: Color = Blue,
    itemList : ArrayList<CategoryItem>,
    isCategoryContainsTitle: Boolean = true,
    isContainsLastButton: Boolean = true,
    isIconChangedColor: Boolean = false,
    titleLastButton: String = "",
    onClickLastButton: () -> Unit = {},
) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    Column {
        Text(
            modifier = Modifier
                .padding(bottom = 8.dp),
            text = stringResource(id = R.string.title_icon),
            fontSize = 14.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            fontFamily = poppins,
            color = MaterialTheme.colorScheme.secondary
        )
        if(itemList.isEmpty()) {
            itemList.add(CategoryItem(0, ""))
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 90.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            itemsIndexed(itemList) {index, categoryItem ->
                isSelected = selectedItem.value == categoryItem
                if(index.inc() == itemList.size && isContainsLastButton) {
                    TextListItem(titleLastButton, onClickLastButton)
                } else {
                    CategoryListItem(
                        categoryItem.icon,
                        categoryItem.string,
                        selectedColor = selectedColor,
                        isIconChangedColor = isIconChangedColor,
                        isCategoryContainsTitle = isCategoryContainsTitle,
                        isSelected = isSelected
                    ) {
                        selectedItem.value = categoryItem
                    }
                }
            }
        }
    }
}