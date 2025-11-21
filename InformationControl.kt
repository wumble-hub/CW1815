public class InformationControl {


    fun concatenateInfo(event: Event, venue: Venue): String {
        val eventInfo = " ${event.name}|||${event.date}|||${event.time}"
        val venueInfo = " ${venue.name}|||${venue.address}|||${venue.capacity}"

        val saveSystem = SaveSystem()
        saveSystem.insertData(eventInfo, venueInfo)
        return TODO("Provide the return value")
    }
}