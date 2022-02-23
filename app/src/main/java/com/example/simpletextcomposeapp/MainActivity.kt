package com.example.simpletextcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.simpletextcomposeapp.ui.theme.SimpleTextComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingText("World")

        }
    }
}


/*composable functions don't need to be stored in the activity they are being
used in, they can be stored in a separate Composables.kt file --- they are so "decoupled"*/
@Composable
fun GreetingText(name: String) {
    Text(text = "Hello $name!",
        // modifier is used to change the view
        // & can chain other attributes
        modifier = Modifier
            // the order of the modifiers matters
            .clickable(onClick = { })
            .padding(24.dp)
            .height(240.dp)
            .width(200.dp),
        // MaterialTheme and FontWeight are examples of helper classes that have static values we can use
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.SemiBold



    )
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

    }
}