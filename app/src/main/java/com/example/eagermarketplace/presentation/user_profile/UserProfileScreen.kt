package com.example.eagermarketplace.presentation.user_profile

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eagermarketplace.presentation.common.AppButton
import com.example.eagermarketplace.presentation.common.FormPasswordField
import com.example.eagermarketplace.presentation.common.FormTextField
import com.example.eagermarketplace.presentation.user_profile.components.AddImageComponent


@Composable
fun UserProfileScreen(
    modifier: Modifier = Modifier,
    onEditImageClicked: () -> Unit,
    state: UserProfileState,
    onSaveProfileClicked: () -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AddImageComponent(onclick = { onEditImageClicked() })
        Spacer(modifier = Modifier.height(5.dp))
        FormTextField(
            label = "Edit Username",
            value = state.username,
            onValueChange = {},
            leadingIcon = Icons.Filled.Person,
            error = state.usernameError != null
        )
        FormTextField(
            label = "Enter First Name",
            value = state.firstName,
            onValueChange = {},
            leadingIcon = Icons.Filled.Person,
            error = state.firstNameError != null
        )
        FormTextField(
            label = "Enter Last Name",
            value = state.lastName,
            onValueChange = {},
            leadingIcon = Icons.Filled.Person,
            error = state.lastNameError != null
        )
        FormTextField(
            label = "Change Email",
            value = state.changeEmail,
            onValueChange = {},
            leadingIcon = Icons.Filled.Email,
            error = state.emailError != null
        )
        FormPasswordField(
            label = "Change Password",
            value = state.changePassword,
            onValueChange = {},
            leadingIcon = Icons.Outlined.Lock,
            error = state.passwordError != null,
            showPassword = state.passwordVisibility,
            toggleVisibility = {},
        )
        AppButton(
            text = "Save Profile",
            onclick = {onSaveProfileClicked()}
        )
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun UserProfileScreenPreview() {
    //UserProfileScreen(onEditImageClicked = {})
}

