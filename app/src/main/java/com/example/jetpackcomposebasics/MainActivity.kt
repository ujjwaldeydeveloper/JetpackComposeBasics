package com.example.jetpackcomposebasics

import android.os.Bundle
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeBasicsTheme {
                MyApp()
            }
        }
    }
}

@Composable
private fun MyApp(modifier: Modifier = Modifier, names: List<String> = listOf("World", "Compose")) {
    Column(modifier = modifier.padding(16.dp)) {
        for (name in names) {
            Greeting(
                name = name,
                modifier = modifier
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val isExpanded = remember { mutableStateOf(false) }
    val extraPadding = if (isExpanded.value) 16.dp else 0.dp

    Surface(color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier =  Modifier.weight(1f).padding(bottom = extraPadding)) {
                Text(
                    text = "Hello",
                )
                Text(
                    text = "$name!",
                )
            }
            ElevatedButton(
                onClick = { isExpanded.value = !isExpanded.value },
            ) {
                Text( if(isExpanded.value)"Show less"  else "Show more")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeBasicsTheme {
        Greeting("Android")
    }
}