package com.project.navmvvmpractice.data.entites

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity
@Parcelize
data class Todo(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val todoList: List<Todo>
) : Parcelable
