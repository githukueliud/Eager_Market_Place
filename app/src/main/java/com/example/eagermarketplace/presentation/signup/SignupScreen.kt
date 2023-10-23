package com.example.eagermarketplace.presentation.signup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eagermarketplace.R
import com.example.eagermarketplace.presentation.common.AppLogo
import com.example.eagermarketplace.presentation.common.FormButton
import com.example.eagermarketplace.presentation.common.FormPasswordField
import com.example.eagermarketplace.presentation.common.FormTextField
import com.example.eagermarketplace.presentation.navigation.Destinations
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(
    navController: NavController,
    signupViewModel: SignupViewModel = hiltViewModel()
) {
    val state = signupViewModel.state.collectAsState().value
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        signupViewModel.eventFlow.collectLatest { event ->
            when (event) {
                SignupUiEvents.NavigateToLogin -> {
                    navController.navigate(Destinations.LoginScreen.route) {
                        popUpTo(Destinations.SignupScreen.route){
                            inclusive = true
                        }
                    }
                }
                is SignupUiEvents.ShowSnackBar -> {
                    scope.launch {
                        snackbarHostState.showSnackbar(event.message)
                    }
                }
            }
        }
    }


    Column(
        modifier = Modifier.fillMaxSize()
    ){
        SignupScreenComponent(
            state = state,
            onEvent = signupViewModel::onEvent,
            modifier = Modifier
        )
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreenComponent(
    modifier: Modifier = Modifier,
    state: SignupState,
    onEvent: (SignupEvents) -> Unit
) {

    val focusManager = LocalFocusManager.current



    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(5.dp)),
            painter = painterResource(id = R.drawable.mboka_hands_mboka),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Signup to our platform to enjoy shopping at the\ncomfort of your home",
            fontSize = 18.sp
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        item {
            AnimatedVisibility(visible = state.loading) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    LinearProgressIndicator(color = MaterialTheme.colorScheme.inversePrimary)
                }
            }
        }
        item {
            Column {
                Text(
                    text = "Create an account to get started.",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Enter your details",
                    fontWeight = FontWeight.ExtraLight,
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic
                )
            }
            Column {
                FormTextField(
                    label = "Username",
                    value = state.username,
                    onValueChange = { onEvent(SignupEvents.OnUsernameChanged(it)) },
                    leadingIcon = Icons.Filled.Person,
                    error = state.usernameError != null,
                    modifier = Modifier.fillMaxWidth()
                )
                state.usernameError?.let {
                    AnimatedVisibility(visible = true) {
                        Text(text = it, color = MaterialTheme.colorScheme.error)
                    }
                }
            }
            Column {
                FormTextField(
                    label = "Email",
                    value = state.email,
                    onValueChange = { onEvent(SignupEvents.OnEmailChanged(it)) },
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
                FormPasswordField(
                    label = "Password",
                    value = state.password,
                    onValueChange = { onEvent(SignupEvents.OnPasswordChanged(it)) },
                    leadingIcon = Icons.Filled.Lock,
                    error = state.passwordError != null,
                    showPassword = state.passwordVisibility,
                    toggleVisibility = { onEvent(SignupEvents.OnPasswordVisibilityClicked) },
                    modifier = Modifier.fillMaxWidth()
                )
                state.passwordError?.let {
                    AnimatedVisibility(visible = true) {
                        Text(text = it, color = MaterialTheme.colorScheme.error)
                    }
                }
            }
            Column {
                OutlinedTextField(
                    value = state.confirmPassword,
                    onValueChange = { onEvent(SignupEvents.OnConfirmPasswordChanged(it)) },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Confirm Password") },
                    supportingText = { Text(text = "Confirm your password", fontSize = 12.sp) },
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Lock, contentDescription = null)
                    },
                    trailingIcon = {
                        val icon =
                            if (state.passwordVisibility) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff
                        IconButton(onClick = { onEvent(SignupEvents.OnPasswordVisibilityClicked) }) {
                            Icon(imageVector = icon, contentDescription = null)
                        }
                    },
                    isError = state.confirmPasswordError != null,
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
                state.confirmPasswordError?.let {
                    AnimatedVisibility(visible = true) {
                        Text(text = it, color = MaterialTheme.colorScheme.error)
                    }
                }
            }
            Spacer(modifier = Modifier.height(6.dp))
            FormButton(
                label = "Sign Up",
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                onClick = { onEvent(SignupEvents.OnSignupClicked) }
            )
            Spacer(modifier = Modifier.height(2.dp))
            Row {
                Text(
                    text = "Already have an account?",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onBackground,
                    letterSpacing = 0.07.sp
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = "Login",
                    modifier = Modifier.clickable { onEvent(SignupEvents.OnLoginClicked) },
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.07.sp
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }

}



@Preview(showBackground = true)
@Composable
fun SignupContentPreview() {
    SignupScreenComponent(state = SignupState(), onEvent = {})
}

