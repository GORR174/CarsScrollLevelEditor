package net.catstack.editor.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TitleBox(modifier: Modifier = Modifier.fillMaxWidth(), content: @Composable ColumnScope.() -> Unit) {
    Column(modifier = modifier.requiredHeight(48.dp)) {
        Column(modifier.weight(1f), verticalArrangement = Arrangement.Center) {
            content()
        }

        Divider(Modifier.fillMaxWidth())
    }
}

@Composable
fun Title(text: String, modifier: Modifier = Modifier.fillMaxWidth()) {
    TitleBox(modifier = modifier) {
        Text(
            text,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.h6,
        )
    }
}