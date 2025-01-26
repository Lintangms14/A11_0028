package com.example.finalprojecta11.ui.view.anggota

import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi

object DestinasiUpdateAnggota: DestinasiNavigasi {
    override val route = "update anggota"
    override val titleRes = "Update Anggota"
    const val id_anggota = "id_anggota"
    val routeWithArgs = "$route/{$id_anggota}"
}

