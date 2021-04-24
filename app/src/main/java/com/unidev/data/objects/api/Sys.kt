package com.unidev.data.objects.api

import com.google.gson.annotations.SerializedName

class Sys : AbstractObject() {
    @SerializedName("country")
    var country = ""
}