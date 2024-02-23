package com.greatwolf.monoapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.ui.theme.poppins
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun TitleScreen(
    titleScreen: String,
    isAdditionalButtonActive: MutableState<Boolean>,
    additionalButtonText: String = "",
    additionalButtonIcon: Int? = null,
    additionalButtonOnClick: () -> Unit,
    navigator: DestinationsNavigator
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .padding(bottom = 24.dp)
    ) {
        Text(
            text = stringResource(id = R.string.title_back),
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            fontFamily = poppins,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                navigator.popBackStack()
            }
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
                color =
                if(!isAdditionalButtonActive.value)
                    MaterialTheme.colorScheme.secondary
                else
                    Color.Blue,
                modifier = Modifier.clickable(
                    enabled = isAdditionalButtonActive.value
                ) {
                    additionalButtonOnClick.invoke()
                }
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