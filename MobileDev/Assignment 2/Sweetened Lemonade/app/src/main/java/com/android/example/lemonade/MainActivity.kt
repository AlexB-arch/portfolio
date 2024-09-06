package com.android.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background,) {
                        ImageButton()
                }
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp(){
    ImageButton(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}
@Composable
fun ImageButton(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf(1) }
    var squeeze = 0

    val imageResource = when (result){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.sugar_cubes
        4 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val textResource = when (result){
        1 -> R.string.tree
        2 -> R.string.squeeze
        3 -> R.string.sugar
        4 -> R.string.drink
        else -> R.string.restart
    }

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Button(
            onClick = {
                result = if (result < 2) result + 1
                else if (result == 2) {
                    squeeze++
                    if (squeeze == 5) result + 1
                    else result
                }
                else if (result < 5) result + 1
                else 1
        },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Color(195, 236, 210))
        )
        {
            Image(painter = painterResource(id = imageResource), contentDescription = result.toString())
        }
        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = stringResource(id = textResource), fontSize = 20.sp)
    }
}