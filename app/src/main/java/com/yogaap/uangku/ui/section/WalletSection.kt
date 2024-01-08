package com.yogaap.uangku.ui.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yogaap.uangku.R
import com.yogaap.uangku.data.Wallet
import com.yogaap.uangku.ui.theme.BlueEnd
import com.yogaap.uangku.ui.theme.BlueStart
import com.yogaap.uangku.ui.theme.GreenEnd
import com.yogaap.uangku.ui.theme.GreenStart
import com.yogaap.uangku.ui.theme.OrangeEnd
import com.yogaap.uangku.ui.theme.OrangeStart
import com.yogaap.uangku.ui.theme.PurpleEnd
import com.yogaap.uangku.ui.theme.PurpleStart

val wallets = listOf(
    Wallet(
        "Cash",
        null,
        "Personal Cash",
        720000.00,
        getGradientColor(PurpleStart, PurpleEnd),
    ),
    Wallet(
        "Visa",
        "**** 1234",
        "Personal Bank",
        670000.10,
        getGradientColor(BlueStart, BlueEnd),
    ),
    Wallet(
        "Paypal",
        "**** 1234",
        "Personal Paypal",
        546720.14,
        getGradientColor(OrangeStart, OrangeEnd),
    ),
    Wallet(
        "Mastercard",
        null,
        "Personal Mastercard",
        1200000.00,
        getGradientColor(GreenStart, GreenEnd)
    ),
)

fun getGradientColor(
    startColor: Color,
    endColor: Color
) : Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Preview
@Composable
fun WalletSectionPreview() {
    WalletSection(null) {}
}


@Composable
fun WalletSection(selectedWallet: Wallet?, onWalletItemClick: (Wallet) -> Unit) {
    LazyRow {
        items(wallets.size) { index ->
            WalletItem(index, onWalletItemClick, selectedWallet == wallets[index])
        }
    }
}

@Composable
fun WalletItem(
    index: Int,
    onWalletItemClick: (Wallet) -> Unit,
    isSelected: Boolean
) {
    val wallet = wallets[index]
    var lastItemPaddingEnd = 0.dp
    if (index == wallets.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var icon = painterResource(id = R.drawable.ic_visa)
    when (wallet.type) {
        "Cash" -> {
            icon = painterResource(id = R.drawable.ic_cash)
        }
        "Paypal" -> {
            icon = painterResource(id = R.drawable.ic_paypal)
        }
        "Mastercard" -> {
            icon = painterResource(id = R.drawable.ic_mastercard)
        }
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(wallet.color)
                .width(250.dp)
                .height(150.dp)
                .padding(vertical = 12.dp, horizontal = 16.dp)
                .clickable {
                    onWalletItemClick(wallet)
                },
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = icon,
                contentDescription = wallet.name,
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = wallet.name,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = wallet.balance.toString(),
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = wallet.number ?: "-",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}