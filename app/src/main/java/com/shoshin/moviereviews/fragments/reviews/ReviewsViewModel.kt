package com.shoshin.moviereviews.fragments.reviews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.shoshin.domain.entities.Review
import com.shoshin.domain.usecases.interfaces.IGetReviewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReviewsViewModel @Inject constructor(
    private val getReviewUseCase: IGetReviewUseCase
): ViewModel() {
    private val _reviews: MutableLiveData<PagingData<Review>> = MutableLiveData()
    val reviews: LiveData<PagingData<Review>> = _reviews

    fun getReviews() {
        viewModelScope.launch {
            getReviewUseCase.getReviews().collectLatest { pagingData ->
                _reviews.value = pagingData
            }
        }
    }
}