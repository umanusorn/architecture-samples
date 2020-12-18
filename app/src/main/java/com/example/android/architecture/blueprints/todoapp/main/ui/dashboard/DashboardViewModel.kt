package com.example.android.architecture.blueprints.todoapp.main.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = """
            สมัคร course
            บันทึกสภาพจิต
            รูปภาพ
            ข้อมูลติดต่อสำนัก
            share รูป
        """.trimIndent()
    }
    val text: LiveData<String> = _text
}