package com.ics342.labs
import com.squareup.moshi.Json

data class Person(
    @Json(name = "id") val Id: Int,
    @Json(name = "give_name") val giveName: String,
    @Json(name ="family_name") val familyName: String,
    @Json(name = "age") val Age: Int
)

