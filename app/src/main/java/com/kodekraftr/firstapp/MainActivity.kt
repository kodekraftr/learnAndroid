package com.kodekraftr.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kodekraftr.firstapp.ui.theme.FirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Box(modifier = Modifier.fillMaxSize()) {
//                        BackgroundImage()
//                        GreetingText(
//                            wish = stringResource(R.string.happy_birthday),
//                            name = "Varun",
//                            from = "Me",
//                            modifier = Modifier.fillMaxSize()
//                        )
//                    }
                    DiceRollerApp(modifier = Modifier.fillMaxSize()
                        .wrapContentSize(Alignment.Center))
                }
            }
        }
    }
}

@Composable
fun GreetingText(wish: String, name: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier,
    ) {
        Text(
            "$wish $name",
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 70.sp,
            textAlign = TextAlign.Center
        )
        Text(
            "from $from",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(10.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun BackgroundImage() {
    Image(
        painter = painterResource(R.drawable.androidparty),
        contentDescription = "background image",
        contentScale = ContentScale.Crop,
        alpha = 0.5F
    )
}

@Preview(showSystemUi = true)
@Composable
fun GreetingTextPreview() {
    FirstAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                BackgroundImage()
                GreetingText(
                    wish = stringResource(R.string.happy_birthday),
                    name = "Varun",
                    from = "Me",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}