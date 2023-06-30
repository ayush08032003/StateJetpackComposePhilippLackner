package com.example.statejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.statejetpackcompose.ui.theme.StateJetpackComposeTheme
import kotlin.random.Random
/*
// This is pretty simple as it only changes the color of its own state..

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorBox( Modifier.fillMaxSize() )// this is just to assign the whole size to the ColorBox modifier..
        }
    }
}

@Composable
fun ColorBox(modifier:Modifier = Modifier){
    val color = remember {mutableStateOf(Color.Yellow)} // this remember is an lambda function which make the system to remember the last value, instead of just re-assigning the value again..
    Box(
        modifier = modifier.background(color.value)
            .clickable { // Add this modifier to the element to make it clickable within its bounds and show a default indication when it's pressed
                color.value =  Color(red = Random.nextFloat(), green = Random.nextFloat(), blue = Random.nextFloat())
            }
    )
}
*/

// This is where we tries to change the change the color of other box using the same box we used earlier..
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val color = remember { mutableStateOf(Color.Yellow) }

            Column(Modifier.fillMaxSize()) {
                ColorBox(Modifier .weight(1f).fillMaxSize() ){
                    color.value = it // since the ColorBox function receives a lambda function, it will assign the returned value to the color.value 
                }// by using the
                Box(modifier = Modifier.weight(1f) // weight will assign the weight to the element. works same as XML
                    .background(color.value)
                    .fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun ColorBox(
    modifier:Modifier = Modifier, // this is for defying the design, size of the box etc..
    updateColor: (Color) -> Unit // this is as for update the color value, it is basically a function, which can accept a lambda function easily..
) {
    Box(
        modifier = modifier
            .background(Color.Red)
            .clickable { // Add this modifier to the element to make it clickable within its bounds and show a default indication when it's pressed
                updateColor(
                    Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat())
                )
            }
    )
}
/*
NOTES:


YT link: https://www.youtube.com/watch?v=s3m1PSd7VWc&list=PLQkwcJG4YTCSpJ2NLhDTHhi6XBNfk9WiC&index=6&pp=iAQB
 */