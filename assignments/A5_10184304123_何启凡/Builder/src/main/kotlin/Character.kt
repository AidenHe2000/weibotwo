import kotlin.properties.Delegates

class Character private constructor(builder: Builder) {
    private val name = builder.name
    private val age = builder.age
    private val height = builder.height
    private val occupation = builder.occupation
    private val address = builder.address


    fun getDescription() =
        "This character calls ${name}.\n" +
                "He/She is $age year(s) old.\n" +
                "He/She is $height cm tall.\n" +
                "He/She's occupation is $occupation.\n" +
                "He/She's address is $address."

    class Builder() {
        lateinit var name: String
        var age by Delegates.notNull<Int>()
        var height by Delegates.notNull<Int>()
        lateinit var occupation: String
        lateinit var address: String

        fun withName(name: String): Builder {
            this.name = name
            return this
        }

        fun withAge(age: Int): Builder {
            this.age = age
            return this
        }

        fun withHeight(height: Int): Builder {
            this.height = height
            return this
        }

        fun withOccupation(occupation: String): Builder {
            this.occupation = occupation
            return this
        }

        fun withAddress(address: String): Builder {
            this.address = address
            return this
        }

        fun build(): Character {
            return Character(this)
        }
    }

}