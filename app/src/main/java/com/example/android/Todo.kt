package com.example.android

import android.content.Context
import androidx.room.*
import java.security.AccessControlContext

@Entity(
    tableName = "Todo"
)
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    var label: String,
    var checked: Boolean = false
)


@Dao
interface TodoDAO {
    @Query("SELECT * FROM Todo")
    fun retrieveAll(): List<TodoEntity>

    @Insert
    fun insertTodo(vararg todo: TodoEntity): java.util.List<java.lang.Long>

    @Update
    fun updateTodo(vararg todo: TodoEntity)
}

@Database(entities = [TodoEntity::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun todoDAO(): TodoDAO

    companion object {
        private const val DATABASE_NAME = "TODO_DB"
    }
}