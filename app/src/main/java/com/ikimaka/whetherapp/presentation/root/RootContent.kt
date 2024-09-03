package com.ikimaka.whetherapp.presentation.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.ikimaka.whetherapp.presentation.details.DetailsContent
import com.ikimaka.whetherapp.presentation.favourite.FavouriteContent
import com.ikimaka.whetherapp.presentation.search.SearchContent
import com.ikimaka.whetherapp.presentation.ui.theme.WhetherAppTheme

@Composable
fun RootContent(component: RootComponent) {

    WhetherAppTheme {
        Children(
            stack = component.stack
        ) {
            when(val instance = it.instance) {
                is RootComponent.Child.Details -> {
                    DetailsContent(component = instance.component)
                }
                is RootComponent.Child.Favourite -> {
                    FavouriteContent(component = instance.component)
                }
                is RootComponent.Child.Search -> {
                    SearchContent(component = instance.component)
                }
            }
        }
    }
}