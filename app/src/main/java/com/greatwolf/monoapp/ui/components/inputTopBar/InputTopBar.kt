package com.greatwolf.monoapp.ui.components.inputTopBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.greatwolf.monoapp.ui.screens.NavGraphs
import com.greatwolf.monoapp.ui.screens.appCurrentDestinationAsState
import com.greatwolf.monoapp.ui.screens.destinations.Destination
import com.greatwolf.monoapp.ui.screens.startAppDestination
import com.greatwolf.monoapp.ui.theme.BrandingColor
import com.greatwolf.monoapp.ui.theme.poppins
import com.ramcosta.composedestinations.navigation.navigate

@Composable
fun InputTopBar(
    navController: NavController
) {
    val currentDestination: Destination = navController.appCurrentDestinationAsState().value
        ?: NavGraphs.root.startAppDestination
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        InputTopBarDestination.values().forEach { destination ->
            val isSelected = currentDestination == destination.direction
            InputTopBarItem(
                isSelected = isSelected,
                destination = destination,
                onClick = { navController.navigate(destination.direction) }
            )
        }
    }
}

@Composable
private fun RowScope.InputTopBarItem(isSelected: Boolean, destination: InputTopBarDestination, onClick: () -> Unit) {
    val colorBorder = if(!isSelected) MaterialTheme.colorScheme.tertiary else BrandingColor
    Box(
        modifier = Modifier
            .weight(1f, true)
            .padding(0.dp)
            .clickable { onClick.invoke() }
            .drawBehind {
                val borderSize = 1.dp.toPx();
                drawLine(
                    color = colorBorder,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = borderSize
                )
            }
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = destination.label),
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            fontFamily = poppins,
            color = if(!isSelected) MaterialTheme.colorScheme.tertiary else BrandingColor
        )
    }
}