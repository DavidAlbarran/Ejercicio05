package com.dag.ejercicio05

import android.widget.RadioGroup.OnCheckedChangeListener
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//1-Envovemos los parámetros del CheckBox en una clase de datos llamada Option
//2- Creamos una función componible llamada CheckBoxList que recibe una lista de opciones y el título asociado
//3- Creamos una columna para desplegar verticalmente los elementos
//4-Mostramos un componente Text con el título
//5-Añadimos espacio entre el título y las casillas
//6-Invocamos la función de extención foreach desde la lista options con el fin de iterar sobre cada opcion
//7-Usamos LabelledCheckBox() para desplegar las casillas cn sus etiquetas correspondientes
data class Option(//1
    var checked: Boolean,
    var onCheckedChange: (Boolean) -> Unit  = {},
    val  label: String,
    var enabled: Boolean = true
)

@Preview(
    name = "P1",
    showSystemUi = true,
    showBackground = true,
    fontScale = 1.1f,
    apiLevel = 33,
    device = Devices.NEXUS_5
)

@Composable
fun CheckBoxListExample(){//Ejecutar esta!!
    val ingredientes = listOf("Tomate","Cebolla","Ketchup")

    //El map recorre la lista de strings y devuelve una lista de options
    val options= ingredientes.map {
        var checked by rememberSaveable { mutableStateOf(false)}
        //Este es el constructor de Option
        Option(
            checked = checked,
            onCheckedChange = {checked=it},
            label= it
        )
    }

    CheckBoxList(options = options, listTitle = "¿Cómo quieres la hamburguesa")
}

@Composable
fun  CheckBoxList(options: List<Option> ,listTitle: String){//2
    Column {//3
        Text(text = listTitle, textAlign = TextAlign.Justify)//4
        Spacer(modifier = Modifier.size(16.dp))//5
        options.forEach{option ->//6
        LabelledCheckBox(//7
            checked = option.checked,
            label = option.label,
            onCheckedChange = option.onCheckedChange,
            enabled = option.enabled
        )}
    }
}

@Composable
fun CheckBoxLabelExample(){
    var checked = rememberSaveable() {
        mutableStateOf(true)
    }

    LabelledCheckBox(checked = checked.value,
        label = "CheckBox Ejemplo",
        onCheckedChange = {checked.value = it})
}

@Composable
fun LabelledCheckBox(
    checked: Boolean,
    label: String,
    enabled: Boolean= true,
    colors: CheckboxColors= CheckboxDefaults.colors(),
    modifier: Modifier= Modifier,
    onCheckedChange: (Boolean) -> Unit
){
    Row (
        modifier = Modifier.height(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Checkbox(
            modifier= modifier,
            checked = checked,
            onCheckedChange = onCheckedChange,
            enabled = enabled,
            colors = colors)
        Spacer(modifier = Modifier.width(15.dp))
        Text(text = label)

    }
}

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
            enabled = true)
        Spacer(modifier = Modifier.width(15.dp))
        Text(text = "Label")

    }
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