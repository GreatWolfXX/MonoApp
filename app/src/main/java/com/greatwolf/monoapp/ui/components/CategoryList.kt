package com.greatwolf.monoapp.ui.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.ui.theme.poppins

@Composable
fun CategoryList(categoryTitle: String,
                 categoryItemList : ArrayList<CategoryItem>,
                 isCategoryContainsIcon: Boolean = true,
                 isCategoryContainsTitle: Boolean = true,
                 onClick: () -> Unit,
                 title: String = ""
) {
    var selectedItem by remember { mutableStateOf<CategoryItem?>(null) }
    var isSelected by remember {
        mutableStateOf(false)
    }
    Column {
        Text(
            modifier = Modifier
                .padding(bottom = 8.dp),
            text = categoryTitle,
            fontSize = 14.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            fontFamily = poppins,
            color = MaterialTheme.colorScheme.secondary
        )
        categoryItemList.add(CategoryItem(0, null))
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 90.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            itemsIndexed(categoryItemList) { index, categoryItem ->
                if(index == categoryItemList.size.dec()) {
                    if(title.isNotEmpty()) {
                        CategoryEdit(title, onClick)
                    }
                } else {
//                    isSelected = selectedItem == categoryItem
//                    Modifier.clickable {
//                        Log.d("LLOGG", "test")
//                        selectedItem = categoryItem
//                    }
                    CategoryItemComponent(
                        categoryItem.icon,
                        categoryItem.string,
                        isCategoryContainsIcon,
                        isCategoryContainsTitle,
                        isSelected
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryEdit(
    title: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .border(
                BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary),
                RoundedCornerShape(8.dp)
            )
            .padding(vertical = 32.dp)
            .clickable {
                onClick.invoke()
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 12.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            fontFamily = poppins,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}