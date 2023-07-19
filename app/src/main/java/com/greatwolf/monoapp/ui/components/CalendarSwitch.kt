package com.greatwolf.monoapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.ui.theme.Background
import com.greatwolf.monoapp.ui.theme.poppins

@Composable
fun CalendarSwitch(btnLeft: () -> Unit, btnRight: () -> Unit, dateText: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(MaterialTheme.colorScheme.background),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CalendarButton(btnLeft, painterResource(id = R.drawable.arrow_ic),)
        Text(
            text = dateText,
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            fontFamily = poppins,
            color = MaterialTheme.colorScheme.primary
        )
        CalendarButton(btnRight, painterResource(id = R.drawable.arrow_ic), true)
    }
}

@Composable
private fun CalendarButton(onClick: () -> Unit, icon: Painter, isMirror: Boolean = false) {
    IconButton(
        modifier = Modifier
            .padding(8.dp)
            .size(40.dp)
            .border(
                BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
                RoundedCornerShape(100)
            )
            ,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.Transparent
        ),
        onClick = onClick
    ) {
        val scaleX = if(isMirror) -1f else 1f
        Icon(
            modifier = Modifier
                .scale(scaleX, 1f),
            painter = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}