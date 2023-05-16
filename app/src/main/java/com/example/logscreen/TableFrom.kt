import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.logscreen.TableItem
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.logscreen.MyViewModel


@Composable
fun TableForm(viewModel: MyViewModel) {
    val tableData: List<TableItem> by viewModel.tableData.collectAsState(initial = emptyList())

    Column {
        // Table header
        Row(Modifier.fillMaxWidth()) {
            Text(text = "Name", modifier = Modifier.weight(1f).padding(top = 10.dp, start = 30.dp))
            Text(
                text = "Number",
                modifier = Modifier.weight(1f).padding(top = 10.dp, start = 20.dp)
            )
        }

        // Table rows
        tableData.forEach { item ->
                        Row(Modifier.fillMaxWidth()) {
                                  Text(text = item.name, modifier = Modifier.weight(1f))
                                  Text(text = item.number, modifier = Modifier.weight(1f))
                              }
                        }
            Row(
                modifier = Modifier.fillMaxSize()
                    .wrapContentHeight(Alignment.Bottom)
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = ({
                                       viewModel.onButtonClick()
                                  }),
                                         modifier = Modifier.fillMaxWidth(0.5f)
                                         .padding(26.dp)
                                         .border(2.dp, MaterialTheme.colors.secondary)
                                         .background(MaterialTheme.colors.primary)
                                         .padding(10.dp)
                     ) {
                                         Text(text = "SignIn")

                       }
                              Button(modifier = Modifier.fillMaxWidth(1f)
                             .padding(26.dp)
                             .border(2.dp, MaterialTheme.colors.secondary)
                             .background(MaterialTheme.colors.primary)
                             .padding(10.dp),
                             onClick = {
                                       viewModel.onButtonClick()
                                       })
                              {
                                 Text(text = "SignUp")
                              }
                }
        }
    }
