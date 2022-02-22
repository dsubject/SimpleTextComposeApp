package com.example.simpletextcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.simpletextcomposeapp.ui.theme.SimpleTextComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingText("World")
            GreetingButton()
        }
    }
}


/*composable functions don't need to be stored in the activity they are being
used in, they can be stored in a separate Composables.kt file --- they are so "decoupled"*/
@Composable
fun GreetingText(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun GreetingButton() {
    Button(onClick = {
        // do something
    }) {
        GreetingText(name = "im a button")
        GreetingText(name = "im a second button")
    }
}

/*in order to see a preview, need to pass a Composable function,
pass the actual layout that was passed into setContent() of the activity,
and also the @Preview annotation*/
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleTextComposeAppTheme {
        GreetingText("World")
        GreetingButton()
    }
}