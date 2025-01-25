package com.example.finalprojecta11.ui.view.buku

import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi

object DestinasiDetail: DestinasiNavigasi {
    override val route = "detail buku"
    override val titleRes = "Detail Buku"
    const val id_buku = "id_buku"
    val routeWithArgs = "$route/{$id_buku}"
}