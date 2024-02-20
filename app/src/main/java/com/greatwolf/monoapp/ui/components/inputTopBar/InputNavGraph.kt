package com.greatwolf.monoapp.ui.components.inputTopBar

import com.greatwolf.monoapp.ui.components.bottomBar.BottomBarNavGraph
import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@BottomBarNavGraph
@NavGraph
annotation class InputNavGraph(
    val start: Boolean = false
)