package com.example.finalprojecta11.ui.view.pengembalian

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi

object DestinasiDetailPemngembalian: DestinasiNavigasi {
    override val route = "detail pengembalian"
    override val titleRes = "Detail Pengembalian"
    const val id_pengembalian = "id_pengembalian"
    val routeWithArgs = "$route/{$id_pengembalian}"
}

@Composable
fun ComponentDetailPngmbln(
    modifier: Modifier = Modifier,
    judul: String,
    isinya: String
) {
    Column (
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ){
        Text(
            text = "$judul : ",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Text(
            text = isinya,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}