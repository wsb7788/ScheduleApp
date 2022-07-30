package com.project.navmvvmpractice.data.entites

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(foreignKeys = [
    ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["id"],
        onDelete = CASCADE,
        onUpdate = CASCADE
    )
])
@Parcelize
data class Todo(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val task:String
) : Parcelable

