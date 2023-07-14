package com.greatwolf.monoapp.ui.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.ui.theme.poppins

@Composable
fun CategoryList(categoryItemList : ArrayList<CategoryItem>) {

    Column {
        Text(
            modifier = Modifier
                .padding(bottom = 8.dp),
            text = stringResource(id = R.string.title_category),
            fontSize = 14.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            fontFamily = poppins,
            color = MaterialTheme.colorScheme.secondary
        )
        categoryItemList.add(CategoryItem(R.drawable.baby_ic, "Test_1"))
        categoryItemList.add(CategoryItem(R.drawable.books_ic, "Test_2"))
        categoryItemList.add(CategoryItem(R.drawable.boat_ic, "Test_3"))
        categoryItemList.add(CategoryItem(R.drawable.bird_ic, "Test_4"))
        categoryItemList.add(CategoryItem(null, null))
        Log.d("Test Wolf", "${categoryItemList.size}")
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 90.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            itemsIndexed(categoryItemList) { index, categoryItem ->
                if(categoryItem.icon == null) {
                    CategoryEdit()
                } else {
                    CategoryItemComponent(categoryItem.icon, categoryItem.string.toString())
                }
            }
        }
    }
}

@Composable
fun CategoryEdit() {
    Column(
        modifier = Modifier
            .border(
                BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary),
                RoundedCornerShape(8.dp)
            )
            .padding(vertical = 32.dp)  ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.title_edit),
            fontSize = 12.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            fontFamily = poppins,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}