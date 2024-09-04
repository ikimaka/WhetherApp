package com.ikimaka.whetherapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.ikimaka.whetherapp.WeatherApp
import com.ikimaka.whetherapp.data.network.api.ApiFactory
import com.ikimaka.whetherapp.domain.usecase.ChangeFavouriteStateUseCase
import com.ikimaka.whetherapp.domain.usecase.SearchCityUseCase
import com.ikimaka.whetherapp.presentation.root.DefaultRootComponent
import com.ikimaka.whetherapp.presentation.root.RootContent
import com.ikimaka.whetherapp.presentation.ui.theme.WhetherAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var rootComponentFactory: DefaultRootComponent.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as WeatherApp).applicationComponent.inject(this)

        super.onCreate(savedInstanceState)

        val root = rootComponentFactory.create(defaultComponentContext())

        setContent {
            RootContent(component = root)
        }
    }
}
