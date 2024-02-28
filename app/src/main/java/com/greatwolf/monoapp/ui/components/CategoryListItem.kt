package com.greatwolf.monoapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greatwolf.monoapp.ui.theme.poppins

@Composable
fun CategoryListItem(
    icon: Int,
    title: String,
    selectedColor: Color,
    isIconChangedColor: Boolean,
    isCategoryContainsTitle: Boolean,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val borderColor = if(isSelected) selectedColor else MaterialTheme.colorScheme.tertiary
    val iconColor = if(isSelected && isIconChangedColor) selectedColor else MaterialTheme.colorScheme.primary

    Column(
        modifier = Modifier
            .border(
                BorderStroke(1.dp, borderColor),
                RoundedCornerShape(8.dp)
            )
            .clickable {
                onClick.invoke()
            }
            .padding(vertical = if(isCategoryContainsTitle) 12.dp else 25.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = iconColor
        )
        if(isCategoryContainsTitle) {
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = title,
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Normal,
                fontFamily = poppins,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}