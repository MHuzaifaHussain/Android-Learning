package com.example.roomlibrary;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ExpenseDao {


    @Query("select * from expense")
    List<Expense> getAllExpense();

    @Insert
    void addTx(Expense expense);

    @Update
    void updateTx(Expense expense);

    @Delete
    void deleteTx(Expense expense);
}
