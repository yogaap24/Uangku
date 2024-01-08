package com.yogaap.uangku.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ElectricalServices
import androidx.compose.material.icons.rounded.FoodBank
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yogaap.uangku.data.Record
import com.yogaap.uangku.data.Wallet
import com.yogaap.uangku.ui.theme.GreenStart
import com.yogaap.uangku.ui.theme.PurpleEnd
import com.yogaap.uangku.ui.theme.PurpleStart
import com.yogaap.uangku.ui.theme.RedStart
import java.util.TimeZone

val recordList = listOf(
    Record(
        Icons.Rounded.FoodBank,
        "Expense",
        "Lunch",
        10000.00,
        "04-01-2024",
        "11:32",
        TimeZone.getDefault().displayName,
        "Food",
        "Cash",
        null
    ),

    Record(
        Icons.Rounded.ElectricalServices,
        "Expense",
        "Electricity Bill",
        13000.00,
        "03-01-2024",
        "11:32",
        TimeZone.getDefault().displayName,
        "Electricity",
        "Mastercard",
        null
    ),

    Record(
        Icons.Rounded.FoodBank,
        "Expense",
        "Lunch",
        13000.00,
        "03-01-2024",
        "11:32",
        TimeZone.getDefault().displayName,
        "Food",
        "Cash",
        null
    ),

    Record(
        Icons.Rounded.FoodBank,
        "Expense",
        "Lunch",
        15000.00,
        "02-01-2024",
        "11:32",
        TimeZone.getDefault().displayName,
        "Food",
        "Cash",
        null
    ),

    Record(
        Icons.Rounded.FoodBank,
        "Expense",
        "Lunch",
        20000.00,
        "01-01-2024",
        "11:32",
        TimeZone.getDefault().displayName,
        "Food",
        "Mastercard",
        null
    ),

    Record(
        Icons.Rounded.FoodBank,
        "Expense",
        "Lunch",
        10000.00,
        "04-01-2024",
        "11:32",
        TimeZone.getDefault().displayName,
        "Food",
        "Paypal",
        null
    ),

    Record(
        Icons.Rounded.FoodBank,
        "Expense",
        "Lunch",
        13000.00,
        "03-01-2024",
        "11:32",
        TimeZone.getDefault().displayName,
        "Food",
        "Mastercard",
        null
    ),

    Record(
        Icons.Rounded.FoodBank,
        "Expense",
        "Lunch",
        15000.00,
        "02-01-2024",
        "11:32",
        TimeZone.getDefault().displayName,
        "Food",
        "Paypal",
        null
    ),

    Record(
        Icons.Rounded.FoodBank,
        "Expense",
        "Lunch",
        20000.00,
        "01-01-2024",
        "11:32",
        TimeZone.getDefault().displayName,
        "Food",
        "Visa",
        null
    ),
)

@Preview
@Composable
fun RecordSectionPreview() {
    RecordSection(Wallet(
        "Cash",
        null,
        "Personal Cash",
        720000.00,
        getGradientColor(PurpleStart, PurpleEnd),
    ))
}


@Composable
fun RecordSection(selectedWallet: Wallet?) {
    Column {
        Text(
            text = "Record",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )

        if (selectedWallet != null) {
            val recordsForSelectedWallet = recordList.filter {
                it.wallet.equals(selectedWallet.type, ignoreCase = true)
            }
            RecordList(recordsForSelectedWallet)
        } else {
            RecordList(recordList)
        }
    }
}

@Composable
fun RecordList(recordList: List<Record>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 12.dp),
        contentAlignment = Alignment.BottomCenter
    ) {

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                .background(MaterialTheme.colorScheme.background)
        ) {
            val boxWithConstraintsScope = this
            val width = boxWithConstraintsScope.maxWidth / 3 - 10.dp

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier
                            .width(width),
                        text = "Category",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                    )

                    Text(
                        modifier = Modifier
                            .width(width),
                        text = "Amount",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.End
                    )

                    Text(
                        modifier = Modifier
                            .width(width),
                        text = "Date",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.End
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn {
                    items(recordList.size) { index ->
                        RecordItem(index, width)
                        if (index < recordList.size - 1) {
                            Divider(
                                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.2f),
                                thickness = 0.2.dp,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RecordItem(index: Int, width: Dp) {
    val record = recordList[index]
    val iconBackground: Color = if (record.type == "Income") {
        GreenStart
    } else {
        RedStart
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .width(width),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(iconBackground)
                    .padding(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = record.icon,
                    contentDescription = record.category,
                    tint = Color.White
                )
            }

            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = record.category,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }

        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "Rp ${record.amount}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )

        // add date and time
        Column(
            modifier = Modifier.width(width),
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 30.dp),
                text = record.date,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground,
            )

            Text(
                modifier = Modifier
                    .padding(start = 30.dp),
                text = record.time,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
    }
}