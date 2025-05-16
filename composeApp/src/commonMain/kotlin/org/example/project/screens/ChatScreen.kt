package org.example.project.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import instagram.composeapp.generated.resources.Res
import instagram.composeapp.generated.resources.arrow
import instagram.composeapp.generated.resources.arrowup_
import instagram.composeapp.generated.resources.edit
import instagram.composeapp.generated.resources.points
import org.jetbrains.compose.resources.painterResource

@Composable
fun ChatScreen() {
    TopBarChat()
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
