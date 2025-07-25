package com.fire.adforge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SponsorBannerScreen() {
    val bannerIds = listOf(
        R.drawable.banner_adgem,
        R.drawable.banner_adgate,
        R.drawable.banner_offertoro,
        R.drawable.banner_ayet,
        R.drawable.banner_pollfish,
        R.drawable.banner_bitlabs
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Top Sponsor Banners", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        for (id in bannerIds) {
            Image(
                painter = painterResource(id),
                contentDescription = "Sponsor Banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(120.dp)
            )
        }
    }
}
