package com.example.eagermarketplace.presentation.user_profile

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eagermarketplace.presentation.common.FormTextField
import com.example.eagermarketplace.presentation.user_profile.components.AddImageComponent


@Composable
fun UserProfileScreen(
    modifier: Modifier = Modifier,
    onEditImageClicked: () -> Unit,
    state: UserProfileState
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
            onValueChange = ,
            leadingIcon = ,
            error =
        )
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun UserProfileScreenPreview() {
    UserProfileScreen(onEditImageClicked = {})
}

