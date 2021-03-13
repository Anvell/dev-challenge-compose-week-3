package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.AppTheme

@Composable
fun AppTheme.PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding
) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary
        ),
        enabled = enabled,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        elevation = null,
        modifier = modifier.height(dimensionResource(R.dimen.button_height))
    ) {
        Text(
            text = AnnotatedString(text).toUpperCase(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun AppTheme.Button(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding
) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary
        ),
        enabled = enabled,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        elevation = null,
        modifier = modifier.height(dimensionResource(R.dimen.button_height))
    ) {
        Text(
            text = AnnotatedString(text).toUpperCase(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
