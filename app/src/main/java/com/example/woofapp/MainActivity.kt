package com.example.woofapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.woofapp.data.Dog
import com.example.woofapp.data.dogs
import com.example.woofapp.ui.theme.WoofAppTheme

class MainActivity : ComponentActivity() {
 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContent {
   WoofAppTheme {
    // A surface container using the 'background' color from the theme
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
     WoofApp();
    }
   }
  }
 }
}

@Composable
fun WoofApp() {
 Scaffold(
  topBar = {
   WoofTopAppBar();
  }
 ) {
  DogItems();
 }
}

@Composable
fun DogItems() {
 LazyColumn(
  modifier = Modifier.background(MaterialTheme.colors.background)
 ) {
  items(dogs) { dog: Dog ->
   DogItem(dog);
  }
 }
}

@Composable
fun DogItem(dog: Dog) {
 Card(
  modifier = Modifier.padding(8.dp),
  elevation = 4.dp
 ) {
  Row(
   modifier = Modifier
    .fillMaxWidth()
    .padding(8.dp)
  ) {
   Column {
    DogIcon(dog);
   }
   DogInformation(dog);
  }
 }
}

@Composable
fun DogInformation(dog: Dog) {
 Column(
  modifier = Modifier.padding(start = 5.dp)
 ) {
  Text(
   text = stringResource(id = dog.name),
   modifier = Modifier.padding(top = 3.dp),
   style = MaterialTheme.typography.h2
  )
  Text(
   text = stringResource(id = R.string.years_old, dog.age),
   style = MaterialTheme.typography.body1
  )
 }
}

@Composable
fun DogIcon(dog: Dog) {
 Image(
  painter = painterResource(id = dog.imageResourceId),
  contentDescription = stringResource(id = dog.name),
  modifier = Modifier
   .size(64.dp)
   .padding(8.dp)
   .clip(RoundedCornerShape(50)),
  contentScale = ContentScale.Crop
 )
}

@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier) {
 Row(
  modifier = Modifier
   .fillMaxWidth()
   .background(color = MaterialTheme.colors.primary),
  verticalAlignment = Alignment.CenterVertically
 ) {
  Image(
   painter = painterResource(id = R.drawable.ic_woof_logo),
   contentDescription = null,
   modifier = Modifier
    .size(64.dp)
    .padding(8.dp)
  )
  Text(
   text = stringResource(id = R.string.app_name),
   style = MaterialTheme.typography.h1
  )
 }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
 WoofAppTheme {
  WoofApp();
 }
}

@Preview(showSystemUi = true)
@Composable
fun DarkThemePreview() {
 WoofAppTheme(darkTheme = true) {
  WoofApp()
 }
}