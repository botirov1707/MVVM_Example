package com.example.mvvmexample.ui.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmexample.model.Post
import com.example.mvvmexample.repository.PostRepository
import com.example.mvvmexample.utils.UiStateList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository):ViewModel() {
    private val _postState = MutableStateFlow<UiStateList<Post>>(UiStateList.EMPTY)
    val postState = _postState

    fun getPosts() = viewModelScope.launch {
        _postState.value = UiStateList.LOADING
        try {
            val posts = postRepository.getPosts()
            _postState.value = UiStateList.SUCCESS(posts)
        }catch (e:Exception){
            _postState.value = UiStateList.ERROR(e.localizedMessage?:"No Connection")
        }
    }
}