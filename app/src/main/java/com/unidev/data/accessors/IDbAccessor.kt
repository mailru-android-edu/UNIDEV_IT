package com.unidev.data.accessors

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.unidev.data.objects.db.Video

@Dao
interface IDbAccessor {
    @Query("SELECT * FROM video")
    fun getAll(): List<Video>

    @Query("SELECT * FROM video WHERE uid IN (:videoIds)")
    fun loadAllByIds(videoIds: IntArray): List<Video>

    @Query("SELECT * FROM video WHERE name LIKE :name AND url LIKE :url LIMIT 1")
    fun findByName(name: String, url: String): Video

    @Insert
    fun insertAll(vararg videos: Video)

    @Delete
    fun delete(video: Video)
}
