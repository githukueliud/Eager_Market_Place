package com.example.eagermarketplace.presentation.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.eagermarketplace.R
import com.example.eagermarketplace.presentation.components.FormButton
import com.example.eagermarketplace.presentation.components.FormTextField


@Composable
fun LoginScreen(

) {

}





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenComponents(
    state: LoginState,
    onEvent: (LoginEvents) -> Unit,
    modifier: Modifier = Modifier
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.atm)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    val focusManager = LocalFocusManager.current

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        item {
            AnimatedVisibility(visible = state.loading) {
                LinearProgressIndicator(color = MaterialTheme.colorScheme.inversePrimary)
            }
        }
        item {
            LottieAnimation(
                composition = composition,
                progress = { progress },
                modifier = Modifier.size(300.dp)
            )
        }
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Column {
                    Text(
                        text = "Hello there! Welcome",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Login to your account",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraLight,
                        fontStyle = FontStyle.Italic
                    )
                }
                Column {
                    FormTextField(
                        label = "Email",
                        value = state.email,
                        onValueChange = {onEvent(LoginEvents.OnEmailChanged(it))},
                        leadingIcon = Icons.Filled.Email,
                        error = state.emailError != null,
                        modifier = Modifier.fillMaxWidth()
                    )
                    state.emailError?.let {
                        AnimatedVisibility(visible = true) {
                            Text(text = it, color = MaterialTheme.colorScheme.error)
                        }
                    }
                }
                Column {
                    OutlinedTextField(
                        value = state.password,
                        onValueChange = {onEvent(LoginEvents.OnPasswordChanged(it))},
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(text = "Enter Password")},
                        supportingText = { Text(text = "Enter Password", fontSize = 12.sp)},
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Lock,
                                contentDescription = null
                            )
                        },
                        trailingIcon = {
                            val icon =
                                if (state.passwordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff
                            IconButton(onClick = {onEvent(LoginEvents.OnPasswordVisibilityClicked) }) {
                                Icon(imageVector = icon, contentDescription = null)
                            }
                        },
                        isError = state.passwordError != null,
                        visualTransformation = if (state.passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { focusManager.clearFocus(true) }
                        ),
                        singleLine = true,
                        shape = MaterialTheme.shapes.medium
                    )
                    state.passwordError?.let {
                        AnimatedVisibility(visible = true) {
                            Text(text = it, color = MaterialTheme.colorScheme.error)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(6.dp))
                FormButton(
                    label = "Login",
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    onClick = {onEvent(LoginEvents.OnLoginClicked)}
                )
                Spacer(modifier = Modifier.height(2.dp))
                Row(
                    modifier = Modifier.padding(bottom = 12.dp)
                ) {
                    Text(
                        text = "Don't have an account?",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        letterSpacing = 0.07.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Sign Up",
                        modifier = Modifier.clickable { onEvent(LoginEvents.OnSignupClicked) },
                        color = MaterialTheme.colorScheme.inversePrimary,
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.07.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginComponentsPreview() {
    Surface(
       Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LoginScreenComponents(state = LoginState(), onEvent = {})
    }
}