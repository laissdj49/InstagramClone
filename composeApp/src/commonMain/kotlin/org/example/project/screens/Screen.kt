package org.example.project.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import instagram.composeapp.generated.resources.Res
import instagram.composeapp.generated.resources.add_square
import instagram.composeapp.generated.resources.alvin
import instagram.composeapp.generated.resources.archive
import instagram.composeapp.generated.resources.cats_with_balls
import instagram.composeapp.generated.resources.chat
import instagram.composeapp.generated.resources.heart_
import instagram.composeapp.generated.resources.home_1
import instagram.composeapp.generated.resources.icon
import instagram.composeapp.generated.resources.kiara_lion
import instagram.composeapp.generated.resources.ligeirinho
import instagram.composeapp.generated.resources.luiza
import instagram.composeapp.generated.resources.messenger
import instagram.composeapp.generated.resources.profile_circle
import instagram.composeapp.generated.resources.send_2
import instagram.composeapp.generated.resources.simba_lion
import instagram.composeapp.generated.resources.video_play
import org.jetbrains.compose.resources.painterResource


@Composable
fun FirstScreen() {
  val image = listOf(
    StoryCard(image = painterResource(Res.drawable.alvin), label = "Your story"),
    StoryCard(image = painterResource(Res.drawable.simba_lion), label = "Simba"),
    StoryCard(image = painterResource(Res.drawable.luiza), label = "Luiza"),
    StoryCard(image = painterResource(Res.drawable.kiara_lion), label = "Kiara"),
    StoryCard(image = painterResource(Res.drawable.cats_with_balls), label = "Ronaldo"),
    StoryCard(image = painterResource(Res.drawable.ligeirinho), label = "Ligeirinho"),
  )

  Surface(modifier = Modifier.fillMaxSize()) {
    Scaffold(
      modifier = Modifier.fillMaxSize(),
      topBar = { TopBar() },
      bottomBar = { BottomAppBar() }
    ) { padding ->
      Column(modifier = Modifier.fillMaxSize().padding(padding)) {
        ListStories(image)
        Feed(image)
      }
    }
  }

}


data class StoryCard(val image: Painter, val label: String)

@Composable
fun ListStories(stories: List<StoryCard>) {
  LazyRow(
    modifier = Modifier.fillMaxWidth().padding(12.dp),
    horizontalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    itemsIndexed(stories) { index, story ->
      Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.size(84.dp)) {
          Card(modifier = Modifier.size(84.dp), shape = CircleShape) {
            Image(
              painter = story.image,
              contentDescription = null,
              modifier = Modifier.fillMaxSize().clip(CircleShape)

            )

          }
          if (index == 0) {
            Icon(
              modifier = Modifier.size(26.dp).align(Alignment.BottomEnd).clip(
                CircleShape
              ).clickable { }.background(color = Color.White),
              imageVector = Icons.Default.AddCircle,
              contentDescription = "",
              tint = Color.Black
            )
          }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = story.label)


      }

    }

  }

  Feed(stories)

}


@Composable
fun TopBar() {
  TopAppBar(
    title = {
      Text(text = "For you", textAlign = TextAlign.Left)
    },
    backgroundColor = MaterialTheme.colors.background,
    elevation = 0.dp,
    actions = {
      Icon(
        Icons.Default.ArrowDropDown,
        contentDescription = "Menu",
        modifier = Modifier.padding(end = 220.dp),
        tint = Color.Black
      )

      Image(
        modifier = Modifier.padding(end = 6.dp).size(24.dp),
        painter = painterResource(Res.drawable.heart_),
        contentDescription = "Favorite",
        colorFilter = ColorFilter.tint(color = Color.Black)

      )
      Image(
        modifier = Modifier.padding(end = 4.dp).size(24.dp),
        painter = painterResource(Res.drawable.messenger),
        contentDescription = null,
      )

    }
  )
}

@Composable
fun Feed(image: List<StoryCard>) {

  LazyColumn {

    items(image) { item ->

      Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(16.dp)) {

        Text(text = item.label, modifier = Modifier.align(alignment = Alignment.Start))

        Image(painter = item.image, contentDescription = "")

        Row(
          modifier = Modifier.fillMaxWidth().padding(4.dp),
          horizontalArrangement = Arrangement.spacedBy(4.dp, alignment = Alignment.Start)
        ) {
          Image(painter = painterResource(Res.drawable.heart_), contentDescription = "", colorFilter = ColorFilter.tint(Color.Black))
          Image(painter = painterResource(Res.drawable.chat), contentDescription = "", colorFilter = ColorFilter.tint(Color.Black))
          Image(painter = painterResource(Res.drawable.send_2), contentDescription = "")
          Image(painter = painterResource(Res.drawable.archive), contentDescription = "")
        }
      }
    }

  }
}


@Composable
fun BottomAppBar() {
  BottomAppBar(
    contentColor = Color.White,
    backgroundColor = Color.White,
    modifier = Modifier.padding(16.dp),
    elevation = 0.dp
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth(1f)
        .padding(horizontal = 16.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween,

      ) {
      Image(
        modifier = Modifier.size(24.dp).clickable { },
        painter = painterResource(Res.drawable.home_1),
        contentDescription = "",
        colorFilter = ColorFilter.tint(color = Color.Black)
      )
      Image(
        modifier = Modifier.size(24.dp).clickable { },
        painter = painterResource(Res.drawable.icon),
        contentDescription = "",
      )
      Image(
        modifier = Modifier.size(24.dp).clickable { },
        painter = painterResource(Res.drawable.add_square),
        contentDescription = "",
      )
      Image(
        modifier = Modifier.size(24.dp).clickable { },
        painter = painterResource(Res.drawable.video_play),
        contentDescription = ""
      )

      Image(
        modifier = Modifier.size(24.dp).clickable { },
        painter = painterResource(Res.drawable.profile_circle),
        contentDescription = "",
      )
    }
  }
}
