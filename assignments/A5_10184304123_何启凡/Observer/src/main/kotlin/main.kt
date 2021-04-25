class Alice : RadioListener {
    override fun update(radioContent: RadioContent) {
        println("Alice is listening to the ${radioContent.toString()} on the radio.")
    }
}

class Bob : RadioListener {
    override fun update(radioContent: RadioContent) {
        println("Bob is listening to the ${radioContent.toString()} on the radio.")
    }
}

fun main(args: Array<String>) {
    val radio = Radio()
    radio.addObserver(Alice())
    radio.addObserver(Bob())
    radio.changeChannel()
    radio.changeChannel()
    radio.changeChannel()
    radio.changeChannel()
}