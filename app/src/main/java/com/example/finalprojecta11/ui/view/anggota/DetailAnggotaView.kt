package com.example.finalprojecta11.ui.view.anggota

import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi

object DestinasiDetailAnggota: DestinasiNavigasi {
    override val route = "detail anggota"
    override val titleRes = "Detail Anggota"
    const val id_anggota = "id_anggota"
    val routeWithArgs = "$route/{$id_anggota}"
}