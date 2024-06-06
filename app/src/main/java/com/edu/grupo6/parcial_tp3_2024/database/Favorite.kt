package com.edu.grupo6.parcial_tp3_2024.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
class Favorite(
    id: Int,
    name: String,
    type: String
) {

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id : Int

    @ColumnInfo(name = "name")
    var name : String

    @ColumnInfo(name = "type")
    var type : String

    init {
        this.id = id
        this.name = name
        this.type = type
    }
}