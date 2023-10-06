package com.dag.ejercicio05

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(
    name = "P1",
    showSystemUi = true,
    showBackground = true,
    fontScale = 1.1f,
    apiLevel = 33,
    device = Devices.NEXUS_5
)

@Composable
fun MyCheckBoxWithText(){
    var state by rememberSaveable {
        mutableStateOf(false)
    }

    Row (
        modifier = Modifier.height(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Checkbox(checked = state,
            onCheckedChange = {state= !state},
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Yellow,
                checkmarkColor = Color.Blue
            ))
    }

    Checkbox(checked = state,
        onCheckedChange = {state= !state},
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Blue
        ))
}

@Composable
fun MyCheckBox(){
    var state by rememberSaveable {
        mutableStateOf(false)
    }

    Checkbox(checked = state,
        onCheckedChange = {state= !state},
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Blue
        ))
}