package com.example.finalprojecta11.ui.view.pengembalian

import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi

object DestinasiDetailPemngembalian: DestinasiNavigasi {
    override val route = "detail pengembalian"
    override val titleRes = "Detail Pengembalian"
    const val id_pengembalian = "id_pengembalian"
    val routeWithArgs = "$route/{$id_pengembalian}"
}