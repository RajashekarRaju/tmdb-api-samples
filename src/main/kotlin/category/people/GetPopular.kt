package category.people

import modal.People
import repository.Repository

private fun main() {

    val repository = Repository()
    val popularPeoplesList: List<People> = repository.getPopularPeoples()

    popularPeoplesList.forEach { people ->
        val peopleId = people.peopleId
        val name = people.name
        val profileUrl = people.profileUrl
        val department = people.department
        val popularity = people.popularity

        println("Id is $peopleId, name is $name \n Popularity = $popularity \n Belongs to = $department \n Profile - $profileUrl")
    }
}