package com.dag.ejercicio05

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
fun RadioGroupExample(){
    val  animalTypes = listOf("Todos","Perro","Gato","Aves")
    val currentSelection = rememberSaveable() {
        mutableStateOf(animalTypes.first())
    }
    val context = LocalContext.current

    RadioGroup(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        items = animalTypes,
        selection = currentSelection.value,
        onItemClick = {clickedItem ->
            currentSelection.value = clickedItem
            Toast.makeText(context, "La opción elegida es $clickedItem", Toast.LENGTH_SHORT)
        }
        )
}

@Composable
fun RadioGroup(
    modifier: Modifier,
    items: List<String>,
    selection: String,
    onItemClick: ((String) -> Unit)
){
    Column(modifier=Modifier) {
        items.forEach { item ->
            LabelledRadioButton(
                modifier=Modifier.fillMaxSize(),
                label= item,
                selected= item== selection,
                onClick= {
                    onItemClick(item)
                }
            )
        }
    }
}

@Composable
fun LabelledRadioButtonExample(){
    var isSelected by rememberSaveable {
        mutableStateOf(false)
    }

    val  myColor= RadioButtonDefaults.colors(
        selectedColor = Color(R.color.purple_500),
        unselectedColor = Color(0xFF2196f3),
        disabledSelectedColor = Color(R.color.purple_200),
    )

    LabelledRadioButton(
        label= "Etiqueta",
        selected= isSelected,
        onClick= { isSelected=true },
        enabled= true,
        colors= myColor
    )
}

@Composable
fun LabelledRadioButton(
    modifier: Modifier= Modifier,
    label: String,
    selected: Boolean,
    onClick: (() -> Unit)?,
    enabled: Boolean = true,
    colors: RadioButtonColors= RadioButtonDefaults.colors()
){
    Row (
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .height(36.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        RadioButton(
            selected = selected,
            onClick = onClick,
            enabled=enabled,
            colors = colors
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium.merge(),
            modifier=Modifier.padding(start = 16.dp)
            )
    }
}

@Composable
fun MyRadioButtom(){
    var isSelected by rememberSaveable {
        mutableStateOf(false)
    }

    RadioButton(selected = isSelected, onClick = { isSelected = true })
}