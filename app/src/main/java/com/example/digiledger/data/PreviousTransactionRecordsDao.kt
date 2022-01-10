package com.example.digiledger.data


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PreviousTransactionRecordsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(previousTransactionRecords: PreviousTransactionRecords)

    @Query("SELECT * FROM transaction_history ORDER BY id ASC")
    fun getAll(): LiveData<List<PreviousTransactionRecords>>
}