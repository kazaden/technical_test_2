package kaz.test

class Trip {

	String title

	String desc

	Integer nbParticipantsMax 

	static belongsTo = [pro : Pro]

    static constraints = {
    }
}
