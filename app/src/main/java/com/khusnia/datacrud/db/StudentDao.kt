package com.khusnia.datacrud.db

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.khusnia.datacrud.entity.Student
import io.reactivex.Flowable


@Dao
interface StudentDao {
    @Query("SELECT * from students")
    fun getAll(): Flowable<List<Student>>

    @Query("SELECT * FROM students WHERE id = :id ")
    fun getById(id: String): Flowable<Student>

    @Insert(onConflict = REPLACE)
    fun insert(student: Student)

    @Delete
    fun delete(student: Student)

    @Query("UPDATE students SET name =:studentName, nim =:studentNim, gender =:studentGen WHERE id =:studentId")
    fun update(studentId: Long, studentName:String, studentNim:String, studentGen:String)
}