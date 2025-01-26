package com.example.finalprojecta11.ui.view.peminjaman

import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi

object DestinasiUpdatePeminjaman : DestinasiNavigasi {
    override val route = "update_peminjaman"
    override val titleRes = "Update Peminjaman"
    const val id_peminjaman = "id_peminjaman"
    val routeWithArgs = "$route/{$id_peminjaman}"
}