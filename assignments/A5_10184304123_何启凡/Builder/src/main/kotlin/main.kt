fun main(args: Array<String>) {
    val alice = Character.Builder().run {
        withName("Alice")
        withAge(20)
        withHeight(170)
        withOccupation("Undergraduate")
        withAddress("Green Street")
        build()
    }
    val bob = Character.Builder().run {
        withName("Bobby")
        withAge(48)
        withHeight(175)
        withOccupation("Professor")
        withAddress("Golden Avenue")
        build()
    }

    println(alice.getDescription())
    println(bob.getDescription())
}