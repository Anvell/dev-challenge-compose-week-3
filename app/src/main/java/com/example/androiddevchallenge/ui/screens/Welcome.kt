/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.navigation.Destinations
import com.example.androiddevchallenge.ui.components.Button
import com.example.androiddevchallenge.ui.components.PrimaryButton
import com.example.androiddevchallenge.ui.theme.AppTheme
import com.example.androiddevchallenge.ui.theme.Spacers

@Composable
fun Welcome(navController: NavController) {
    Box(Modifier.fillMaxSize()) {
        BackgroundArt()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(
                    vertical = dimensionResource(R.dimen.layout_vertical_padding),
                    horizontal = dimensionResource(R.dimen.layout_horizontal_padding)
                )
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Spacers.L()

            AppTheme.PrimaryButton(
                text = stringResource(R.string.common_signup),
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )
            Spacers.Xs()

            AppTheme.Button(
                text = stringResource(R.string.common_login),
                onClick = { navController.navigate(Destinations.Login) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun BoxScope.BackgroundArt() {
    Image(
        painter = painterResource(R.drawable.ic_welcome_top),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.TopCenter)
    )

    Image(
        painter = painterResource(R.drawable.ic_welcome_bottom),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
    )
}
