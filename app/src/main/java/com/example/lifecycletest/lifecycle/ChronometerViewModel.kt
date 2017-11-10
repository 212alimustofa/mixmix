package com.example.lifecycletest.lifecycle

import android.arch.lifecycle.ViewModel
import android.support.annotation.Nullable

/**
 * Created by ali on 07/11/17.
 */
data class ChronometerViewModel(@Nullable
                                var startDate: Long? = null): ViewModel()