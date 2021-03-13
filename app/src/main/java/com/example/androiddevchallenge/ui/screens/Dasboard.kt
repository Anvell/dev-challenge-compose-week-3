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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.BodyItems
import com.example.androiddevchallenge.data.CollectionItem
import com.example.androiddevchallenge.data.FavoriteItems
import com.example.androiddevchallenge.data.MindItems
import com.example.androiddevchallenge.ui.components.CardCollectionItem
import com.example.androiddevchallenge.ui.components.CircleCollectionItem
import com.example.androiddevchallenge.ui.components.TextField
import com.example.androiddevchallenge.ui.theme.AppTheme
import com.example.androiddevchallenge.ui.theme.Spacers

@Composable
fun Dashboard() {
    var search by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = dimensionResource(R.dimen.spacing_xxxl))
    ) {
        AppTheme.TextField(
            value = search,
            onValueChange = { search = it },
            label = { Text(stringResource(R.string.dashboard_text_field_search_label)) },
            leading = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.layout_horizontal_padding))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            CardsSection(
                text = stringResource(R.string.favorites_title),
                items = FavoriteItems
            )

            CirclesSection(
                text = stringResource(R.string.body_title),
                items = BodyItems
            )

            CirclesSection(
                text = stringResource(R.string.mind_title),
                items = MindItems
            )

            Spacers.Xxxl()
        }
    }
}

@Composable
private fun SectionHeader(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = AnnotatedString(text).toUpperCase(),
        style = MaterialTheme.typography.h2,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier.padding(
            horizontal = dimensionResource(R.dimen.layout_horizontal_padding)
        )
    )
}

@Composable
private fun CardsSection(
    text: String,
    items: List<CollectionItem>
) {
    SectionHeader(
        text = text,
        modifier = Modifier.paddingFromBaseline(top = dimensionResource(R.dimen.spacing_xl))
    )
    Spacers.Xs()

    LazyRow(
        Modifier.padding(start = dimensionResource(R.dimen.layout_horizontal_padding))
    ) {
        for (i in 0..items.lastIndex step 2) {
            item {
                Column {
                    CardCollectionItem(FavoriteItems[i])
                    Spacers.Xs()

                    if (i != FavoriteItems.lastIndex) {
                        CardCollectionItem(FavoriteItems[i + 1])
                    }
                }
                Spacers.Xs()
            }
        }
    }
}

@Composable
private fun CirclesSection(
    text: String,
    items: List<CollectionItem>
) {
    SectionHeader(
        text = text,
        modifier = Modifier.paddingFromBaseline(top = dimensionResource(R.dimen.spacing_xxl))
    )
    Spacers.Xs()

    LazyRow(
        Modifier.padding(start = dimensionResource(R.dimen.layout_horizontal_padding))
    ) {
        items(items) {
            CircleCollectionItem(it)
            Spacers.Xs()
        }
    }
}
