package com.example.finalprojecta11.ui.view.anggota

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finalprojecta11.model.Anggota
import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi

object DestinasiHomeAnggota : DestinasiNavigasi {
    override val route = "home anggota"
    override val titleRes = "Home Anggota"
}

@Composable
fun AgtTableRow(
    anggota: Anggota,
    onDetailClick: (Anggota) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onDetailClick(anggota) }
            .border(BorderStroke(1.dp, MaterialTheme.colorScheme.onSurfaceVariant))
            .padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = anggota.id_anggota,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = anggota.nama,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(2f)
        )
        Text(
            text = anggota.email,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(2f)
        )
        Text(
            text = anggota.nomor_telepon,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(2f)
        )
    }
}