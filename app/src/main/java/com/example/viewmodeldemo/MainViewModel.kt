package com.example.viewmodeldemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class MainViewModel: ViewModel() {

    var liveString= MutableLiveData<String>("This is my first view")

    suspend fun changeLiveString(){
        var myList= arrayListOf<String>()

        for(i in 1..100){
            myList.add("This is my $i view")
            liveString.value=myList[i-1]
            delay(1000)
        }


    }

}