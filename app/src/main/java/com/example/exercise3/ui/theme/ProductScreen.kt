package com.example.exercise3.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercise3.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true)
fun ProductDetailScreen() {
    Column( modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFFFFC107)))
    {
        Row {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            Text(text = "Back to Shop")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // --- Top Bar ---
//        SmallTopAppBar(
//            title = { Text("Back to Shop") },
//            navigationIcon = {
//                IconButton(onClick = { /* Handle back */ }) {
//                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
//                }
//            },
//            actions = {
//                Box {
//                    IconButton(onClick = { /* Handle cart click */ }) {
//                        Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
//                    }
//                    // Badge
//                    Box(
//                        modifier = Modifier
//                            .size(16.dp)
//                            .background(Color.Red, CircleShape)
//                            .align(Alignment.TopEnd),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(
//                            "3",
//                            color = Color.White,
//                            fontSize = 10.sp
//                        )
//                    }
//                }
//            },
//            colors = TopAppBarDefaults.smallTopAppBarColors(
//                containerColor = Color(0xFFFFC107),
//                titleContentColor = Color.Black,
//                actionIconContentColor = Color.Black,
//                navigationIconContentColor = Color.Black
//            )
//        )

        Spacer(modifier = Modifier.height(8.dp))

        // --- Product Image ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Image(
                painter = painterResource(id = R.drawable.iphone),
                contentDescription = "Product Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = "1 / 4",
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.Gray.copy(alpha = 0.7f), RoundedCornerShape(12.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                color = Color.White,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // --- Product Info ---
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text("Headphone Ultra Bass", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Brand: ", fontSize = 14.sp, color = Color.Gray)
                Text("Automotive", fontSize = 14.sp, color = Color(0xFF2196F3))
            }

            // Rating stars
            Row(verticalAlignment = Alignment.CenterVertically) {
                repeat(5) { index ->
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = if (index < 3) Color.Yellow else Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text("8", fontSize = 12.sp, color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Action buttons nhỏ
            Row {
                SmallIconButton(Icons.Default.Add)
                Spacer(modifier = Modifier.width(8.dp))
                SmallIconButton(Icons.Default.Favorite)
                Spacer(modifier = Modifier.width(8.dp))
                SmallIconButton(Icons.Default.Share)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Categories
            Text(
                text = "Categories: Wireless Speakers, Digital Cables, Computers, Monitors",
                fontSize = 12.sp,
                color = Color.DarkGray
            )

            // SKU
            Text("SKU: LI-139", fontSize = 12.sp, color = Color.Gray)
        }

        Spacer(modifier = Modifier.weight(1f))

        // --- Bottom Buttons ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { /* add to cart */ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Icon(Icons.Default.ShoppingCart, contentDescription = null, tint = Color.Black)
                Spacer(modifier = Modifier.width(4.dp))
                Text("Add to Cart", color = Color.Black)
            }

            Button(
                onClick = { /* buy now */ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(contentColor = Color(0xFFFF9800))
            ) {
                Text("Buy Now", color = Color.White)
            }
        }
    }
}


@Composable
fun SmallIconButton(icon: ImageVector) {
    IconButton(
        onClick = { /* action */ },
        modifier = Modifier
            .size(36.dp)
            .background(Color.Gray.copy(alpha = 0.1f), CircleShape)
    ) {
        Icon(icon, contentDescription = null, tint = Color.Black)
    }
}
