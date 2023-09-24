package com.aa.local

import androidx.room.Database
import com.aa.repository.entities.TestDatabaseDto

@Database(
    entities = [TestDatabaseDto::class],
    version = 1,
    exportSchema = false
)
abstract class DatabaseTest {

}