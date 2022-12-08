package com.effective.effectiveinternship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effective.effectiveinternship.ui.theme.EffectiveInternshipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        R.drawable.marvel_logo
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {TopAppBarSample()}
            ) {
                EffectiveInternshipTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        color = MaterialTheme.colors.background,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Greeting("Android")
                    }
                }
            }
        }
    }
}

@Composable
fun TopAppBarSample(){
    TopAppBar(
        elevation = 4.dp,
        title = {
            Text("I'm a TopAppBar")
        },
        backgroundColor =  MaterialTheme.colors.primarySurface,
    )
}

@Composable
fun Greeting(name: String) {
    Column(Modifier.padding(all = 12.dp)) {
        Text(text = "HHello Hello Hello ello $name!", modifier = Modifier.padding(19.dp))
        Text(text = "HHello Hello Hello ello $name!", modifier = Modifier.padding(19.dp))
        Image(painter = painterResource(id = R.drawable.marvel), contentDescription = "asd")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EffectiveInternshipTheme {
        Greeting("Android")
    }
}
