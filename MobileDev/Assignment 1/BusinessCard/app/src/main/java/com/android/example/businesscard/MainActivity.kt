package com.android.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray
                ) {
                    BusinessCard(
                        name = "Alexander Burgos",
                        title = "Programming Noob",
                    )
                    ContactInfo(
                        phone = "(325) 123-4567",
                        email = "axb19c@acu.edu"
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, title: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null,
                modifier = modifier.size(128.dp)
            )
            Text(
                name,
                fontSize = 40.sp,
                modifier = modifier,
            )
            Text(
                title,
                fontSize = 25.sp,
                modifier = modifier,
            )
        }
    }
}

@Composable
fun ContactInfo(phone: String, email: String) {
    val phone_icon = painterResource(id = R.drawable.baseline_phone_24)
    val email_icon = painterResource(id = R.drawable.baseline_email_24)
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = phone_icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(
                phone,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = email_icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(
                email,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard(name = "Android", title = "Developer")
    }
}