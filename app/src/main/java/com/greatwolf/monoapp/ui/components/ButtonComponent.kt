package com.greatwolf.monoapp.ui.components

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greatwolf.monoapp.ui.theme.BrandingColor
import com.greatwolf.monoapp.ui.theme.poppins

@Composable
fun ButtonComponent(onClickActions: () -> Unit, isEnabled: Boolean, title: String) {
    TextButton(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = onClickActions,
        enabled = isEnabled,
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if(!isEnabled) MaterialTheme.colorScheme.tertiary else BrandingColor
        )
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 6.dp),
            text = title,
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            fontFamily = poppins,
            color = if(!isEnabled) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.surface,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )
    }
}