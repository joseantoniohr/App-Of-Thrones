package com.timplesoft.appofthrones

object CharactersRepo {

    var characters: MutableList<Character> = mutableListOf()
    get() {  // Don't use character -> We have to use 'field' always
        if ( field.isEmpty() ) field.addAll(dummyCharacters())
        return field
    }

    private fun dummyCharacters(): MutableList<Character> {
        return (1..10).map {
                intToCharacter(it)
            }.toMutableList()
    } 
    
    private fun intToCharacter(int: Int): Character {
        return Character(
            name = "Personaje ${int}",
            title = "Título ${int}",
            born = "Nació en ${int}",
            actor = "Actor ${int}",
            quote = "Frase ${int}",
            father = "Padre ${int}",
            mother = "Madre ${int}",
            spouse = "Espos@ ${int}",
            house = House(
                name = "Casa ${int}",
                region = "Región ${int}",
                words = "Lema ${int}"
            )
        )
    }

    fun findCharacterById(id: String): Character? {
        return characters.find { character ->
            character.id == id
        }
    }

}