package com.example.finalprojecta11.ui.navigation

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.finalprojecta11.ui.view.HomePage
import com.example.finalprojecta11.ui.view.SplashView
import com.example.finalprojecta11.ui.view.anggota.DestinasiDetailAnggota
import com.example.finalprojecta11.ui.view.anggota.DestinasiEntryAnggota
import com.example.finalprojecta11.ui.view.anggota.DestinasiHomeAnggota
import com.example.finalprojecta11.ui.view.anggota.DestinasiUpdateAnggota
import com.example.finalprojecta11.ui.view.anggota.DetailAnggotaView
import com.example.finalprojecta11.ui.view.anggota.EntryAgtScreen
import com.example.finalprojecta11.ui.view.anggota.HomeAnggotaScreen
import com.example.finalprojecta11.ui.view.anggota.UpdateAgtScreen
import com.example.finalprojecta11.ui.view.buku.DestinasiDetail
import com.example.finalprojecta11.ui.view.buku.DestinasiEntry
import com.example.finalprojecta11.ui.view.buku.DestinasiHome
import com.example.finalprojecta11.ui.view.buku.DestinasiUpdate
import com.example.finalprojecta11.ui.view.buku.DetailBukuView
import com.example.finalprojecta11.ui.view.buku.EntryBkScreen
import com.example.finalprojecta11.ui.view.buku.HomeScreen
import com.example.finalprojecta11.ui.view.buku.UpdateBkScreen
import com.example.finalprojecta11.ui.view.peminjaman.DestinasiDetailPeminjaman
import com.example.finalprojecta11.ui.view.peminjaman.DestinasiHomePeminjaman
import com.example.finalprojecta11.ui.view.peminjaman.DestinasiUpdatePeminjaman
import com.example.finalprojecta11.ui.view.peminjaman.DetailPeminjamanView
import com.example.finalprojecta11.ui.view.peminjaman.EntryPmjmnScreen
import com.example.finalprojecta11.ui.view.peminjaman.HomePeminjamanScreen
import com.example.finalprojecta11.ui.view.peminjaman.UpdatePeminjamanScreen
import com.example.finalprojecta11.ui.view.pengembalian.DestinasiDetailPemngembalian
import com.example.finalprojecta11.ui.view.pengembalian.DestinasiEntryPengembalian
import com.example.finalprojecta11.ui.view.pengembalian.DestinasiHomePengembalian
import com.example.finalprojecta11.ui.view.pengembalian.DetailPengembalianView
import com.example.finalprojecta11.ui.view.pengembalian.EntryPngmblnScreen
import com.example.finalprojecta11.ui.view.pengembalian.HomePengembalianScreen

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()){
    NavHost(
        navController = navController,
        startDestination = HomePage.route,
        modifier = Modifier,
    ){
        composable(HomePage.route) {
            SplashView(
                onBukuButton = {
                    navController.navigate(DestinasiHome.route)
                },
                onAnggotaButton = {
                    navController.navigate(DestinasiHomeAnggota.route)
                },
                onPeminjamanButton = {
                    navController.navigate(DestinasiHomePeminjaman.route)
                },
                onPengembalianButton = {
                    navController.navigate(DestinasiHomePeminjaman.route)
                }
            )
        }
        //Buku
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToitemEntry = {navController.navigate(DestinasiEntry.route)},
                onDetailClick = {id_buku ->
                    navController.navigate("${DestinasiDetail.route}/$id_buku")
                    println(
                        "PengelolaHalaman: id_buku = $id_buku"
                    )
                },
                navigateBack = { navController.navigate(HomePage.route) {
                    popUpTo(DestinasiHome.route) { inclusive = true }
                }
                }
            )
        }
        composable(DestinasiEntry.route){
            EntryBkScreen(navigateBack = {
                navController.navigate(DestinasiHome.route){
                    popUpTo(DestinasiHome.route){
                        inclusive = true
                    }
                }
            })
        }
        composable(DestinasiDetail.routeWithArgs,arguments = listOf(
            navArgument(DestinasiDetail.id_buku){
                type = NavType.StringType
            }
        )
        ){
            val id_buku = it.arguments?.getString(DestinasiDetail.id_buku)
            id_buku?.let { id_buku ->
                DetailBukuView(
                    navigateBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${DestinasiUpdate.route}/$it")
                    },
                    id_buku = id_buku,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
        composable(
            DestinasiUpdate.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiUpdate.id_buku) {
                    type = NavType.StringType
                }
            )
        ) {
            val id_buku = it.arguments?.getString(DestinasiUpdate.id_buku)
            id_buku?.let { id_buku ->
                UpdateBkScreen(
                    navigateBack = {
                        navController.popBackStack()
                    },
                    id_buku = id_buku
                )
            }
        }

        //Anggota
        composable(DestinasiHomeAnggota.route){
            HomeAnggotaScreen(
                navigateToitemEntry = {navController.navigate(DestinasiHomeAnggota.route)},
                onDetailClick = {id_anggota ->
                    navController.navigate("${DestinasiDetailAnggota.route}/$id_anggota")
                    println(
                        "PengelolaHalaman: id_anggota = $id_anggota"
                    )
                },
                navigateBack = { navController.navigate(HomePage.route) {
                    popUpTo(DestinasiHome.route) { inclusive = true }
                }
                }
            )
        }
        composable(DestinasiEntryAnggota.route){
            EntryAgtScreen(navigateBack = {
                navController.navigate(DestinasiHomeAnggota.route){
                    popUpTo(DestinasiHomeAnggota.route){
                        inclusive = true
                    }
                }
            })
        }
        composable(DestinasiDetailAnggota.routeWithArgs,arguments = listOf(
            navArgument(DestinasiDetailAnggota.id_anggota){
                type = NavType.StringType
            }
        )
        ){
            val id_anggota = it.arguments?.getString(DestinasiDetailAnggota.id_anggota)
            id_anggota?.let { id_anggota ->
                DetailAnggotaView(
                    navigateBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${DestinasiUpdateAnggota.route}/$it")
                    },
                    id_anggota = id_anggota,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
        composable(
            DestinasiUpdateAnggota.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiUpdateAnggota.id_anggota) {
                    type = NavType.StringType
                }
            )
        ) {
            val id_anggota = it.arguments?.getString(DestinasiUpdateAnggota.id_anggota)
            id_anggota?.let { id_anggota ->
                UpdateAgtScreen(
                    navigateBack = {
                        navController.popBackStack()
                    },
                    id_anggota = id_anggota
                )
            }
        }
        //Peminjaman
        composable(DestinasiHomeAnggota.route){
            HomePeminjamanScreen(
                navigateToitemEntry = {navController.navigate(DestinasiHomePeminjaman.route)},
                onDetailClick = {id_peminjaman ->
                    navController.navigate("${DestinasiDetailPeminjaman.route}/$id_peminjaman")
                    println(
                        "PengelolaHalaman: id_peminjaman = $id_peminjaman"
                    )
                },
                navigateBack = { navController.navigate(HomePage.route) {
                    popUpTo(DestinasiHome.route) { inclusive = true }
                }
                }
            )
        }
        composable(DestinasiEntryAnggota.route){
            EntryPmjmnScreen(navigateBack = {
                navController.navigate(DestinasiHomePeminjaman.route){
                    popUpTo(DestinasiHomePeminjaman.route){
                        inclusive = true
                    }
                }
            })
        }
        composable(DestinasiDetailPeminjaman.routeWithArgs,arguments = listOf(
            navArgument(DestinasiDetailPeminjaman.id_peminjaman){
                type = NavType.StringType
            }
        )
        ){
            val id_peminjaman = it.arguments?.getString(DestinasiDetailPeminjaman.id_peminjaman)
            id_peminjaman?.let { id_peminjaman ->
                DetailPeminjamanView(
                    navigateBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${DestinasiUpdatePeminjaman.route}/$it")
                    },
                    id_peminjaman = id_peminjaman,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
        composable(
            DestinasiUpdatePeminjaman.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiUpdatePeminjaman.id_peminjaman) {
                    type = NavType.StringType
                }
            )
        ) {
            val id_peminjaman = it.arguments?.getString(DestinasiUpdatePeminjaman.id_peminjaman)
            id_peminjaman?.let { id_peminjaman ->
                UpdatePeminjamanScreen(
                    navigateBack = {
                        navController.popBackStack()
                    },
                    id_peminjaman = id_peminjaman
                )
            }
        }

        //Pengembalian
        composable(DestinasiHomePengembalian.route){
            HomePengembalianScreen(
                navigateToitemEntry = {navController.navigate(DestinasiHomePengembalian.route)},
                onDetailClick = {id_pengembalian ->
                    navController.navigate("${DestinasiDetailPemngembalian.route}/$id_pengembalian")
                    println(
                        "PengelolaHalaman: id_pengembalian = $id_pengembalian"
                    )
                },
                navigateBack = { navController.navigate(HomePage.route) {
                    popUpTo(DestinasiHome.route) { inclusive = true }
                }
                }
            )
        }
        composable(DestinasiEntryPengembalian.route){
            EntryPngmblnScreen(navigateBack = {
                navController.navigate(DestinasiHomePengembalian.route){
                    popUpTo(DestinasiHomePengembalian.route){
                        inclusive = true
                    }
                }
            })
        }
        composable(DestinasiDetailPemngembalian.routeWithArgs,arguments = listOf(
            navArgument(DestinasiDetailPemngembalian.id_pengembalian){
                type = NavType.StringType
            }
        )
        ){
            val id_pengembalian = it.arguments?.getString(DestinasiDetailPemngembalian.id_pengembalian)
            id_pengembalian?.let { id_penegmbalian ->
                DetailPengembalianView(
                    navigateBack = {
                        navController.popBackStack()
                    },
                    id_pengembalian = id_penegmbalian,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}