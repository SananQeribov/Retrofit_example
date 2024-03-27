package com.example.retrofitexample.Retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Mainviewmodel : ViewModel() {
    private val _post = MutableLiveData<Mypost>()
    val post: LiveData<Mypost>
        get() = _post
    private val _isloading = MutableLiveData<Mypost>()
    val loading: LiveData<Mypost>
        get() = _post

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
        try {
            val post: Mypost = Retrofitinstance.api.getdata()

            withContext(Dispatchers.Main) {
                _post.value = post
            }
        }

        catch (
            e:Exception
        ){
            e.printStackTrace()
        }


        }
    }
}