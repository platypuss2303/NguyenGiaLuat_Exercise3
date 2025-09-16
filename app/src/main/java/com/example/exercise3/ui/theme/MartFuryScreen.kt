package com.example.exercise3.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercise3.R

@Composable
@Preview(showSystemUi = true)
fun MartFuryScreen(){
    val sampleCategories = listOf(
        Category("Electronics", R.drawable.tv),
        Category("Clothing", R.drawable.tv),
        Category("Computers", R.drawable.tv),
        Category("Home & Kitchen", R.drawable.tv),
        Category("Health & Beauty", R.drawable.tv),
        Category("Jewelry & Watch", R.drawable.tv)
    )
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            BannerSection()
            FeaturedCategories(categories = sampleCategories)
            FeaturedBrands()
        }
    }
}

@Composable
fun TopBar() {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFFFFC107))
        .padding(vertical = 8.dp)
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFC107))
                .statusBarsPadding()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "mart",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 20.sp
            )
            Text(
                text = "fury",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(Icons.Default.Favorite, contentDescription = "Wishlist")
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
        }

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text(text = "I'm shopping for...", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth(0.9f)
                .align(Alignment.CenterHorizontally)
                .height(35.dp)
                .background(Color.White, RoundedCornerShape(12.dp)),
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") }
        )
    }


}

@Composable
fun BannerSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Banner lớn
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = "Banner lớn",
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Row 2 banner nhỏ
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.banner),
                    contentDescription = "Banner nhỏ 1",
                    contentScale = ContentScale.Crop
                )
            }

            Card(
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.banner),
                    contentDescription = "Banner nhỏ 2",
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun FeaturedCategories(categories: List<Category>) {


    Column(modifier = Modifier.padding(8.dp)) {
        Text("Featured Categories", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(Modifier.height(8.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.height(190.dp)
        ) {
            items(categories) { category ->
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter =  painterResource(id = category.iconRes),
                        contentDescription = category.title,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(category.title, fontSize = 14.sp)
                }
            }
        }
    }
}
//
@Composable
fun FeaturedBrands() {
    Column(modifier = Modifier.padding(8.dp)) {
        Text("Featured Brands", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.fpt),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.fpt),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.fpt),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
        }
    }
}

@Composable
fun BottomNavigationBar() {
    // Map giữa label và icon tương ứng
    val items = listOf(
        "Home" to Icons.Default.Home,
        "Categories" to Icons.AutoMirrored.Filled.List,
        "Explorer" to Icons.Default.Search,
        "Cart" to Icons.Default.ShoppingCart,
        "Profile" to Icons.Default.Person
    )

    NavigationBar {
        items.forEach { (label, icon) ->
            NavigationBarItem(
                selected = label == "Home", // chọn mặc định "Home"
                onClick = { /* TODO */ },
                icon = { Icon(icon, contentDescription = label) },
                label = { Text(label) }
            )
        }
    }
}
