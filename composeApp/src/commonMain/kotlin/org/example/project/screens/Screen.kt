package org.example.project.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import instagram.composeapp.generated.resources.Res
import instagram.composeapp.generated.resources.alvin
import instagram.composeapp.generated.resources.cats_with_balls
import instagram.composeapp.generated.resources.kiara_lion
import instagram.composeapp.generated.resources.ligeirinho
import instagram.composeapp.generated.resources.luiza
import instagram.composeapp.generated.resources.simba_lion
import org.jetbrains.compose.resources.painterResource


@Composable
fun FirstScreen() {
    val image = listOf(
        StoryCard(image = painterResource(Res.drawable.alvin), label = "Alvin"),
        StoryCard(image = painterResource(Res.drawable.simba_lion), label = "Simba"),
        StoryCard(image = painterResource(Res.drawable.luiza), label = "Luiza"),
        StoryCard(image = painterResource(Res.drawable.kiara_lion), label = "Kiara"),
        StoryCard(image = painterResource(Res.drawable.cats_with_balls), label = "Ronaldo"),
        StoryCard(image = painterResource(Res.drawable.ligeirinho), label = "Ligeirinho"),
    )


    Column(modifier = Modifier.statusBarsPadding()) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                TopBar()
                ListStories(image)
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
        items(stories) { story ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Card(modifier = Modifier.size(80.dp), shape = CircleShape) {
                    Image(
                        painter = story.image,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize().clip(CircleShape)

                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(text = story.label)


            }

        }

    }
}


@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(text = "For you", textAlign = TextAlign.Left)
        },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp,
//        navigationIcon = {
//            Icon(Icons.Default.ArrowDropDown, contentDescription = "Menu")
//        },
        actions = {
            Icon(
                Icons.Default.ArrowDropDown,
                contentDescription = "Menu",
                modifier = Modifier.padding(end = 200.dp),
                tint = Color.Black
            )

            Icon(
                Icons.Outlined.Favorite, contentDescription = "Favorite",
                tint = Color.Transparent.copy(alpha = Float.POSITIVE_INFINITY)

            )
            Icon(
                Icons.Outlined.Email,
                contentDescription = null,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                tint = Color.Transparent.copy(alpha = Float.POSITIVE_INFINITY)
            )

        })
}
