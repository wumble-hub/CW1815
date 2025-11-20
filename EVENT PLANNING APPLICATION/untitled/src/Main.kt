// Person Class
public data class Person(
    val id: Int,
    val name: String,
    val email: String,
    val phoneNumber: Int,
)

// Venue Class
data class Venue(
    val id: Int,
    val name: String,
    val address: String,
    val capacity: Int
)

// Event Class
data class Event(
    val id: Int,
    val name: String,
    val date: String,
    val time: Int,
    val venue: Venue,
    val registeredPerson: MutableList<Person> = mutableListOf()
) {
    fun canRegisterParticipant(): Boolean {
        return registeredPerson.size < venue.capacity
    }

    fun registerParticipant(participant: Person): Boolean {
        if (canRegisterParticipant()) {
            registeredPerson.add(participant)
            return true
        }
        return false
    }
}
// EventManager Class for logic handling
class EventManager {
    private val events = mutableListOf<Event>()
    private val venues = mutableListOf<Venue>()

    fun addEvent(event: Event): Boolean {
        if (events.none { it.id == event.id }) {
            events.add(event)
            return true
        }
        return false
    }

    fun getAllEvents(): List<Event> = events.toList()

    fun getEventById(id: String): Event? = events.find { it.id == id.toInt() }

    fun addVenue(venue: Venue): Boolean {
        if (venues.none { it.id == venue.id }) {
            venues.add(venue)
            return true
        }
        return false
    }

    fun getAllVenues(): List<Venue> = venues.toList()
}
