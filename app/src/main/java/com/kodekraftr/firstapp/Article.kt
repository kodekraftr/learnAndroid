package com.kodekraftr.firstapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kodekraftr.firstapp.ui.theme.FirstAppTheme

@Composable
fun ArticleUI(
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter : Painter,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = imagePainter ,
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )

        Text(
            title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            shortDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Text(
            longDescription,
            modifier = Modifier.padding(16.dp)
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun ArticleUIPreview() {
    FirstAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
            ) {
            ArticleUI(
                title = stringResource(R.string.compose_title),
                shortDescription = stringResource(R.string.compose_short_desc),
                longDescription = stringResource(R.string.compose_long_desc),
                imagePainter = painterResource(R.drawable.bg_compose_background)
            )
        }
    }
}
