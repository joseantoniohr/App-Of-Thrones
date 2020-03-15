package com.timplesoft.appofthrones

object CharactersRepo {
    var characters: MutableList<Character> = mutableListOf()

    private fun dummyCharacters(): MutableList<Character> {
        val dummies: MutableList<Character> = mutableListOf()

        for ( index in 1..10 ) {
            Character(
                name = "Personaje"
            )
        }

        return dummies
    }

}