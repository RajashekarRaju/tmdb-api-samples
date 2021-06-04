package network

import modal.People
import java.net.URI
import java.net.URL

/** Add only functions related to peoples. **/


fun peoplePopularUriBuilder(
    peopleType: String
): URL {
    val builtUrl = "$BASE_PATH$APPEND_PATH_PERSON/$peopleType$APPEND_URL_ENDPOINT$assignApiKey"
    val baseUri = URI.create(builtUrl)
    return URL(baseUri.toString())
}

fun buildPeoplePopularType(
    peopleType: String
): List<People> {
    val builtUrl = peoplePopularUriBuilder(peopleType)
    return getJsonPopularPeopleData(createUrl(builtUrl))
}