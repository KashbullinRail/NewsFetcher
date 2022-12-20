package com.example.newsfetcher.canbedeleted

class JsonModel : ArrayList<JsonModel.JsonModelItem>(){

    data class JsonModelItem(
        val apiKey: String,
        val createdAt: String,
        val email: String,
        val id: String,
        val profile: Profile,
        val roles: List<String>,
        val updatedAt: String,
        val username: String
    ) {
        data class Profile(
            val about: String,
            val address: String,
            val company: String,
            val dob: String,
            val location: Location,
            val name: String
        ) {
            data class Location(
                val lat: Double,
                val long: Double
            )
        }
    }

}