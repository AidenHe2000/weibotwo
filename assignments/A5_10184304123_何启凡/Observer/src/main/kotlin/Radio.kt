class Radio {
    private var currentContent = RadioContent.NEWS
    private val radioObservers = mutableListOf<RadioListener>()

    fun addObserver(radioListener: RadioListener) {
        radioObservers += radioListener
    }

    fun removeObserver(radioListener: RadioListener) {
        radioObservers -= radioListener
    }

    fun changeChannel() {
        currentContent = when (currentContent) {
            RadioContent.NEWS -> RadioContent.MUSIC
            RadioContent.MUSIC -> RadioContent.INTERVIEW
            RadioContent.INTERVIEW -> RadioContent.NEWS
        }
        sendSignal()
    }

    private fun sendSignal() {
        for (observer in radioObservers) {
            observer.update(currentContent)
        }
    }
}