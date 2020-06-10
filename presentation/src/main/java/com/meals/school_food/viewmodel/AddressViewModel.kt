package com.meals.school_food.viewmodel

import com.meals.domain.dataSource.GetSearchUseCase
import com.meals.domain.model.Search
import com.meals.school_food.base.BaseViewModel
import io.reactivex.observers.DisposableSingleObserver

class AddressViewModel(
    private val getSearchUseCase: GetSearchUseCase
) : BaseViewModel() {

    init {
        getSchools()
    }

    val schoolList = ArrayList<Search>()

    private fun getSchools() {
        addDisposable(getSearchUseCase.buildUseCaseObservable(GetSearchUseCase.Params("대구")),
            object : DisposableSingleObserver<Search>() {
                override fun onSuccess(t: Search) {
                    schoolList.add(t)
                }
                override fun onError(e: Throwable) { }
            })
    }
}