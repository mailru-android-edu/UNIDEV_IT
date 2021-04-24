package com.unidev.data.objects.api

import com.google.gson.annotations.SerializedName

class Main : AbstractObject() {
    @SerializedName("temp")
    var temp = 0.0
}