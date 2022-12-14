package com.effective.effectiveinternship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.effective.effectiveinternship.ui.theme.EffectiveInternshipTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import kotlin.io.path.ExperimentalPathApi

data class HorizontalPagerContent(
    val title: String,
    val image: Int,
)

fun createItems() = listOf(
    HorizontalPagerContent(title = "Title1", R.drawable.d3man),
    HorizontalPagerContent(title = "Title2", R.drawable.blueman),
    HorizontalPagerContent(title = "Title3", R.drawable.absorbing),
    HorizontalPagerContent(title = "Title4", R.drawable.aim),
    HorizontalPagerContent(title = "Title5", R.drawable.marvel_image),
)

//@OniIn
@OptIn(ExperimentalPagerApi::class)
//@ExperimentalPer
@Composable
fun HorizontalPagerPage() {
    val items = createItems()
    val pagerState = rememberPagerState()
    HorizontalPager(
        count = items.size,
        state = pagerState,
        modifier = Modifier.fillMaxHeight()
    ){ index ->
        Box(
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .fillMaxWidth(0.8f)

//                    .align(Alignment.CenterHorizontally)
                .background(Color.Transparent),
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.FillHeight,
                painter = painterResource(id = items[index].image),
                contentDescription = "Painter"
            )

            Text(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(20.dp),
                text = items[index].title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
            )

        }


    }
//    LazyRow(
//    ) {
//        items (items.size) {index -> Card {
//            Column(
//                Modifier.background(Color.Transparent)
//            ) {
//                Text(
//                    text = items[index].title,
//                    fontSize = 20.sp,
//                )
//                Image(
//                    modifier = Modifier.padding(20.dp),
//                    painter = painterResource(id = items[index].image),
//                    contentDescription = "Painter"
//                )
//            }
//        }}
//    }

}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        R.drawable.marvel_logo
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                Modifier.background(Color(0xff2A2629)),
                backgroundColor = Color(0xff2A2629),
//                topBar = {TopAppBarSample()}

            ) {
                EffectiveInternshipTheme {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun TopAppBarSample(){
    TopAppBar(
        elevation = 4.dp,
        title = {
            Text("I'm a TopAppBar")
        },
        backgroundColor =  MaterialTheme.colors.primarySurface,
    )
}

@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box (Modifier.fillMaxWidth(0.5f)) {
            Image(painter = painterResource(id = R.drawable.marvel), contentDescription = "asd", )
        }
        Text(
            text = "Choose your hero",
            modifier = Modifier.padding(19.dp),
            color = Color.White,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
        )
        HorizontalPagerPage()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EffectiveInternshipTheme {
        Greeting("Android")
    }
}
