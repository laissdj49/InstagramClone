package org.example.project.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import instagram.composeapp.generated.resources.Res
import instagram.composeapp.generated.resources.alvin
import instagram.composeapp.generated.resources.arrow
import instagram.composeapp.generated.resources.arrowup_
import instagram.composeapp.generated.resources.camera_
import instagram.composeapp.generated.resources.cats_with_balls
import instagram.composeapp.generated.resources.edit
import instagram.composeapp.generated.resources.kiara_lion
import instagram.composeapp.generated.resources.ligeirinho
import instagram.composeapp.generated.resources.luiza
import instagram.composeapp.generated.resources.points
import instagram.composeapp.generated.resources.simba_lion
import org.jetbrains.compose.resources.painterResource

@Composable
fun ChatScreen() {

    // todo por no viewmodel
    val image = listOf(
        StoryCard(
            image = painterResource(Res.drawable.alvin),
            label = "Your story",
            description = "Good morning :)"
        ),
        StoryCard(
            image = painterResource(Res.drawable.simba_lion),
            label = "Simba",
            description = "Sun"
        ),
        StoryCard(
            image = painterResource(Res.drawable.luiza),
            label = "Luiza",
            description = "Minha irmã Laís é a melhor"
        ),
        StoryCard(
            image = painterResource(Res.drawable.kiara_lion),
            label = "Kiara",
            description = "Miau"
        ),
        StoryCard(
            image = painterResource(Res.drawable.cats_with_balls),
            label = "Ronaldo",
            description = "Aqui é brasilllll"
        ),
        StoryCard(
            image = painterResource(Res.drawable.ligeirinho),
            label = "Ligeirinho",
            description = "Boraa"
        ),
    )


    Scaffold(modifier = Modifier.fillMaxWidth(), topBar = { TopBarChat() }) {

        Messages(image)
    }
}

@Composable
fun TopBarChat() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp,
    ) {


        Image(
            painter = painterResource(Res.drawable.arrowup_),
            contentDescription = "",
            modifier = Modifier.clickable { }
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(text = "Lais", color = Color.Black)

        Spacer(modifier = Modifier.width(8.dp))

        Image(
            painter = painterResource(Res.drawable.arrow),
            contentDescription = "",
            modifier = Modifier.clickable { }
        )

        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(Res.drawable.points),
            contentDescription = "point",
            modifier = Modifier.size(24.dp).clickable { })
        Image(
            painter = painterResource(Res.drawable.edit),
            contentDescription = "edit",
            modifier = Modifier.clickable { })
    }
}

@Composable
fun Messages(message: List<StoryCard>) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),

            horizontalArrangement = Arrangement.Center
        ) {
            val modifier = Modifier.height(32.dp).width(110.dp)

            Button(
                onClick = {},
                modifier = modifier,
                shape = RoundedCornerShape(40),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
            ) {
                Text("Primary", maxLines = 1, color = Color.White.copy(1f))
            }
            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {},
                modifier = modifier,
                shape = RoundedCornerShape(40),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
            ) {
                Text("General", maxLines = 1, color = Color.White.copy(1f))
            }
            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {},
                modifier = modifier,
                shape = RoundedCornerShape(40),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
            ) {
                Text("Requests", maxLines = 1, color = Color.White.copy(1f))
            }
        }
        LazyColumn(modifier = Modifier.padding(top = 8.dp)) {
            items(message) { messages ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    Image(
                        painter = messages.image,
                        contentDescription = "",
                        modifier = Modifier.size(40.dp).clip(
                            CircleShape
                        )
                    )
                    Text(text = messages.label, modifier = Modifier.padding(start = 8.dp))
                    Spacer(modifier = Modifier.weight(1f))
                    Image(painter = painterResource(Res.drawable.camera_), contentDescription = "")

                }
            }
        }
    }
}
