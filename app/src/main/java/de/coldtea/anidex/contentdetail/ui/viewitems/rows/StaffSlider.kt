package de.coldtea.anidex.contentdetail.ui.viewitems.rows

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import de.coldtea.anidex.base.ui.viewitems.PreviewCardDisplay
import de.coldtea.anidex.content.ui.viewitems.contentgrid.LoadingCardStripe
import de.coldtea.anidex.contentdetail.domain.model.StaffPreview

@Composable
fun StaffSlider(
    modifier: Modifier = Modifier,
    staff: List<StaffPreview>
) {
    Column(modifier = modifier) {
        Text(
            text = "Staff",
            fontSize = 20.sp,
            fontWeight = FontWeight.W500
        )
        if (staff.size > 0) {
            LazyRow(modifier = modifier) {
                items(staff) { staff ->
                    PreviewCardDisplay(
                        height = 180,
                        width = 115,
                        name = staff.name,
                        imageUrl = staff.imageUrl
                    )
                }
            }
        } else {
            LoadingCardStripe(
                height = 180,
                width = 115
            )
        }
    }
}