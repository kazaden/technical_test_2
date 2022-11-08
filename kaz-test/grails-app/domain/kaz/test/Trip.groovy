package kaz.test

class Trip {

	String title

	String desc

	static belongsTo = [pro : Pro]

    static constraints = {
    }
}
