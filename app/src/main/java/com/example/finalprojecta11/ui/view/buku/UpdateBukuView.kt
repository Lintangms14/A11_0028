package com.example.finalprojecta11.ui.view.buku

import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi


object DestinasiUpdate: DestinasiNavigasi {
    override val route = "update"
    override val titleRes = "Update Buku"
    const val id_buku = "id_buku"
    val routeWithArgs = "$route/{$id_buku}"
}