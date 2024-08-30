package com.ikimaka.whetherapp.presentation.root

import com.arkivanov.decompose.ComponentContext

class DefaultRootComponent(
    componentContext: ComponentContext
): RootComponent, ComponentContext by componentContext