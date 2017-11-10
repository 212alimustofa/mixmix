package com.example.lifecycletest.nestedrecyclerview

/**
 * Created by ali on 09/11/17.
 */
data class Data(
        val aPeople: String,
        val aPost: String,
        val subDatas: MutableList<SubData>
)