package com.meals.data.base

abstract class BaseDataSource<RT, CH> {
    abstract val remote: RT
    abstract val cache : CH
}