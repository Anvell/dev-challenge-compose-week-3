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
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.CollectionItem
import com.example.androiddevchallenge.ui.theme.Spacers
import dev.chrisbanes.accompanist.coil.CoilImage

private val CircleSize = 88.dp
private val CardWidth = 192.dp
private val CardHeight = 56.dp

@Composable
fun CardCollectionItem(
    item: CollectionItem
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.semantics(mergeDescendants = true) {}
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.size(CardWidth, CardHeight)
        ) {
            CoilImage(
                data = item.imageUrl,
                fadeIn = true,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.size(CardHeight)
            )
            Spacers.S()

            Text(
                text = stringResource(item.labelId),
                style = MaterialTheme.typography.h3,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Composable
fun CircleCollectionItem(
    item: CollectionItem
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.semantics(mergeDescendants = true) {}
    ) {
        CoilImage(
            data = item.imageUrl,
            fadeIn = true,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .size(CircleSize)
                .clip(CircleShape)
        )

        Text(
            text = stringResource(item.labelId),
            style = MaterialTheme.typography.h3,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.paddingFromBaseline(top = dimensionResource(R.dimen.spacing_m))
        )
    }
}
