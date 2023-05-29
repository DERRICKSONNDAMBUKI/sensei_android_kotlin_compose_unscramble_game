package com.example.ncemptycomposeactivitymaterial3.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.ncemptycomposeactivitymaterial3.data.allWords
import com.example.ncemptycomposeactivitymaterial3.ui.uiState.GameUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel:ViewModel(){

    init {
        resetGame()
    }
    //    Game UI state
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    private lateinit var currentWord : String

    private var usedWords:MutableSet<String> = mutableSetOf()

    private fun pickRandomWordAndShuffle():String{
        currentWord = allWords.random()
        if (usedWords.contains(currentWord)){
            return pickRandomWordAndShuffle()
        }else{
            usedWords.add(currentWord)
            return shuffleCurrentWord(currentWord)
        }
    }

    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
//        Scramble the word
        tempWord.shuffle()
        while (String(tempWord).equals(word)){
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    fun resetGame(){
        usedWords.clear()
        _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())
    }
}