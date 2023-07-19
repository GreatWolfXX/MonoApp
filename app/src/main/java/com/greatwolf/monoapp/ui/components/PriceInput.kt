package com.greatwolf.monoapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greatwolf.monoapp.domain.util.CurrencyInputVisualTransformation
import com.greatwolf.monoapp.ui.theme.Background
import com.greatwolf.monoapp.ui.theme.poppins

@Composable
fun PriceInput(title: String) {
    Column {
        Text(
            text = title,
            fontSize = 14.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            fontFamily = poppins,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.size(8.dp))
        Row() {
            var text by remember { mutableStateOf(TextFieldValue("")) }

            CurrencyBlock("\$")
            BasicTextField(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp))
                    .border(
                        BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary),
                        RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                    )
                    .padding(top = 4.dp, start = 8.dp),
                value = text,
                onValueChange = {
                    text = it
                },
                textStyle = TextStyle(
                    fontSize = 32.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    fontFamily = poppins,
                    color =
                    if(text.text.isEmpty()) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.primary,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                keyboardOptions =
                KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                visualTransformation = CurrencyInputVisualTransformation()
            )
        }
    }

}

@Composable
private fun CurrencyBlock(currency: String) {
    Box(
        modifier = Modifier
            .height(56.dp)
            .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp))
            .background(MaterialTheme.colorScheme.background)
            .border(
                BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary),
                RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
            )
            .padding(vertical = 4.dp, horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = currency,
            fontSize = 32.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            fontFamily = poppins,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )
    }
}