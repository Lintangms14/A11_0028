package com.example.finalprojecta11.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.finalprojecta11.PerpustakaanApplications
import com.example.finalprojecta11.ui.viewmodel.anggota.DetailAnggotaViewModel
import com.example.finalprojecta11.ui.viewmodel.anggota.HomeAnggotaViewModel
import com.example.finalprojecta11.ui.viewmodel.anggota.InsertAnggotaViewModel
import com.example.finalprojecta11.ui.viewmodel.anggota.UpdateAnggotaViewModel
import com.example.finalprojecta11.ui.viewmodel.buku.DetailBukuViewModel
import com.example.finalprojecta11.ui.viewmodel.buku.HomeBukuViewModel
import com.example.finalprojecta11.ui.viewmodel.buku.InsertBukuViewModel
import com.example.finalprojecta11.ui.viewmodel.buku.UpdateBukuViewModel
import com.example.finalprojecta11.ui.viewmodel.peminjaman.DetailPeminjamanViewModel
import com.example.finalprojecta11.ui.viewmodel.peminjaman.HomePeminjamanViewModel
import com.example.finalprojecta11.ui.viewmodel.peminjaman.InsertPeminjamanViewModel
import com.example.finalprojecta11.ui.viewmodel.peminjaman.UpdatePeminjamanViewModel
import com.example.finalprojecta11.ui.viewmodel.pengembalian.DetailPengembalianViewModel
import com.example.finalprojecta11.ui.viewmodel.pengembalian.HomePengembalianViewModel
import com.example.finalprojecta11.ui.viewmodel.pengembalian.InsertPengembalianViewModel

fun CreationExtras.aplikasiPerpustakaan(): PerpustakaanApplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]as PerpustakaanApplications)

object PenyediaViewModel{
    val Factory = viewModelFactory {
        //Buku
        initializer { HomeBukuViewModel(aplikasiPerpustakaan().container.bukuRepository) }
        initializer { InsertBukuViewModel(aplikasiPerpustakaan().container.bukuRepository) }
        initializer { UpdateBukuViewModel(aplikasiPerpustakaan().container.bukuRepository) }
        initializer { DetailBukuViewModel(aplikasiPerpustakaan().container.bukuRepository) }
        //Anggota
        initializer { HomeAnggotaViewModel(aplikasiPerpustakaan().containerA.anggotaRepository) }
        initializer { InsertAnggotaViewModel(aplikasiPerpustakaan().containerA.anggotaRepository) }
        initializer { UpdateAnggotaViewModel(aplikasiPerpustakaan().containerA.anggotaRepository) }
        initializer { DetailAnggotaViewModel(aplikasiPerpustakaan().containerA.anggotaRepository) }
        //Peminjaman
        initializer { HomePeminjamanViewModel(aplikasiPerpustakaan().containerP.peminjamanRepository) }
        initializer { InsertPeminjamanViewModel(aplikasiPerpustakaan().containerP.peminjamanRepository) }
        initializer { UpdatePeminjamanViewModel(aplikasiPerpustakaan().containerP.peminjamanRepository) }
        initializer { DetailPeminjamanViewModel(aplikasiPerpustakaan().containerP.peminjamanRepository) }
        //Pengembalian
        initializer { HomePengembalianViewModel(aplikasiPerpustakaan().containerPe.pengembalianRepository) }
        initializer { InsertPengembalianViewModel(aplikasiPerpustakaan().containerPe.pengembalianRepository) }
        initializer { DetailPengembalianViewModel(aplikasiPerpustakaan().containerPe.pengembalianRepository) }
    }
}