package com.client.shop.ui.search.contract

import com.domain.entity.Category
import com.domain.interactor.category.CategoryListUseCase
import com.ui.base.contract.BaseLcePresenter
import com.ui.base.contract.BaseLceView
import javax.inject.Inject

interface CategoryListView : BaseLceView<List<Category>>

class CategoryListPresenter @Inject constructor(
    private val categoryListUseCase: CategoryListUseCase
) :
    BaseLcePresenter<List<Category>, CategoryListView>(categoryListUseCase) {

    fun getCategoryList(perPage: Int, paginationValue: String?) {

        categoryListUseCase.execute(
            { view?.showContent(it) },
            { it.printStackTrace() },
            CategoryListUseCase.Params(perPage, paginationValue)
        )
    }
}