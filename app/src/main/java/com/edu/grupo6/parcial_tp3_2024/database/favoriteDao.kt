package com.edu.grupo6.parcial_tp3_2024.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface favoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(favorite: Favorite)

    @Update
    fun updateFavorite(favorite: Favorite)

    @Delete
    fun delete(favorite: Favorite)

    @Query("SELECT * FROM favorites ORDER BY id")
    fun getFavorites(): MutableList<Favorite?>?

    @Query("SELECT * FROM favorites WHERE id = :id")
    fun getFavoriteById(id: Int): Favorite?

}