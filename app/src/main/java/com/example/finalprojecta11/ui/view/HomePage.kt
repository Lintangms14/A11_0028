package com.example.finalprojecta11.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalprojecta11.R
import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi

object HomePage : DestinasiNavigasi {
    override val route = "HomePage"
    override val titleRes = "Home Page"
}

@Composable
fun SplashView(
    onBukuButton: () -> Unit,
    onAnggotaButton: () -> Unit,
    onPeminjamanButton: () -> Unit,
    onPengembalianButton: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF6A11CB),
                    Color(0xFF2575FC)
                )
            )),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Perpustakaan",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            letterSpacing = 2.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.perpus),
            contentDescription = "Logo Perpustakaan",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .border(4.dp, Color.White, CircleShape)
        )

        Spacer(modifier = Modifier.height(24.dp))

        val buttonColors = ButtonDefaults.buttonColors(
            contentColor = Color.White
        )

        Button(
            onClick = { onBukuButton() },
            colors = buttonColors,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(vertical = 8.dp)
                .height(56.dp)
                .shadow(elevation = 6.dp, shape = RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
        ) {
            Text(text = "Buku", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Button(
            onClick = { onAnggotaButton() },
            colors = buttonColors,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(vertical = 8.dp)
                .height(56.dp)
                .shadow(elevation = 6.dp, shape = RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
        ) {
            Text(text = "Anggota", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Button(
            onClick = { onPeminjamanButton() },
            colors = buttonColors,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(vertical = 8.dp)
                .height(56.dp)
                .shadow(elevation = 6.dp, shape = RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
        ) {
            Text(text = "Peminjaman", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Button(
            onClick = { onPengembalianButton() },
            colors = buttonColors,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(vertical = 8.dp)
                .height(56.dp)
                .shadow(elevation = 6.dp, shape = RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
        ) {
            Text(text = "Pengembalian", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}