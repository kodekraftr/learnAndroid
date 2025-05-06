package com.kodekraftr.firstapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kodekraftr.firstapp.ui.theme.FirstAppTheme

fun imageResource(result:Int): Int {
    val image = when(result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    return image
}

@Composable
fun DiceRollerApp(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf(1) }
    var result2 by remember { mutableIntStateOf(2) }


    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text("Dice Game",
            fontSize = 48.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace
        )

        Row {
            Image(
                painter = painterResource(imageResource(result)),
                contentDescription = "Dice$result"
            )

            Image(
                painter = painterResource(imageResource(result2)),
                contentDescription = "Dice$result2"
            )

        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            result = (1..6).random()
            result2 = (1..6).random()
        }) {
            Text("Roll")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text("Your Score : ${result+result2}",
            fontSize = 20.sp
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun DiceRollerAppPreview(modifier: Modifier = Modifier) {
    FirstAppTheme {
        DiceRollerApp(modifier = Modifier.fillMaxSize()
            .wrapContentSize(Alignment.Center))
    }
}