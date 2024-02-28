package com.greatwolf.monoapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.ui.theme.poppins

@Composable
fun TextInput(
    title: String,
    text: MutableState<TextFieldValue>,
    placeholder: String = "",
    isContainsIcon: Boolean = false) {
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

            BasicTextField(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp))
                    .border(
                        BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary),
                        RoundedCornerShape(8.dp)
                    )
                    .padding(top = 4.dp, start = 16.dp, end = 8.dp),
                value = text.value,
                onValueChange = {
                    text.value = it
                },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    fontFamily = poppins,
                    color =
                    if(text.value.text.isEmpty()) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.primary,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                singleLine = true
            ) { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = placeholder,
                        fontSize = 16.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                        fontFamily = poppins,
                        color =
                        if(text.value.text.isEmpty()) MaterialTheme.colorScheme.secondary else Color.Transparent
                    )
                    if(isContainsIcon) {
                        Icon(
                            painter = painterResource(id = R.drawable.camera_ic),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.tertiary
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 36.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    innerTextField()
                }
            }
        }
    }

}