package com.android.aigittest.ui.elements

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.aigittest.R
import com.android.aigittest.presenter.IpViewModel

@Composable
fun TextScreen() {
    val ipViewModel: IpViewModel = viewModel(factory = IpViewModel.Factory)
    val ip by ipViewModel.ip.collectAsState()
    Box(
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Your IP is ${ip.ip}",
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}