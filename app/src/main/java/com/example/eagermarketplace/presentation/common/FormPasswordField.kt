package com.example.eagermarketplace.presentation.common

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormPasswordField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon: ImageVector,
    error: Boolean,
    showPassword: Boolean,
    toggleVisibility: () -> Unit
) {
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = modifier,
        label = { Text(text = label) },
        supportingText = { Text(text = "Enter your $label", fontSize = 12.sp) },
        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = null)},
        trailingIcon = {
            val icon = if (showPassword) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff
            IconButton(onClick = toggleVisibility) {
                Icon(imageVector = icon, contentDescription = null)
            }
        },
        isError = error,
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Next) }
        ),
        singleLine = true,
        shape = MaterialTheme.shapes.medium

    )
}

@Preview(showBackground = true)
@Composable
fun FormPasswordFieldPreview() {
    FormPasswordField(
        label = "Password",
        value = "",
        onValueChange = {},
        leadingIcon = Icons.Outlined.Lock,
        error = false,
        showPassword = false
    ) {

    }
}