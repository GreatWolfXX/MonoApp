package com.greatwolf.monoapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.ui.theme.poppins

@Composable
fun TitleScreen(
    titleScreen: String,
    additionalButtonText: String = "",
    additionalButtonIcon: Int? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .padding(bottom = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.title_back),
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            fontFamily = poppins,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = titleScreen,
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            fontFamily = poppins,
            color = MaterialTheme.colorScheme.primary
        )
        if(additionalButtonText.isNotEmpty()) {
            Text(
                text = additionalButtonText,
                fontSize = 16.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Normal,
                fontFamily = poppins,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        if(additionalButtonIcon != null) {
            Icon(
                painter = painterResource(id = additionalButtonIcon),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary
            )
        }
    }
}