package com.example.woofapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
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
import com.example.woofapp.ui.theme.*

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
fun DogItem(dog: Dog, modifier: Modifier = Modifier) {
 var expanded by remember { mutableStateOf(false) };

 val color by animateColorAsState(
  targetValue = if (expanded) Cyan700 else MaterialTheme.colors.surface
 )

 Card(
  modifier = Modifier.padding(8.dp),
  elevation = 4.dp
 ) {
  Column(
   modifier = Modifier
    .animateContentSize(
     animationSpec = spring(
      dampingRatio = Spring.DampingRatioMediumBouncy,
      stiffness = Spring.StiffnessLow
     )
    )
    .background(color = color)
  ) {
   Row(
    modifier = Modifier
     .fillMaxWidth()
     .padding(8.dp)
   ) {
    DogIcon(dog);
    DogInformation(dog);
    Spacer(modifier = Modifier.weight(1f))
    DogItemButton(
     expanded = expanded,
     onClick = { expanded = !expanded }
    );
   }
   if (expanded) {
    DogHobby(dogHobby = dog.hobbies)
   }
  }
 }
}

@Composable
fun DogItemButton(expanded: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
 IconButton(onClick = onClick) {
  Icon(
   imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
   tint = MaterialTheme.colors.secondary,
   contentDescription = stringResource(id = R.string.expanded_button_content_description)
  )
 }
}

@Composable
fun DogInformation(dog: Dog, modifier: Modifier = Modifier) {
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
fun DogHobby(@StringRes dogHobby: Int, modifier: Modifier = Modifier) {
 Column(
  modifier = modifier.padding(
   start = 16.dp,
   top = 8.dp,
   bottom = 16.dp,
   end = 16.dp
  )
 ) {
  Text(
   text = stringResource(id = R.string.about),
   style = MaterialTheme.typography.h3
  )
  Text(
   text = stringResource(id = dogHobby),
   style = MaterialTheme.typography.body1
  )
 }
}

@Composable
fun DogIcon(dog: Dog, modifier: Modifier = Modifier) {
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

//@Preview(showSystemUi = true)
@Composable
fun DarkThemePreview() {
 WoofAppTheme(darkTheme = true) {
  WoofApp()
 }
}