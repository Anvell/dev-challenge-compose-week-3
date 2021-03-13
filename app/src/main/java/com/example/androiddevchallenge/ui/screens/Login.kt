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
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.navigation.Destinations
import com.example.androiddevchallenge.ui.components.PrimaryButton
import com.example.androiddevchallenge.ui.components.TextField
import com.example.androiddevchallenge.ui.theme.AppTheme
import com.example.androiddevchallenge.ui.theme.Spacers

private val LoginTopPadding = 200.dp

@Composable
fun Login(navController: NavController) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Box(Modifier.fillMaxSize()) {
        BackgroundArt()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .paddingFromBaseline(LoginTopPadding)
                .padding(
                    start = dimensionResource(R.dimen.layout_horizontal_padding),
                    end = dimensionResource(R.dimen.layout_horizontal_padding),
                    bottom = dimensionResource(R.dimen.layout_vertical_padding)
                )
        ) {
            Text(
                text = AnnotatedString(stringResource(R.string.common_login)).toUpperCase(),
                style = MaterialTheme.typography.h1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacers.L()

            AppTheme.TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(stringResource(R.string.login_text_field_email_label)) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacers.Xs()

            AppTheme.TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(stringResource(R.string.login_text_field_password_label)) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacers.Xs()

            AppTheme.PrimaryButton(
                text = stringResource(R.string.common_login),
                onClick = { navController.navigate(Destinations.Home) },
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = buildAnnotatedString {
                    append(stringResource(R.string.login_label_account_signup))
                    append(" ")

                    pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
                    append(stringResource(R.string.common_signup))
                },
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.paddingFromBaseline(dimensionResource(R.dimen.spacing_l))
            )
        }
    }
}

@Composable
private fun BoxScope.BackgroundArt() {
    Image(
        painter = painterResource(R.drawable.ic_login_top),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.TopCenter)
    )

    Image(
        painter = painterResource(R.drawable.ic_login_bottom),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
    )
}
