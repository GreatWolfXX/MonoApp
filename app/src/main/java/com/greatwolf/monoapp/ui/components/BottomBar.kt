package com.greatwolf.monoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
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
import com.greatwolf.monoapp.ui.theme.poppins
import com.ramcosta.composedestinations.navigation.navigate

@Composable
fun BottomBar(
    navController: NavController
) {
    val currentDestination: Destination = navController.appCurrentDestinationAsState().value
        ?: NavGraphs.root.startAppDestination
    val colorBorder = MaterialTheme.colorScheme.tertiary
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                val borderSize = 4.dp.toPx();
                drawLine(
                    color = colorBorder,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = borderSize
                )
            }
            .background(MaterialTheme.colorScheme.surface)
    ) {
        BottomBarDestination.values().forEach { destination ->
            val isSelected = currentDestination == destination.direction
            NavBarItem(
                isSelected = isSelected,
                destination = destination,
                onClick = { navController.navigate(destination.direction) }
            )
        }
    }
}

@Composable
fun RowScope.NavBarItem(isSelected: Boolean, destination: BottomBarDestination, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .weight(1f, true)
            .padding(0.dp)
            .clickable { onClick.invoke() }
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(
                id = if(!isSelected) destination.icon else destination.iconSelected
            ),
            contentDescription = stringResource(id = destination.label),
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            text = stringResource(id = destination.label),
            fontSize = 10.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            fontFamily = poppins,
            color = MaterialTheme.colorScheme.primary
        )
    }
}