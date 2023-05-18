package com.example.logscreen
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyViewModel : ViewModel() {
    private val _tableData = MutableStateFlow<List<TableItem>>(emptyList())
    val tableData: StateFlow<List<TableItem>> = _tableData
    fun updateTableData(data: List<TableItem>)
    {
        _tableData.value = data
    }
}

