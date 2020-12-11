package com.khusnia.datacrud.features.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.khusnia.datacrud.db.repository.LocalRepository
import com.khusnia.datacrud.entity.Student
import com.khusnia.datacrud.features.base.BaseViewModel

class MainActivityViewModel @ViewModelInject constructor(private val localRepository: LocalRepository) : BaseViewModel() {

    private var mTriggerFetchData = MutableLiveData<Boolean>()
    private var student : LiveData<List<Student>> = Transformations.switchMap(mTriggerFetchData){
        localRepository.getAllData()
    }

    fun insertStudent(student: Student){
        localRepository.insertData(student)
    }

    fun getStudents(): LiveData<List<Student>>{
        return student
    }

    fun loadStudent() {
        mTriggerFetchData.value = true
    }
}